package chaij;


/**
 * If an expectation does not hold, this exception will be thrown
 * or cached, depending on the reporting method.
 *
 * @since 0.0.1
 */
public final class UnmetExpectationException extends ChaiJException {
	
	private static final long serialVersionUID = -7752693081656017911L;
	
	
	/**
	 * The constructor.<br>
	 * Any questions?
	 *
	 * @param expectationMessage the message, preferably containing both
	 *                           the expectation and the actual state.
	 */
	public UnmetExpectationException(String expectationMessage) {
		
		super(expectationMessage);
	}
}
