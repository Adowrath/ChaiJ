package chaij.function;


/**
 * This is an alternative to {@link java.lang.Runnable} that can also throw exceptions.
 *
 * <p>
 * If you have a normal Runnable {@code r}, you can "convert" it to an {@code UnreliableRunnable}
 * through either {@code r::run} or {@code () -> r.run()}.
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
}
