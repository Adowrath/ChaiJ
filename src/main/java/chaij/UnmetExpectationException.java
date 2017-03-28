package chaij;


public class UnmetExpectationException extends RuntimeException {
	
	private static final long serialVersionUID = -7752693081656017911L;
	
	
	public UnmetExpectationException(String expectationMessage) {
		
		super(expectationMessage);
	}
	
	
}
