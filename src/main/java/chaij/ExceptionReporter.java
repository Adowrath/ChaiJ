package chaij;


import java.util.*;

/**
 * This utility class enables the usage of multiple exceptions in one unit test.
 */
public final class ExceptionReporter {
	
	private static final ThreadLocal<Boolean>
			USE_MULTIPLE = ThreadLocal.withInitial(() -> Boolean.FALSE);
	
	private static final ThreadLocal<List<UnmetExpectationException>>
			EXCEPTIONS = ThreadLocal.withInitial(LinkedList::new);
	
	
	private ExceptionReporter() {}
	
	
	public static void enableMultiple() {
		
		USE_MULTIPLE.set(Boolean.TRUE);
	}
	
	
	public static void resetAndVerify() {
		
		USE_MULTIPLE.set(Boolean.FALSE);
		List<UnmetExpectationException> errors = new LinkedList<>(EXCEPTIONS.get());
		EXCEPTIONS.remove();
		if(!errors.isEmpty()) {
			if(errors.size() == 1) {
				throw errors.get(0);
			} else {
				throw new MultipleException(errors);
			}
		}
	}
	
	
	public static void reportException(UnmetExpectationException e) {
		
		Objects.requireNonNull(e);
		if(USE_MULTIPLE.get()) {
			EXCEPTIONS.get().add(e);
		} else {
			throw e;
		}
	}
	
	
	public static final class MultipleException extends RuntimeException {
		
		private static final long serialVersionUID = -1212008157115633368L;
		
		private final Collection<? extends Throwable> errors;
		
		
		public MultipleException(Collection<? extends Throwable> errors) {
			
			this.errors = new ArrayList<>(errors);
		}
		
		
		@Override
		public String getMessage() {
			
			StringBuilder sb = new StringBuilder(String.format("There were %d errors:", errors.size()));
			for(Throwable e : errors) {
				sb.append(String.format("%n  %s(%s)", e.getClass().getName(), e.getMessage()));
			}
			return sb.toString();
		}
	}
}
