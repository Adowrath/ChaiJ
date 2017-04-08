package chaij;


/**
 * Base class for expectations in ChaiJ.
 */
public abstract class ChaiJException extends RuntimeException {
	
	
	private static final long serialVersionUID = -1135127015268320561L;
	
	
	/**
	 * The constructor.<br>
	 * Any questions?
	 *
	 * @param expectationMessage the message of this exception.
	 */
	protected ChaiJException(String expectationMessage) {
		
		super(expectationMessage);
	}
	
	
	/**
	 * The constructor.<br>
	 * Any questions?
	 *
	 * @param cause the wrapped cause.
	 */
	protected ChaiJException(Throwable cause) {
		
		super(cause);
	}
}
