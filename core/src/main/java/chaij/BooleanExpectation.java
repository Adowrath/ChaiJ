package chaij;


/**
 * A {@code boolean} valued expectation.
 *
 * <p>
 * Because of the limited amount of values a boolean can take,
 * this class only offers an equally limited subset of operations
 * that suffice for working with booleans.
 *
 * @since 0.0.1
 */
public final class BooleanExpectation extends BaseExpectation<BooleanExpectation> {
	
	private final boolean my;
	
	
	/**
	 * Constructs a new BooleanExpectation.
	 *
	 * <p>
	 * You should not use this constructor directly, but instead get
	 * an expectation through {@link chaij.ChaiJ#expect(boolean)} or
	 * {@link chaij.ChaiJ#expect(boolean, java.lang.String)}
	 *
	 * @param my the {@code boolean} that is used for all operations
	 * @param s  an optional custom expectation message.
	 */
	BooleanExpectation(boolean my, String s) {
		
		super(s);
		this.my = my;
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code true}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #_true()
	 */
	public BooleanExpectation ok() {
		
		return ok(null);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code true}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #_true()
	 */
	public BooleanExpectation ok(String message) {
		
		return test(my,
		            message,
		            "Expected a",
		            "ok-ish boolean."
		);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code true}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #ok()
	 */
	public BooleanExpectation _true() {
		
		return _true(null);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code true}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #ok()
	 */
	public BooleanExpectation _true(String message) {
		
		return test(my,
		            message,
		            "Expected a",
		            "true boolean."
		);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code false}.
	 *
	 * @return the expectation itself for chaining
	 */
	public BooleanExpectation _false() {
		
		return _false(null);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code false}
	 * with a custom message.
	 *
	 * @param message a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 */
	public BooleanExpectation _false(String message) {
		
		return test(!my,
		            message,
		            "Expected a",
		            "false boolean."
		);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is equal to the given {@code boolean}.
	 *
	 * @param expected the other value that should be compared with
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #_false()
	 * @see #_true()
	 * @see #ok()
	 */
	@SuppressWarnings("MisspelledEquals")
	public BooleanExpectation equal(boolean expected) {
		
		return equal(expected, null);
	}
	
	
	/**
	 * Checks whether the {@code boolean} is equal to the given {@code boolean}
	 * with a custom message.
	 *
	 * @param expected the other value that should be compared with
	 * @param message  a custom message specifically for this check
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #_false()
	 * @see #_true()
	 * @see #ok()
	 */
	public BooleanExpectation equal(boolean expected, String message) {
		
		return test(my == expected,
		            message,
		            "Expected " + my + " to",
		            "equal " + expected + '.'
		);
	}
	
	
	@Override
	public String toString() {
		
		return String.format("BooleanExpectation(value=%b, customText=%s)",
		                     my, customText
		);
	}
}
