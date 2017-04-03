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
	
	
	/**
	 * Man, you can't stop looking, can you? If you like it...
	 */
	private ExceptionReporter() {}
	
	
	/**
	 * Enables the catching of multiple
	 * {@link chaij.UnmetExpectationException UnmetExpectationExceptions}.
	 *
	 * <p>
	 * If you call this method directly, it is <strong>vital</strong>
	 * that you call {@link #resetAndVerify()} afterwards, or
	 * this <strong>will be leaked into global state!</strong>
	 */
	public static void enableMultiple() {
		
		USE_MULTIPLE.set(Boolean.TRUE);
	}
	
	
	/**
	 * Resets the multiplicity state and checks for any caught exceptions.
	 *
	 * <p>
	 * If there was no exception, nothing will be thrown.
	 *
	 * <p>
	 * If there was one {@link chaij.UnmetExpectationException}, this method rethrows it.
	 *
	 * <p>
	 * If there were two or more exceptions, they will be wrapped
	 * inside a {@link MultipleException} exception.
	 */
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
	
	
	/**
	 * Reports an unmet expectation, either caching or rethrowing the exception
	 * based on the current multiplicity for the thread.
	 *
	 * @param e the unmet expectation exception
	 */
	public static void reportException(UnmetExpectationException e) {
		
		Objects.requireNonNull(e);
		if(USE_MULTIPLE.get()) {
			EXCEPTIONS.get().add(e);
		} else {
			throw e;
		}
	}
	
	
	/**
	 * Collects multiple exceptions.
	 */
	public static final class MultipleException extends RuntimeException {
		
		private static final long serialVersionUID = -1212008157115633368L;
		
		private final Collection<? extends Throwable> errors;
		
		
		/**
		 * Constructs a new exception. You probably shouldn't use this directly.
		 *
		 * @param errors the exceptions!
		 */
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
