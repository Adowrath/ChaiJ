package chaij;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.LongPredicate;

public class LongExpectation {
	
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
//										"within",
										""
										));
	}
	//@formatter:on
	
	public final LongExpectation to = this;
	public final LongExpectation be = this;
	public final LongExpectation been = this;
	public final LongExpectation is = this;
	public final LongExpectation that = this;
	public final LongExpectation which = this;
	public final LongExpectation and = this;
	public final LongExpectation has = this;
	public final LongExpectation have = this;
	public final LongExpectation with = this;
	public final LongExpectation at = this;
	public final LongExpectation of = this;
	public final LongExpectation same = this;
	
	private boolean notFlag = false;
	
	private final long my;
	
	public LongExpectation(long l) {
		my = l;
	}
	
	public LongExpectation(long l, String s) {
		my = l;
	}
	
	protected LongExpectation test(	boolean result,
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
	 * <pre>expect(42L).to.equal(13L);</pre>
	 * 
	 * fails,
	 * 
	 * <pre>expect(42L).to.not().equal(13L);</pre>
	 * 
	 * succeeds.
	 * 
	 * @return the expectation itself for chaining
	 */
	//@formatter:on
	public LongExpectation not() {
		this.notFlag = !notFlag;
		return this;
	}
	
	/**
	 * any - some method (currently not implemented!)
	 */
	public LongExpectation any() {
		throw new UnsupportedOperationException("any");
	}
	
	/**
	 * all - some method (currently not implemented!)
	 */
	public LongExpectation all() {
		throw new UnsupportedOperationException("all");
	}
	
	/**
	 * Checks whether the {@code long} is equal to {@code expected}.
	 * 
	 * @param expected
	 *        the other value that should be compared with
	 * @return the expectation itself for chaining
	 */
	public LongExpectation equal(long expected) {
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + ".");
	}
	
	/**
	 * Checks whether the {@code long} is above {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the biggest value that is too small
	 * @return the expectation itself for chaining
	 */
	public LongExpectation above(long lowerBound) {
		return test(my > lowerBound, "Expected " + my + " to",
					"be above " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code long} is at least {@code upperBound}.
	 * 
	 * @param lowerBound
	 *        the smallest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public LongExpectation least(long lowerBound) {
		return test(my >= lowerBound, "Expected " + my + " to",
					"be at least " + lowerBound + ".");
	}
	
	/**
	 * Checks whether the {@code long} is below {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the smallest value that is too big
	 * @return the expectation itself for chaining
	 */
	public LongExpectation below(long upperBound) {
		return test(my < upperBound, "Expected " + my + " to",
					"be below " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code long} is at most {@code upperBound}.
	 * 
	 * @param upperBound
	 *        the biggest value that is allowed
	 * @return the expectation itself for chaining
	 */
	public LongExpectation most(long upperBound) {
		return test(my <= upperBound, "Expected " + my + " to",
					"be at most " + upperBound + ".");
	}
	
	/**
	 * Checks whether the {@code long} is within {@code min} and
	 * {@code max}, both inclusive.
	 * 
	 * @param min
	 *        the minimum value
	 * @param max
	 *        the maximum value
	 * @return the expectation itself for chaining
	 */
	public LongExpectation within(long min, long max) {
		return test(min <= my && my <= max, "Expected " + my + " to",
					"be within " + min + " and " + max + ".");
	}
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code long} with
	 * @return the expectation itself for chaining
	 */
	public LongExpectation match(LongPredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"match a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate}.
	 * 
	 * @param predicate
	 *        the predicate to check the {@code long} with
	 * @return the expectation itself for chaining
	 */
	public LongExpectation satisfy(LongPredicate predicate) {
		return test(predicate.test(my), "Expected " + my + " to",
					"satisfy a custom predicate.");
	}
	
	/**
	 * Checks whether the {@code long} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 * 
	 * @param expected
	 *        the expected value to which it should be close
	 * @param delta
	 *        the maximum distance the two values can have
	 * @return the expectation itself for chaining
	 */
	public LongExpectation closeTo(long expected, long delta) {
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
							+ ".");
	}
	
	/**
	 * Checks whether the {@code long} is part of the array.
	 * 
	 * @param arr
	 *        the array of the possible values
	 * @return the expectation itself for chaining
	 */
	public LongExpectation oneOf(long[] arr) {
		boolean found = false;
		long length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
					"be one of " + Arrays.toString(arr) + ".");
	}
	
}
