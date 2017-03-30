package chaij;


import java.util.Arrays;
import java.util.function.LongPredicate;

/**
 * A {@code long} expectation offers all methods that are available on all
 * numeric types - e.g. {@link #above(long)}, {@link #oneOf(long...)}
 * etc., but also long-specific {@link #validInt()} alongside
 * the general {@link #validByte()} and {@link #validShort()} methods.
 */
public class LongExpectation extends BaseExpectation<LongExpectation> {
	
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
		
		return test(my == expected, "Expected " + my + " to",
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
		
		return test(my > lowerBound, "Expected " + my + " to",
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
		
		return test(my >= lowerBound, "Expected " + my + " to",
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
		
		return test(my < upperBound, "Expected " + my + " to",
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
		
		return test(my <= upperBound, "Expected " + my + " to",
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
		
		return test(min <= my && my <= max, "Expected " + my + " to",
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
		
		return test(predicate.test(my), "Expected " + my + " to",
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
		
		return test(predicate.test(my), "Expected " + my + " to",
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
		
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
					+ '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code long} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation oneOf(long... arr) {
		
		boolean found = false;
		long length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
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
		
		return test(Byte.MIN_VALUE <= my && my <= Byte.MAX_VALUE,
					"Expected " + my + " to", " be a valid byte value."
		);
		
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code short}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validShort() {
		
		return test(Short.MIN_VALUE <= my && my <= Short.MAX_VALUE,
					"Expected " + my + " to", " be a valid short value."
		);
		
	}
	
	
	/**
	 * Checks whether the {@code long} represents a valid {@code int}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public LongExpectation validInt() {
		
		return test(Integer.MIN_VALUE <= my && my <= Integer.MAX_VALUE,
					"Expected " + my + " to", " be a valid short value."
		);
	}
	
}
