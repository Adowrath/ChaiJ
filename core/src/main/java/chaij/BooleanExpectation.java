package chaij;


/**
 * A {@code boolean} valued expectation.
 *
 * <p>
 * Because of the limited amount of values a boolean can take,
 * this class only offers an equally limited subset of operations
 * that suffice for working with booleans.
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
		
		return test(my, "Expected a", "ok-ish boolean.");
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code true}.
	 *
	 * @return the expectation itself for chaining
	 *
	 * @see #ok()
	 */
	@SuppressWarnings("InstanceMethodNamingConvention")
	public BooleanExpectation _true() {
		
		return test(my, "Expected a", "true boolean.");
	}
	
	
	/**
	 * Checks whether the {@code boolean} is {@code false}.
	 *
	 * @return the expectation itself for chaining
	 */
	@SuppressWarnings("InstanceMethodNamingConvention")
	public BooleanExpectation _false() {
		
		return test(!my, "Expected a", "false boolean.");
	}
	
	
	/**
	 * Checks whether the {@code boolean} is equal to {@code boolean}.
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
		
		return test(my == expected, "Expected " + my + " to",
					"equal " + expected + '.'
		);
	}
}
