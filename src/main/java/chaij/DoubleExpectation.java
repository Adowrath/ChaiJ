package chaij;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.DoublePredicate;

public class DoubleExpectation {
	
	public static final Set<String> unimplementedFunctions;
	
	//@formatter:off
	static {
		unimplementedFunctions = new HashSet<>();
		unimplementedFunctions
				.addAll(Arrays.asList(	
//				                      	"above",
				                      	"all",
				                      	"any",
//				                      	"below",
//				                      	"closeTo",
//										"equal",
//				                      	"finite",
//				                      	"infinite",
//										"least",
//										"match",
//										"most",
//				                      	"NaN",
//										"not",
//										"oneOf",
//										"satisfy",
//										"within",
										""
										));
	}
	//@formatter:on
	
	public final DoubleExpectation to = this;
	public final DoubleExpectation be = this;
	public final DoubleExpectation been = this;
	public final DoubleExpectation is = this;
	public final DoubleExpectation that = this;
	public final DoubleExpectation which = this;
	public final DoubleExpectation and = this;
	public final DoubleExpectation has = this;
	public final DoubleExpectation have = this;
	public final DoubleExpectation with = this;
	public final DoubleExpectation at = this;
	public final DoubleExpectation of = this;
	public final DoubleExpectation same = this;
	
	private boolean notFlag = false;
	
	private final double my;
	
	public DoubleExpectation(double i) {
		my = i;
	}
	
	public DoubleExpectation(double i, String s) {
		my = i;
	}
	
	protected DoubleExpectation test(	boolean result,
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
	 * <pre>expect(42.0).to.equal(13.0);</pre>
	 * 
	 * fails,
	 * 
	 * <pre>expect(42.0).to.not().equal(13.0);</pre>
	 * 
	 * succeeds.
	 * 
	 * @return the expectation itself for chaining
	 */
	//@formatter:on
	public DoubleExpectation not() {
		this.notFlag = !notFlag;
		return this;
	}
	
	/**
	 * any - some method (currently not implemented!)
	 */
	public DoubleExpectation any() {
		throw new UnsupportedOperationException("any");
	}
	
	/**
	 * all - some method (currently not implemented!)
	 */
	public DoubleExpectation all() {
		throw new UnsupportedOperationException("all");
	}
	
	/**
	 * Checks whether the {@code double} is finite, i.e. a real number
	 * and neither {@link Double#POSITIVE_INFINITY},
	 * {@link Double#NEGATIVE_INFINITY} nor {@link Double#NaN}.
	 * 
	 * @return the expectation itself for chaining
	 * @see Double#isFinite(double)
	 */
	public DoubleExpectation finite() {
		return test(Double.isFinite(my), "Expected " + my + " to",
					"be finite.");
	}
	
	/**
	 * Checks whether the {@code double} is either
	 * {@link Double#POSITIVE_INFINITY} or
	 * {@link Double#NEGATIVE_INFINITY}.
	 * 
	 * @return the expectation itself for chaining
	 * @see Double#isInfinite(double)
	 */
	public DoubleExpectation infinite() {
		return test(Double.isInfinite(my), "Expected " + my + " to",
					"be infinite.");
	}
	
	/**
	 * Checks whether the {@code double} is {@link Double#NaN}.
	 * 
	 * @return the expectation itself for chaining
	 * @see Double#isNaN(double)
	 */
	public DoubleExpectation NaN() {
		return test(Double.isNaN(my), "Expected " + my + " to", "be NaN.");
	}
	
	/**
	 * Checks whether the {@code double} is equal to {@code expected}.
	 * 
	 * @param expected
	 *        the other value that should be compared with
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation equal(double expected) {
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + ".");
	}
	
	/**
	 * Checks whether the {@code double} is above {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the biggest value that is too small
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation above(double lowerBound) {
		return test(my > lowerBound, "Expected " + my + " to",
					"be above " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code double} is at least
	 * {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the smallest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation least(double lowerBound) {
		return test(my >= lowerBound, "Expected " + my + " to",
					"be at least " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code double} is below {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the smallest value that is too big
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation below(double upperBound) {
		return test(my < upperBound, "Expected " + my + " to",
					"be below " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code double} is at most
	 * {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the biggest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation most(double upperBound) {
		return test(my <= upperBound, "Expected " + my + " to",
					"be at most " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code double} is within {@code min} and
	 * {@code max}, both inclusive.
	 * 
	 * @param min
	 *        the minimum value
	 * @param max
	 *        the maximum value
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation within(double min, double max) {
		return test(min <= my && my <= max, "Expected " + my + " to",
					"be within " + min + " and " + max + ".");
	}
	
	/**
	 * Checks whether the {@code double} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code double} with
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation match(DoublePredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"match a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code double} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code double} with
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation satisfy(DoublePredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"satisfy a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code double} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 * 
	 * @param expected
	 *        the expected value to which it should be close
	 * @param delta
	 *        the maximum distance the two values can have
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation closeTo(double expected, double delta) {
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
							+ ".");
	}
	
	/**
	 * Checks whether the {@code double} is part of the array.
	 * 
	 * @param arr
	 *        the array of the possible values
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation oneOf(double[] arr) {
		boolean found = false;
		int length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
					"be one of " + Arrays.toString(arr) + ".");
	}
	
}
