package chaij;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanExpectation {
	
	public static final Set<String> unimplementedFunctions;
	
	//@formatter:off
	static {
		unimplementedFunctions = new HashSet<>();
		unimplementedFunctions
				.addAll(Arrays.asList(	
//				                      	"not",
				                      	"any",
				                      	"all",
//				                      	"ok",
//				                      	"_true",
//				                      	"_false",
//				                      	"equal",
										""
										));
	}
	//@formatter:on
	
	public final BooleanExpectation to = this;
	public final BooleanExpectation be = this;
	public final BooleanExpectation been = this;
	public final BooleanExpectation is = this;
	public final BooleanExpectation that = this;
	public final BooleanExpectation which = this;
	public final BooleanExpectation and = this;
	public final BooleanExpectation has = this;
	public final BooleanExpectation have = this;
	public final BooleanExpectation with = this;
	public final BooleanExpectation at = this;
	public final BooleanExpectation of = this;
	public final BooleanExpectation same = this;
	
	private final boolean my;
	
	private boolean notFlag;
	
	public BooleanExpectation(boolean b) {
		my = b;
	}
	
	public BooleanExpectation(boolean b, String s) {
		my = b;
	}
	
	protected BooleanExpectation test(	boolean result,
										String firstPart,
										String secondPart) {
		if(result ^ notFlag) {
			return this;
		}
		throw new UnmetExpectationException(firstPart
				+ (notFlag ? " not " : " ") + secondPart);
	}
	
	//@formatter:off
	/**
	 * Negates the behaviour of any further expectations.
	 * 
	 * <p>
	 * E.g. while
	 * 
	 * <pre>expect(true).to.equal(false);</pre>
	 * 
	 * fails,
	 * 
	 * <pre>expect(true).to.not().equal(false);</pre>
	 * 
	 * succeeds.
	 * 
	 * @return the expectation itself for chaining
	 */
	//@formatter:on
	public BooleanExpectation not() {
		this.notFlag = !notFlag;
		return this;
	}
	
	/**
	 * any - some method (currently not implemented!)
	 */
	public BooleanExpectation any() {
		throw new UnsupportedOperationException("any");
	}
	
	/**
	 * all - some method (currently not implemented!)
	 */
	public BooleanExpectation all() {
		throw new UnsupportedOperationException("all");
	}
	
	/**
	 * Checks whether the {@code boolean} is {@code true}.
	 * 
	 * @return the expectation itself for chaining
	 * @see #_true()
	 */
	public BooleanExpectation ok() {
		return test(my, "Expected a", "ok-ish boolean.");
	}
	
	/**
	 * Checks whether the {@code boolean} is {@code true}.
	 * 
	 * @return the expectation itself for chaining
	 * @see #ok()
	 */
	public BooleanExpectation _true() {
		return test(my, "Expected a", "true boolean.");
	}
	
	/**
	 * Checks whether the {@code boolean} is {@code false}.
	 * 
	 * @return the expectation itself for chaining
	 */
	public BooleanExpectation _false() {
		return test(!my, "Expected a", "false boolean.");
	}
	
	/**
	 * Checks whether the {@code boolean} is equal to {@code boolean}.
	 * 
	 * @param expected
	 *        the other value that should be compared with
	 * @return the expectation itself for chaining
	 * @see #_false()
	 * @see #_true()
	 * @see #ok()
	 */
	public BooleanExpectation equal(boolean expected) {
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + ".");
	}
}
