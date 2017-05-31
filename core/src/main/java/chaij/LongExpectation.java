package chaij;


import java.util.Arrays;
import java.util.function.LongPredicate;

/**
 * A {@code long} expectation offers all methods that are available on all
 * numeric types - e.g. {@link #above(long)}, {@link #oneOf(long...)}
 * etc., but also long-specific {@link #validInt()} alongside
 * the general {@link #validByte()} and {@link #validShort()} methods.
 *
 * @since 0.0.1
 */
public final class LongExpectation extends BaseExpectation<LongExpectation> {
	
	private final long my;
	
	
	/**
	 * Constructs a new LongExpectation.
	 *
	 * <p>
	 * You should not use this constructor directly, but instead get
	 * an expectation through {@link chaij.ChaiJ#expect(long)} or
	 * {@link chaij.ChaiJ#expect(long, java.lang.String)}
	 *
	 * @param l the {@code long} that is used for all operations
	 * @param s an optional custom expectation message.
	 */
	LongExpectation(long l, String s) {
		
		super(s);
		my = l;
	}
	
	
	/**
	 * Checks whether the {@code long} is equal to {@code expected}.
	 *
	 * @param expected the other value that should be compared with
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("MisspelledEquals")
	public LongExpectation equal(long expected) {
		
		return equal(expected, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is equal to {@code expected} with a custom message.
	 *
	 * @param expected the other value that should be compared with
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation equal(long expected, String message) {
		
		return test(my == expected,
		            message,
		            "Expected " + my + " to",
		            "equal " + expected + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is above {@code upperBound}.
	 *
	 * @param lowerBound the biggest value that is too small
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation above(long lowerBound) {
		
		return above(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is above {@code upperBound} with a custom message.
	 *
	 * @param lowerBound the biggest value that is too small
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation above(long lowerBound, String message) {
		
		return test(my > lowerBound,
		            message,
		            "Expected " + my + " to",
		            "be above " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is at least {@code upperBound}.
	 *
	 * @param lowerBound the smallest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation least(long lowerBound) {
		
		return least(lowerBound, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is at least {@code upperBound} with a custom message.
	 *
	 * @param lowerBound the smallest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation least(long lowerBound, String message) {
		
		return test(my >= lowerBound,
		            message,
		            "Expected " + my + " to",
		            "be at least " + lowerBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is below {@code upperBound}.
	 *
	 * @param upperBound the smallest value that is too big
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation below(long upperBound) {
		
		return below(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is below {@code upperBound} with a custom message.
	 *
	 * @param upperBound the smallest value that is too big
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation below(long upperBound, String message) {
		
		return test(my < upperBound,
		            message,
		            "Expected " + my + " to",
		            "be below " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is at most {@code upperBound}.
	 *
	 * @param upperBound the biggest value that is allowed
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation most(long upperBound) {
		
		return most(upperBound, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is at most {@code upperBound} with a custom message.
	 *
	 * @param upperBound the biggest value that is allowed
	 * @param message    a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation most(long upperBound, String message) {
		
		return test(my <= upperBound,
		            message,
		            "Expected " + my + " to",
		            "be at most " + upperBound + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is within {@code min} and
	 * {@code max}, both inclusive.
	 *
	 * @param min the minimum value
	 * @param max the maximum value
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation within(long min, long max) {
		
		return within(min, max, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is within {@code min} and
	 * {@code max}, both inclusive with a custom message.
	 *
	 * @param min     the minimum value
	 * @param max     the maximum value
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation within(long min, long max, String message) {
		
		return test((min <= my) && (my <= max),
		            message,
		            "Expected " + my + " to",
		            "be within " + min + " and " + max + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code long} with
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation match(LongPredicate predicate) {
		
		return match(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code long} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation match(LongPredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
		            "match a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate}.
	 *
	 * @param predicate the predicate to check the {@code long} with
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation satisfy(LongPredicate predicate) {
		
		return satisfy(predicate, null);
	}
	
	
	/**
	 * Checks whether the {@code long} satisfies the given
	 * {@code predicate} with a custom message.
	 *
	 * @param predicate the predicate to check the {@code long} with
	 * @param message   a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation satisfy(LongPredicate predicate, String message) {
		
		return test(predicate.test(my),
		            message,
		            "Expected " + my + " to",
		            "satisfy a custom predicate."
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is close to {@code expected}
	 * with a maximum distance of {@code delta}.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation closeTo(long expected, long delta) {
		
		return closeTo(expected, delta, null);
	}
	
	
	/**
	 * Checks whether the {@code long} is close to {@code expected}
	 * with a maximum distance of {@code delta} with a custom message.
	 *
	 * @param expected the expected value to which it should be close
	 * @param delta    the maximum distance the two values can have
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation closeTo(long expected, long delta, String message) {
		
		return test(Math.abs(my - expected) <= delta,
		            message,
		            "Expected " + my + " to",
		            "be close to " + expected + " with a delta of " + delta + '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("OverloadedVarargsMethod")
	public LongExpectation oneOf(long... arr) {
		
		return oneOf(null, arr);
	}
	
	
	/**
	 * Checks whether the {@code long} is part of the array with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 * @param arr     the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("OverloadedVarargsMethod")
	public LongExpectation oneOf(String message, long... arr) {
		
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
	 * Checks whether the {@code long} represents a valid {@code byte}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validByte() {
		
		return validByte(null);
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code byte}
	 * value with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validByte(String message) {
		
		return test((Byte.MIN_VALUE <= my) && (my <= Byte.MAX_VALUE),
		            message,
		            "Expected " + my + " to",
		            "be a valid byte value."
		);
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code short}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validShort() {
		
		return validShort(null);
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code short}
	 * value with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validShort(String message) {
		
		return test((Short.MIN_VALUE <= my) && (my <= Short.MAX_VALUE),
		            message,
		            "Expected " + my + " to",
		            "be a valid short value."
		);
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code int}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validInt() {
		
		return validInt(null);
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code int}
	 * value with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validInt(String message) {
		
		return test((Integer.MIN_VALUE <= my) && (my <= Integer.MAX_VALUE),
		            message,
		            "Expected " + my + " to",
		            "be a valid integer value."
		);
	}
	
	
	@Override
	public String toString() {
		
		return String.format("LongExpectation(value=%d, customText=%s)",
		                     my, customText
		);
	}
}
