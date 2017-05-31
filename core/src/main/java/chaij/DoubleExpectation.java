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
 *
 * @since 0.0.1
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
		
		super(s);
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
		
		return finite(null);
	}
	
	
	/**
	 * Checks whether the {@code double} is finite, i.e. a real number
	 * and neither {@link Double#POSITIVE_INFINITY},
	 * {@link Double#NEGATIVE_INFINITY} nor {@link Double#NaN}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isFinite(double)
	 */
	public DoubleExpectation finite(String message) {
		
		return test(Double.isFinite(my),
		            message,
		            "Expected " + my + " to",
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
		
		return infinite(null);
	}
	
	
	/**
	 * Checks whether the {@code double} is either
	 * {@link Double#POSITIVE_INFINITY} or
	 * {@link Double#NEGATIVE_INFINITY}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isInfinite(double)
	 */
	public DoubleExpectation infinite(String message) {
		
		return test(Double.isInfinite(my),
		            message,
		            "Expected " + my + " to",
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
		
		return NaN(null);
	}
	
	
	/**
	 * Checks whether the {@code double} is {@link Double#NaN}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see Double#isNaN(double)
	 */
	@SuppressWarnings("InstanceMethodNamingConvention")
	public DoubleExpectation NaN(String message) {
		
		return test(Double.isNaN(my),
		            message,
		            "Expected " + my + " to",
		            "be NaN."
		);
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
		
		return equal(expected, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is equal to {@code expected}
	 * with a custom message.
	 *
	 * @param expected the other value that should be compared with
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation equal(double expected, String message) {
		
		//noinspection FloatingPointEquality
		return test(my == expected,
		            message,
		            "Expected " + my + " to",
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
		
		return above(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is above {@code upperBound}
	 * with a custom message.
	 *
	 * @param lowerBound the biggest value that is too small
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation above(double lowerBound, String message) {
		
		return test(my > lowerBound,
		            message,
		            "Expected " + my + " to",
		            "be above " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is at least {@code upperBound}.
	 *
	 * @param lowerBound the smallest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation least(double lowerBound) {
		
		return least(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is at least {@code upperBound}
	 * with a custom message.
	 *
	 * @param lowerBound the smallest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation least(double lowerBound, String message) {
		
		return test(my >= lowerBound,
		            message,
		            "Expected " + my + " to",
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
		
		return below(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is below {@code upperBound}
	 * with a custom message.
	 *
	 * @param upperBound the smallest value that is too big
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation below(double upperBound, String message) {
		
		return test(my < upperBound,
		            message,
		            "Expected " + my + " to",
		            "be below " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is at most {@code upperBound}.
	 *
	 * @param upperBound the biggest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation most(double upperBound) {
		
		return most(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is at most {@code upperBound}
	 * with a custom message.
	 *
	 * @param upperBound the biggest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation most(double upperBound, String message) {
		
		return test(my <= upperBound,
		            message,
		            "Expected " + my + " to",
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
		
		return within(min, max, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is within {@code min} and
	 * {@code max}, both inclusive with a custom message.
	 *
	 * @param min     the minimum value
	 * @param max     the maximum value
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation within(double min, double max, String message) {
		
		return test((min <= my) && (my <= max),
		            message,
		            "Expected " + my + " to",
		            "be within " + min + " and " + max + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} matches the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code double} with
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation match(DoublePredicate predicate) {
		
		return match(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code double} matches the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code double} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation match(DoublePredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
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
		
		return satisfy(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code double} satisfies the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code double} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation satisfy(DoublePredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
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
		
		return closeTo(expected, delta, null);
	}
	
	
	/**
	 * Checks whether the {@code double} is close to {@code expected}
	 * with a maximum distance of {@code delta} with a custom message.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public DoubleExpectation closeTo(double expected, double delta, String message) {
		
		return test(Math.abs(my - expected) <= delta,
		            message,
		            "Expected " + my + " to",
		            "be close to " + expected + " with a delta of " + delta + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code double} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("OverloadedVarargsMethod")
	public DoubleExpectation oneOf(double... arr) {
		
		return oneOf(null, arr);
	}
	
	
	/**
	 * Checks whether the {@code double} is part of the array
	 * with a custom message.
	 *
	 * <p>
	 * Note the different order for the parameters!
	 *
	 * @param message a custom message specifically for this check
	 * @param arr     the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("OverloadedVarargsMethod")
	public DoubleExpectation oneOf(String message, double... arr) {
		
		boolean found = false;
		int length = arr.length;
		for(int i = 0; (i < length) && !found; ++i) {
			//noinspection FloatingPointEquality
			found = arr[i] == my;
		}
		return test(found,
		            message,
		            "Expected " + my + " to",
		            "be one of " + Arrays.toString(arr) + '.'
		);
	}
	
	
	@Override
	public String toString() {
		
		return String.format("DoubleExpectation(value=%f, customText=%s)",
		                     my, customText
		);
	}
}
