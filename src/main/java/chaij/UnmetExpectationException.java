package chaij;


/**
 * If an expectation does not hold, this exception will be thrown
 * or cached, depending on the reporting method.
 */
public class UnmetExpectationException extends RuntimeException {
	
	private static final long serialVersionUID = -7752693081656017911L;
	
	
	/**
	 * The constructor.<br>
	 * Any questions?
	 *
	 * @param expectationMessage the message, preferrably containing both
	 *                           the expectation and the actual state.
	 */
	public UnmetExpectationException(String expectationMessage) {
		
		super(expectationMessage);
	}
}
