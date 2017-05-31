package chaij;


import java.util.function.Supplier;

/**
 * The base class for all expectations, providing essential methods
 * such as {@link #test(boolean, String, String)} and the {@link #not()} toggle
 * and all the standard linker words.
 *
 * @param <Self> this should be a self-referential type, i.e. if you extend
 *               this class with class {@code A}, extend
 *               it by {@code extends BaseExpectation<A>}
 *
 * @since 0.0.1
 */
@SuppressWarnings({"unchecked", "PublicField"})
public abstract class BaseExpectation<Self extends BaseExpectation<Self>> {
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self to = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self be = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self been = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self is = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self that = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self which = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self and = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self has = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self have = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self with = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self at = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self of = (Self) this;
	
	/**
	 * A normal linker word, it does not do anything.
	 */
	public final Self same = (Self) this;
	
	private boolean notFlag = false;
	
	/**
	 * A custom text that is associated with
	 * this expectation (or null if none is).
	 */
	protected final String customText;
	
	
	/**
	 * Another constructor. There are so many!
	 *
	 * @param customText the custom text for this expectation,
	 *                   or {@code null} if none is wished.
	 */
	protected BaseExpectation(String customText) {
		
		this.customText = customText;
	}
	
	
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
	 * @param firstPart  the first part of the string, preferably describing
	 *                   or including the actual state
	 * @param secondPart the second part of the string, preferably describing
	 *                   the expectation
	 *
	 * @return the Expectation object itself so it can be more easily used, see
	 * above for an example
	 *
	 * @see #not()
	 */
	protected final Self test(boolean result,
	                          String firstPart,
	                          String secondPart) {
		
		return test(result, null, firstPart, () -> secondPart);
	}
	
	
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
	 *         return test(actual, "Custom message", "Expected a", "true value.");
	 *     }
	 * }
	 *
	 * TrueExpectation te = new TrueExpectation();
	 * te.testTrue(true); // false would give "Custom message: Expected a true value."
	 * te.not().testTrue(false); // true would give "Custom message: Expected a not true value."
	 * </pre></div>
	 *
	 * @param result     the result of the test that called this method
	 * @param message    a custom message that is prepended (if null,
	 *                   nothing will be prepended, so you can also
	 *                   use {@link #test(boolean, String, String)}
	 * @param firstPart  the first part of the string, preferably describing
	 *                   or including the actual state
	 * @param secondPart the second part of the string, preferably describing
	 *                   the expectation
	 *
	 * @return the Expectation object itself so it can be more easily used, see
	 * above for an example
	 *
	 * @see #not()
	 */
	protected final Self test(boolean result,
	                          String message,
	                          String firstPart,
	                          String secondPart) {
		
		return test(result, message, firstPart, () -> secondPart);
	}
	
	
	/**
	 * This is the central method that decides whether or not to let a test
	 * pass based on the {@code result} and the current {@link #notFlag} value.
	 *
	 * <p>
	 * Between the two string parts, either {@code " not "} or {@code " "} will be inserted
	 * in case of failure, depending on the value of the {@linkplain #notFlag not} flag.
	 *
	 * <p>
	 * The specialty of this method is that, compared to the others, the second string
	 * can be passed as a lambda, thus supporting the use case of there being an expensive
	 * computation in constructing the second string part that is of course not needed
	 * if the test is successful.
	 *
	 * <p>
	 * An example usage of this might be the following:
	 *
	 * <div class="example"><pre>
	 * public class TrueExpectation extends BaseExpectation{@code <TrueExpectation>} {
	 *     public TrueExpectation testTrue(boolean actual) {
	 *         return test(actual, "Custom message", "Expected a",
	 *                     (){@literal ->} expensiveCalculation() + " value.");
	 *     }
	 * }
	 *
	 * TrueExpectation te = new TrueExpectation();
	 * te.testTrue(true); // false would give "Custom message: Expected a [expensive calc result here] value."
	 * te.not().testTrue(false); // true would give "Custom message: Expected a not [expensive calc result here] value."
	 * </pre></div>
	 *
	 * @param result     the result of the test that called this method
	 * @param message    a custom message that is prepended (if null,
	 *                   nothing will be prepended, so you can also
	 *                   use {@link #test(boolean, String, String)}
	 * @param firstPart  the first part of the string, preferably describing
	 *                   or including the actual state
	 * @param secondPart the second part of the string, preferably describing
	 *                   the expectation, passed as a {@link java.util.function.Supplier}
	 *
	 * @return the Expectation object itself so it can be more easily used, see
	 * above for an example
	 *
	 * @see #not()
	 */
	protected final Self test(boolean result,
	                          String message,
	                          String firstPart,
	                          Supplier<String> secondPart) {
		
		if(result == notFlag) {
			//noinspection StringConcatenationMissingWhitespace
			BaseExpectation.signalError(
					new UnmetExpectationException((message == null ?
					                               customText == null ?
					                               "" :
					                               customText + ": " :
					                               message + ": ")
					                              + firstPart
					                              + (notFlag ? " not " : " ")
					                              + secondPart.get()
					));
		}
		return (Self) this;
	}
	
	
	/**
	 * Signals an exception to the {@link chaij.ExceptionReporter} facility.
	 *
	 * @param exception the expectation that was not met, either containing a
	 *                  description of the mismatch or, if any method called
	 *                  during the test throws an exception, it wraps that method.
	 */
	private static void signalError(ChaiJException exception) {
		
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
	public final Self not() {
		
		notFlag = !notFlag;
		return (Self) this;
	}
}
