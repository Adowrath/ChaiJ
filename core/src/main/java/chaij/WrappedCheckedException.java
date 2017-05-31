package chaij;


/**
 * Generic wrapper for any checked exception so that no other method has to declare them.
 *
 * @since 0.1.0
 */
public final class WrappedCheckedException extends ChaiJException {
	
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
