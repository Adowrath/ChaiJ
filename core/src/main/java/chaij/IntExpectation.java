package chaij;


import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * An {@code int} expectation offers all methods that are available on all
 * numeric types - e.g. {@link #above(int)}, {@link #oneOf(int...)}
 * etc., but also validity checkers such as the {@link #validByte()} and
 * {@link #validShort()} methods.
 *
 * @since 0.0.1
 */
public final class IntExpectation extends BaseExpectation<IntExpectation> {
	
	private final int my;
	
	
	/**
	 * Constructs a new IntExpectation.
	 *
	 * <p>
	 * You should not use this constructor directly, but instead get
	 * an expectation through {@link chaij.ChaiJ#expect(int)} or
	 * {@link chaij.ChaiJ#expect(int, java.lang.String)}
	 *
	 * @param i the {@code int} that is used for all operations
	 * @param s an optional custom expectation message.
	 */
	IntExpectation(int i, String s) {
		
		super(s);
		my = i;
	}
	
	
	/**
	 * Checks whether the {@code int} is equal to {@code expected}.
	 *
	 * @param expected the other value that should be compared with
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("MisspelledEquals")
	public IntExpectation equal(int expected) {
		
		return equal(expected, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is equal to {@code expected}
	 * with a custom message.
	 *
	 * @param expected the other value that should be compared with
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation equal(int expected, String message) {
		
		return test(my == expected,
		            message,
		            "Expected " + my + " to",
		            "equal " + expected + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is above {@code upperBound}.
	 *
	 * @param lowerBound the biggest value that is too small
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation above(int lowerBound) {
		
		return above(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is above {@code upperBound}
	 * with a custom message.
	 *
	 * @param lowerBound the biggest value that is too small
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation above(int lowerBound, String message) {
		
		return test(my > lowerBound,
		            message,
		            "Expected " + my + " to",
		            "be above " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is at least {@code upperBound}.
	 *
	 * @param lowerBound the smallest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation least(int lowerBound) {
		
		return least(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is at least {@code upperBound}
	 * with a custom message.
	 *
	 * @param lowerBound the smallest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation least(int lowerBound, String message) {
		
		return test(my >= lowerBound,
		            message,
		            "Expected " + my + " to",
		            "be at least " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is below {@code upperBound}.
	 *
	 * @param upperBound the smallest value that is too big
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation below(int upperBound) {
		
		return below(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is below {@code upperBound}
	 * with a custom message.
	 *
	 * @param upperBound the smallest value that is too big
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation below(int upperBound, String message) {
		
		return test(my < upperBound,
		            message,
		            "Expected " + my + " to",
		            "be below " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is at most {@code upperBound}.
	 *
	 * @param upperBound the biggest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation most(int upperBound) {
		
		return most(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is at most {@code upperBound}
	 * with a custom message.
	 *
	 * @param upperBound the biggest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation most(int upperBound, String message) {
		
		return test(my <= upperBound,
		            message,
		            "Expected " + my + " to",
		            "be at most " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is within {@code min} and
	 * {@code max}, both inclusive.
	 *
	 * @param min the minimum value
	 * @param max the maximum value
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation within(int min, int max) {
		
		return within(min, max, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is within {@code min} and
	 * {@code max}, both inclusive with a custom message.
	 *
	 * @param min     the minimum value
	 * @param max     the maximum value
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation within(int min, int max, String message) {
		
		return test((min <= my) && (my <= max),
		            message,
		            "Expected " + my + " to",
		            "be within " + min + " and " + max + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code int} with
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation match(IntPredicate predicate) {
		
		return match(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code int} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation match(IntPredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
		            "match a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code int} with
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation satisfy(IntPredicate predicate) {
		
		return satisfy(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code int} satisfies the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code int} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation satisfy(IntPredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
		            "satisfy a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation closeTo(int expected, int delta) {
		
		return closeTo(expected, delta, null);
	}
	
	
	/**
	 * Checks whether the {@code int} is close to {@code expected}
	 * with a maximum distance of {@code delta} with a custom message.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation closeTo(int expected, int delta, String message) {
		
		return test(Math.abs(my - expected) <= delta,
		            message,
		            "Expected " + my + " to",
		            "be close to " + expected + " with a delta of " + delta + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("OverloadedVarargsMethod")
	public IntExpectation oneOf(int... arr) {
		
		return oneOf(null, arr);
	}
	
	
	/**
	 * Checks whether the {@code int} is part of the array
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
	public IntExpectation oneOf(String message, int... arr) {
		
		boolean found = false;
		int length = arr.length;
		for(int i = 0; (i < length) && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found,
		            message,
		            "Expected " + my + " to",
		            "be one of " + Arrays.toString(arr) + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} represents a valid {@code byte}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validByte() {
		
		return validByte(null);
	}
	
	
	/**
	 * Checks whether the {@code int} represents a valid {@code byte}
	 * value with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validByte(String message) {
		
		return test((Byte.MIN_VALUE <= my) && (my <= Byte.MAX_VALUE),
		            message,
		            "Expected " + my + " to",
		            "be a valid byte value."
		);
	}
	
	
	/**
	 * Checks whether the {@code int} represents a valid {@code short}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validShort() {
		
		return validShort(null);
	}
	
	
	/**
	 * Checks whether the {@code int} represents a valid {@code short}
	 * value with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validShort(String message) {
		
		return test((Short.MIN_VALUE <= my) && (my <= Short.MAX_VALUE),
		            message,
		            "Expected " + my + " to",
		            "be a valid short value."
		);
	}
	
	
	@Override
	public String toString() {
		
		return String.format("IntExpectation(value=%d, customText=%s)",
		                     my, customText
		);
	}
}
