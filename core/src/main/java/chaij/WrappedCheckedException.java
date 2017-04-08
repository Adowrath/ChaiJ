package chaij;


public class WrappedCheckedException extends ChaiJException {
	
	
	private static final long serialVersionUID = -1135127015268320561L;
	
	
	/**
	 * The constructor.<br>
	 * Any questions?
	 *
	 * @param wrapped the wrapped exception.
	 */
	public WrappedCheckedException(Throwable wrapped) {
		
		super(wrapped);
	}
}
