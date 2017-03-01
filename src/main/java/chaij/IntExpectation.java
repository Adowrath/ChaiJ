package chaij;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;

public class IntExpectation {
	
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
//										"least",
//										"match",
//										"most",
//										"not",
//										"oneOf",
//										"satisfy",
//				                      	"validByte",
//				                      	"validShort",
//										"within",
										""
										));
	}
	//@formatter:on
	
	public final IntExpectation to = this;
	public final IntExpectation be = this;
	public final IntExpectation been = this;
	public final IntExpectation is = this;
	public final IntExpectation that = this;
	public final IntExpectation which = this;
	public final IntExpectation and = this;
	public final IntExpectation has = this;
	public final IntExpectation have = this;
	public final IntExpectation with = this;
	public final IntExpectation at = this;
	public final IntExpectation of = this;
	public final IntExpectation same = this;
	
	private boolean notFlag = false;
	
	private final int my;
	
	public IntExpectation(int i) {
		my = i;
	}
	
	public IntExpectation(int i, String s) {
		my = i;
	}
	
	protected IntExpectation test(	boolean result,
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
	 * <pre>expect(42).to.equal(13);</pre>
	 * 
	 * fails,
	 * 
	 * <pre>expect(42).to.not().equal(13);</pre>
	 * 
	 * succeeds.
	 * 
	 * @return the expectation itself for chaining
	 */
	//@formatter:on
	public IntExpectation not() {
		this.notFlag = !notFlag;
		return this;
	}
	
	/**
	 * any - some method (currently not implemented!)
	 */
	public IntExpectation any() {
		throw new UnsupportedOperationException("any");
	}
	
	/**
	 * all - some method (currently not implemented!)
	 */
	public IntExpectation all() {
		throw new UnsupportedOperationException("all");
	}
	
	/**
	 * Checks whether the {@code int} is equal to {@code expected}.
	 * 
	 * @param expected
	 *        the other value that should be compared with
	 * @return the expectation itself for chaining
	 */
	public IntExpectation equal(int expected) {
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + ".");
	}
	
	/**
	 * Checks whether the {@code int} is above {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the biggest value that is too small
	 * @return the expectation itself for chaining
	 */
	public IntExpectation above(int lowerBound) {
		return test(my > lowerBound, "Expected " + my + " to",
					"be above " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code int} is at least {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the smallest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public IntExpectation least(int lowerBound) {
		return test(my >= lowerBound, "Expected " + my + " to",
					"be at least " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code int} is below {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the smallest value that is too big
	 * @return the expectation itself for chaining
	 */
	public IntExpectation below(int upperBound) {
		return test(my < upperBound, "Expected " + my + " to",
					"be below " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code int} is at most {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the biggest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public IntExpectation most(int upperBound) {
		return test(my <= upperBound, "Expected " + my + " to",
					"be at most " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code int} is within {@code min} and
	 * {@code max}, both inclusive.
	 * 
	 * @param min
	 *        the minimum value
	 * @param max
	 *        the maximum value
	 * @return the expectation itself for chaining
	 */
	public IntExpectation within(int min, int max) {
		return test(min <= my && my <= max, "Expected " + my + " to",
					"be within " + min + " and " + max + ".");
	}
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code int} with
	 * @return the expectation itself for chaining
	 */
	public IntExpectation match(IntPredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"match a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code int} with
	 * @return the expectation itself for chaining
	 */
	public IntExpectation satisfy(IntPredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"satisfy a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code int} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 * 
	 * @param expected
	 *        the expected value to which it should be close
	 * @param delta
	 *        the maximum distance the two values can have
	 * @return the expectation itself for chaining
	 */
	public IntExpectation closeTo(int expected, int delta) {
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
							+ ".");
	}
	
	/**
	 * Checks whether the {@code int} is part of the array.
	 * 
	 * @param arr
	 *        the array of the possible values
	 * @return the expectation itself for chaining
	 */
	public IntExpectation oneOf(int[] arr) {
		boolean found = false;
		int length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
					"be one of " + Arrays.toString(arr) + ".");
	}
	
	/**
	 * Checks whether the {@code int} represents a valid {@code byte}
	 * value.
	 * 
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validByte() {
		return test(Byte.MIN_VALUE <= my && my <= Byte.MAX_VALUE,
					"Expected " + my + " to", " be a valid byte value.");
	}
	
	/**
	 * Checks whether the {@code int} represents a valid {@code short}
	 * value.
	 * 
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validShort() {
		return test(Short.MIN_VALUE <= my && my <= Short.MAX_VALUE,
					"Expected " + my + " to", " be a valid short value.");
	}
	
}
