package chaij;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;

@SuppressWarnings("JUnitTestMethodWithNoAssertions")
public class BaseExpectationTests {
	
	@Rule
	public ExpectedException e = ExpectedException.none();
	
	
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
}
