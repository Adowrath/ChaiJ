package chaij.junit;


import chaij.ExceptionReporter;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * This JUnit rule is used for enabling multiple
 * expectations that can fail within a single test case.
 *
 * <p>
 * Note that, unlike {@link org.junit.rules.ErrorCollector}, this
 * rule works like a marker. You do not need to interact with
 * it during a test case at all.
 *
 * <pre>
 * {@literal @}Rule
 * public MultipleExpectations me = MultipleExpectations.all();
 *
 * {@literal @}Test
 * public void testExample() {
 *     expect(42).to.equal(43); // Normally, this would fail here already.
 *     expect(13).to.not().be.above(1); // But it doesn't, simply because of the rule's existence.
 *     expect(false).to.be.ok(); // Awesome, right?
 * } // Now, at the end of the day, of course this test still fails. But it throws an Exception containing all failures!
 * </pre>
 *
 * @since 0.1.0
 */
public final class MultipleExpectations implements TestRule {
	
	private final boolean enabledByDefault;
	
	
	/**
	 * A constructor. Why do you search for these?
	 *
	 * @param enabledByDefault whether this rule expects multiple
	 *                         possible failures or not.
	 */
	private MultipleExpectations(boolean enabledByDefault) {
		
		this.enabledByDefault = enabledByDefault;
	}
	
	
	@Override
	@SuppressWarnings({"ReturnOfInnerClass", "AnonymousInnerClassMayBeStatic", "AnonymousInnerClass"})
	public Statement apply(Statement base, Description description) {
		
		boolean enabled = enabledByDefault;
		return new Statement() {
			@Override
			public void evaluate()
					throws Throwable {
				
				if(enabled ?
				   (description.getAnnotation(SingleExpectation.class) == null) :
				   (description.getAnnotation(MultipleExpectation.class) != null)) {
					
					ExceptionReporter.runMultipleAndReport(base::evaluate);
				} else {
					base.evaluate();
				}
			}
		};
	}
	
	
	private static final TestRule ALL_MULTIPLE = new MultipleExpectations(true);
	
	private static final TestRule NONE_MULTIPLE = new MultipleExpectations(false);
	
	
	/**
	 * Makes all methods use multiple expectations by default,
	 * meaning they won't fail on the first error.
	 *
	 * <p>
	 * If you want to exclude specific tests, use the
	 * {@link SingleExpectation} annotation.
	 *
	 * @return a rule that can handle multiple test failures within one unit test.
	 */
	public static TestRule all() {
		
		return ALL_MULTIPLE;
	}
	
	
	/**
	 * Makes all methods use single expectations by default,
	 * meaning they will fail on the first error.
	 *
	 * <p>
	 * If you want to exclude specific tests, use the
	 * {@link MultipleExpectation} annotation.
	 *
	 * @return a rule that accepts only a single failing expectation test per test case.
	 */
	public static TestRule none() {
		
		return NONE_MULTIPLE;
	}
	
	
	@Override
	public String toString() {
		
		return String.format("MultipleExpectations(enabledByDefault=%b)",
		                     enabledByDefault
		);
	}
}
