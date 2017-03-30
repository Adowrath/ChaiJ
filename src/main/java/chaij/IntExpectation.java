package chaij;


import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * An {@code int} expectation offers all methods that are available on all
 * numeric types - e.g. {@link #above(int)}, {@link #oneOf(int...)}
 * etc., but also validity checkers such as the {@link #validByte()} and
 * {@link #validShort()} methods.
 */
public class IntExpectation extends BaseExpectation<IntExpectation> {
	
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
		
		return test(my == expected, "Expected " + my + " to",
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
		
		return test(my > lowerBound, "Expected " + my + " to",
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
		
		return test(my >= lowerBound, "Expected " + my + " to",
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
		
		return test(my < upperBound, "Expected " + my + " to",
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
		
		return test(my <= upperBound, "Expected " + my + " to",
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
		
		return test(min <= my && my <= max, "Expected " + my + " to",
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
		
		return test(predicate.test(my), "Expected " + my + " to",
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
		
		return test(predicate.test(my), "Expected " + my + " to",
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
		
		return test(Math.abs(my - expected) <= delta, "Expected " + my + " to",
					"be close to " + expected + " with a delta of " + delta
					+ '.'
		);
	}
	
	
	/**
	 * Checks whether the {@code int} is part of the array.
	 *
	 * @param arr the array of the possible values
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation oneOf(int... arr) {
		
		boolean found = false;
		int length = arr.length;
		for(int i = 0; i < length && !found; ++i) {
			found = arr[i] == my;
		}
		return test(found, "Expected " + my + " to",
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
		
		return test(Byte.MIN_VALUE <= my && my <= Byte.MAX_VALUE,
					"Expected " + my + " to", " be a valid byte value."
		);
	}
	
	
	/**
	 * Checks whether the {@code int} represents a valid {@code short}
	 * value.
	 *
	 * @return the expectation itself for chaining
	 */
	public IntExpectation validShort() {
		
		return test(Short.MIN_VALUE <= my && my <= Short.MAX_VALUE,
					"Expected " + my + " to", " be a valid short value."
		);
	}
	
}
