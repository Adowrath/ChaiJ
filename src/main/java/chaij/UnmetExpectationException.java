package chaij;

import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault
public class UnmetExpectationException extends RuntimeException {
	
	private static final long serialVersionUID = -7752693081656017911L;

	public UnmetExpectationException(String expectationMessage) {
		super(expectationMessage);
	}
	public UnmetExpectationException(String expectationMessage, Throwable cause) {
		super(expectationMessage, cause);
	}
	
}
