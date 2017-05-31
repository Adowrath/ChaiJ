package chaij;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@SuppressWarnings("JUnitTestMethodWithNoAssertions")
public class BaseExpectationTests {
	
	@Rule
	public final ExpectedException e = ExpectedException.none();
	
	
	@Test
	public void testLinkers() {
		
		BaseExpectation<?> expectation = new DummyExpectation(null);
		
		assertThat("Linkers should not return a different object.",
		           expectation.to.be.been.is.that.which.and.has.have.with.at.of.same,
		           is(sameInstance(expectation))
		);
	}
	
	
	@Test
	public void testPass() {
		
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.test(true, "This should not fail.", "But it did!");
	}
	
	
	@Test
	public void testFail() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("This should fail. And it did!");
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.test(false, "This should fail.", "And it did!");
	}
	
	
	@Test
	public void testNotPass() {
		
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.not().test(false, "This should not fail.", "But it did!");
	}
	
	
	@Test
	public void testNotNotFail() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("This should fail. And it did!");
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.not().not().test(false, "This should fail.", "And it did!");
	}
	
	
	@Test
	public void testNotFail() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("This should fail. not And it did!");
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.not().test(true, "This should fail.", "And it did!");
	}
	
	
	@Test
	public void testWithExplicitMessage() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Custom message: This should fail. And it did!");
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.test(false, "Custom message", "This should fail.", "And it did!");
	}
	
	
	@Test
	public void testWithSecondPartSupplier() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Custom message: This should fail. And it did!");
		BaseExpectation<?> expectation = mock(BaseExpectation.class);
		
		expectation.test(false, "Custom message", "This should fail.", () -> "And it did!");
	}
	
	
	@Test
	public void testWithImplicitMessage() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Custom message: This should fail. And it did!");
		BaseExpectation<?> expectation = new DummyExpectation("Custom message");
		
		expectation.test(false, "This should fail.", "And it did!");
	}
	
	
	@Test
	public void testBehaviourOnContinueAfterFail() {
		
		BaseExpectation<?> expectation = new DummyExpectation(null);
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Meh. Why?!");
		
		ExceptionReporter.runMultipleAndReport(() -> {
			BaseExpectation<?> other = expectation.test(false, "Meh.", "Why?!");
			
			assertThat("The expectation should be returned.",
			           expectation,
			           is(sameInstance(other))
			);
		});
	}
	
	
	private static final class DummyExpectation extends BaseExpectation<DummyExpectation> {
		
		DummyExpectation(String msg) {super(msg);}
	}
}
