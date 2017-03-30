package chaij;


import java.util.Arrays;
import java.util.function.DoublePredicate;

/**
 * A {@code double} expectation offers all methods that are available on all
 * numeric types - e.g. {@link #above(double)}, {@link #oneOf(double...)}
 * etc., but also some floating point-specific methods like {@link #NaN()},
 * {@link #finite()} etc.
 *
 * <p>
 * Note that there is no special expectation for {@code float} values because
 * there always exists a promotion from {@code float} to {@code double}.
 */
public final class DoubleExpectation extends BaseExpectation<DoubleExpectation> {
	
	private final double my;
	
	
	/**
	 * Constructs a new DoubleExpectation.
	 *
	 * <p>
	 * You should not use this constructor directly, but instead get
	 * an expectation through {@link chaij.ChaiJ#expect(double)} or
	 * {@link chaij.ChaiJ#expect(double, java.lang.String)}
	 *
	 * @param d the {@code double} that is used for all operations
	 * @param s an optional custom expectation message.
	 */
	DoubleExpectation(double d, String s) {
		
		my = d;
	}
	
	
	/**
	 * Checks whether the {@code double} is finite, i.e. a real number
	 * and neither {@link Double#POSITIVE_INFINITY},
	 * {@link Double#NEGATIVE_INFINITY} nor {@link Double#NaN}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isFinite(double)
	 */
	public DoubleExpectation finite() {
		
		return test(Double.isFinite(my), "Expected " + my + " to",
					"be finite."
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is either
	 * {@link Double#POSITIVE_INFINITY} or
	 * {@link Double#NEGATIVE_INFINITY}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isInfinite(double)
	 */
	public DoubleExpectation infinite() {
		
		return test(Double.isInfinite(my), "Expected " + my + " to",
					"be infinite."
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is {@link Double#NaN}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isNaN(double)
	 */
	@SuppressWarnings("InstanceMethodNamingConvention")
	public DoubleExpectation NaN() {
		
		return test(Double.isNaN(my), "Expected " + my + " to", "be NaN.");
	}
	
	
	/**
	 * Checks whether the {@code double} is equal to {@code expected}.
	 *
	 * @param expected the other value that should be compared with
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("MisspelledEquals")
	public DoubleExpectation equal(double expected) {
		
		//noinspection FloatingPointEquality
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is above {@code upperBound}.
	 *
	 * @param lowerBound the biggest value that is too small
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation above(double lowerBound) {
		
		return test(my > lowerBound, "Expected " + my + " to",
					"be above " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is at least
	 * {@code upperBound}.
	 *
	 * @param lowerBound the smallest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation least(double lowerBound) {
		
		return test(my >= lowerBound, "Expected " + my + " to",
					"be at least " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is below {@code upperBound}.
	 *
	 * @param upperBound the smallest value that is too big
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation below(double upperBound) {
		
		return test(my < upperBound, "Expected " + my + " to",
					"be below " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is at most
	 * {@code upperBound}.
	 *
	 * @param upperBound the biggest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation most(double upperBound) {
		
		return test(my <= upperBound, "Expected " + my + " to",
					"be at most " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is within {@code min} and
	 * {@code max}, both inclusive.
	 *
	 * @param min the minimum value
	 * @param max the maximum value
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation within(double min, double max) {
		
		return test(min <= my && my <= max, "Expected " + my + " to",
					"be within " + min + " and " + max + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code double} with
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation match(DoublePredicate predicate) {
		
		return test(predicate.test(my), "Expected " + my + " to",
					"match a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code double} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code double} with
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation satisfy(DoublePredicate predicate) {
		
		return test(predicate.test(my), "Expected " + my + " to",
					"satisfy a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation closeTo(double expected, double delta) {
		
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
					+ '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation oneOf(double... arr) {
		
		boolean found = false;
		int length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			//noinspection FloatingPointEquality
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
					"be one of " + Arrays.toString(arr) + '.'
		);
	}
	
}
