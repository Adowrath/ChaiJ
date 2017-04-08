package chaij.function;


/**
 * This is an alternative to {@link java.lang.Runnable} that can also throw exceptions.
 */
@FunctionalInterface
public interface UnreliableRunnable {
	
	/**
	 * The code that is executed.
	 *
	 * @throws Throwable any exception may be thrown by a specific implementation.
	 */
	void run()
			throws Throwable;
	
	/**
	 * Converts a regular Runnable as an alternative to {@code () -> r.run();}
	 *
	 * @param r the runnable
	 *
	 * @return an unreliable runnable
	 */
	static UnreliableRunnable fromRunnable(Runnable r) {
		
		return r::run;
	}
}
