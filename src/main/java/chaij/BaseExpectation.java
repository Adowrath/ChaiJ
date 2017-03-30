package chaij;


/**
 * The base class for all expectations, providing essential methods
 * such as {@link #test(boolean, String, String)} and the {@link #not()} toggle
 * and all the standard linker words.
 *
 * @param <Exp> this should be a self-referential type, i.e. if you extend
 *              this class with class {@code A}, extend
 *              it by {@code extends BaseExpectation<A>}
 */
@SuppressWarnings({"unchecked", "PublicField"})
public abstract class BaseExpectation<Exp extends BaseExpectation<Exp>> {
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp to = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp be = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp been = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp is = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp that = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp which = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp and = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp has = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp have = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp with = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp at = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp of = (Exp) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Exp same = (Exp) this;
	
	private boolean notFlag = false;
	
	
	/**
	 * This is the central method that decides whether or not to let a test
	 * pass based on the {@code result} and the current {@link #notFlag} value.
	 *
	 * <p>
	 * Between the two string parts, either {@code " not "} or {@code " "} will be inserted
	 * in case of failure, depending on the value of the {@linkplain #notFlag not} flag.
	 *
	 * <p>
	 * An example usage of this might be the following:
	 *
	 * <div class="example"><pre>
	 * public class TrueExpectation extends BaseExpectation{@code <TrueExpectation>} {
	 *     public TrueExpectation testTrue(boolean actual) {
	 *         return test(actual, "Expected a", "true value.");
	 *     }
	 * }
	 *
	 * TrueExpectation te = new TrueExpectation();
	 * te.testTrue(true); // false would give "Expected a true value."
	 * te.not().testTrue(false); // true would give "Expected a not true value."
	 * </pre></div>
	 *
	 * @param result     the result of the test that called this method
	 * @param firstPart  the first part of the string, preferrably describing
	 *                   or including the actual state
	 * @param secondPart the second part of the string, preferrably describing
	 *                   the expectation
	 *
	 * @return the Expectation object itself so it can be more easily used, see
	 * above for an example
	 *
	 * @see #not()
	 */
	protected final Exp test(boolean result,
							 String firstPart,
							 String secondPart) {
		
		if(result == notFlag) {
			signalError(new UnmetExpectationException(firstPart
													  + (notFlag ? " not " : " ") + secondPart));
		}
		//noinspection unchecked
		return (Exp) this;
	}
	
	
	/**
	 * Signals an exception to the {@link chaij.ExceptionReporter} facility.
	 *
	 * @param exception the expectation that was not met, either containing a
	 *                  description of the mismatch or, if any method called
	 *                  during the test throws an exception, it wraps that method.
	 */
	private static void signalError(UnmetExpectationException exception) {
		
		ExceptionReporter.reportException(exception);
	}
	
	//@formatter:off
	/**
	 * Negates the behaviour of any further expectations.
	 *
	 * <p>
	 * E.g. while
	 *
	 * <pre>expect(42).to.equal(43);</pre>
	 *
	 * fails,
	 *
	 * <pre>expect(42).to.not().equal(43);</pre>
	 *
	 * succeeds.
	 *
	 * <p>
	 * Contrary to chai's original <a href="http://chaijs.com/api/bdd/#method_not">not</a>
	 * implementation, this method actually toggles, so using .not().not() is the same as
	 * doing nothing.
	 *
	 * @return the expectation itself for chaining
	 */
	//@formatter:on
	public final Exp not() {
		
		notFlag = !notFlag;
		return (Exp) this;
	}
}
