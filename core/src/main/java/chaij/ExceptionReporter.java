package chaij;


import chaij.function.UnreliableRunnable;

import java.util.*;

/**
 * This utility class enables the usage of multiple exceptions in one unit test.
 *
 * @since 0.0.1
 */
public final class ExceptionReporter {
	
	private static final ThreadLocal<Boolean>
			USE_MULTIPLE = ThreadLocal.withInitial(() -> Boolean.FALSE);
	
	private static final ThreadLocal<List<ChaiJException>>
			EXCEPTIONS = ThreadLocal.withInitial(LinkedList::new);
	
	
	/**
	 * Man, you can't stop looking, can you? If you like it...
	 *
	 * @throws java.lang.IllegalAccessException ....don't instantiate it.
	 */
	private ExceptionReporter()
			throws IllegalAccessException {
		
		throw new IllegalAccessException("Don't!");
	}
	
	
	/**
	 * Enables the catching of multiple
	 * {@link chaij.ChaiJException ChaiJExceptions}.
	 */
	private static void enableMultiple() {
		
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
	private static void resetAndVerify() {
		
		USE_MULTIPLE.set(Boolean.FALSE);
		List<ChaiJException> errors = EXCEPTIONS.get();
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
	 * Reports an exception, either caching or rethrowing the exception
	 * based on the current multiplicity for the thread.
	 *
	 * @param e the exception that occurred, either an
	 *          {@link chaij.UnmetExpectationException} or a
	 *          {@link chaij.WrappedCheckedException}
	 */
	public static void reportException(ChaiJException e) {
		
		Objects.requireNonNull(e);
		if(USE_MULTIPLE.get().booleanValue()) {
			EXCEPTIONS.get().add(e);
		} else {
			throw e;
		}
	}
	
	
	/**
	 * Runs the given code safely while expecting multiple reported exceptions.
	 *
	 * @param r the runnable that may also throw any exceptions.
	 */
	public static void runMultipleAndReport(UnreliableRunnable r) {
		
		enableMultiple();
		try {
			r.run();
		} catch (Throwable t) {
			reportException(new WrappedCheckedException(t));
		}
		resetAndVerify();
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
			for(Throwable error : errors) {
				if(error.getCause() != null) {
					Throwable cause = error.getCause();
					sb.append(String.format("%n - %s(%s) with cause%n    %s(%s)",
					                        error.getClass().getName(), error.getMessage(),
					                        cause.getClass().getName(), cause.getMessage()
					));
				} else {
					sb.append(String.format("%n - %s(%s)",
					                        error.getClass().getName(), error.getMessage()
					));
				}
			}
			return sb.toString();
		}
	}
}
