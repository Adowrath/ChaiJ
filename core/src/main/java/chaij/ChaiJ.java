package chaij;


/**
 * The collection of all expect methods offered by ChaiJ itself.
 */
@SuppressWarnings({"MethodReturnOfConcreteClass", "OverloadedMethodsWithSameNumberOfParameters"})
public final class ChaiJ {
	
	/**
	 * Don't instantiate.
	 *
	 * @throws java.lang.IllegalAccessException ....don't instantiate it.
	 */
	private ChaiJ()
			throws IllegalAccessException {
		
		throw new IllegalAccessException("Don't!");
	}
	
	
	/**
	 * Returns an integer expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.IntExpectation#satisfy(java.util.function.IntPredicate)}
	 * to make sure it satisfies your custom conditions.
	 *
	 * @param value the int value that is tested in this expectation
	 *
	 * @return the expectation
	 */
	public static IntExpectation expect(int value) {
		
		return new IntExpectation(value, null);
	}
	
	
	/**
	 * Returns an integer expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.IntExpectation#satisfy(java.util.function.IntPredicate)}
	 * to make sure it satisfies your custom conditions.
	 *
	 * @param value   the int value that is tested in this expectation
	 * @param message a custom message that is prepended in front of all
	 *                the error messages. Use this to better describe your
	 *                intent with the expectation
	 *
	 * @return the expectation
	 */
	public static IntExpectation expect(int value, String message) {
		
		return new IntExpectation(value, message);
	}
	
	
	/**
	 * Returns a long integer expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.LongExpectation#satisfy(java.util.function.LongPredicate)}
	 * to make sure it satisfies your custom conditions.
	 *
	 * @param value the long value that is tested in this expectation
	 *
	 * @return the expectation
	 */
	public static LongExpectation expect(long value) {
		
		return new LongExpectation(value, null);
	}
	
	
	/**
	 * Returns a long integer expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.LongExpectation#satisfy(java.util.function.LongPredicate)}
	 * to make sure it satisfies your custom conditions.
	 *
	 * @param value   the long value that is tested in this expectation
	 * @param message a custom message that is prepended in front of all
	 *                the error messages. Use this to better describe your
	 *                intent with the expectation
	 *
	 * @return the expectation
	 */
	public static LongExpectation expect(long value, String message) {
		
		return new LongExpectation(value, message);
	}
	
	
	/**
	 * Returns a double floating point expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.DoubleExpectation#satisfy(java.util.function.DoublePredicate)}
	 * to make sure it satisfies your own conditions.
	 *
	 * @param value the double value that is tested in this expectation
	 *
	 * @return the expectation
	 */
	public static DoubleExpectation expect(double value) {
		
		return new DoubleExpectation(value, null);
	}
	
	
	/**
	 * Returns a double floating point expectation, offering most of the basic tests.
	 *
	 * <p>
	 * You can also use {@link chaij.DoubleExpectation#satisfy(java.util.function.DoublePredicate)}
	 * to make sure it satisfies your custom conditions.
	 *
	 * @param value   the double value that is tested in this expectation
	 * @param message a custom message that is prepended in front of all
	 *                the error messages. Use this to better describe your
	 *                intent with the expectation
	 *
	 * @return the expectation
	 */
	public static DoubleExpectation expect(double value, String message) {
		
		return new DoubleExpectation(value, message);
	}
	
	
	/**
	 * Returns a boolean expectation, offering most of the basic tests.
	 *
	 * @param value the boolean value that is tested in this expectation
	 *
	 * @return the expectation
	 */
	public static BooleanExpectation expect(boolean value) {
		
		return new BooleanExpectation(value, null);
	}
	
	
	/**
	 * Returns a boolean expectation, offering most of the basic tests.
	 *
	 * @param value   the boolean value that is tested in this expectation
	 * @param message a custom message that is prepended in front of all
	 *                the error messages. Use this to better describe your
	 *                intent with the expectation
	 *
	 * @return the expectation
	 */
	public static BooleanExpectation expect(boolean value, String message) {
		
		return new BooleanExpectation(value, message);
	}
}
