package chaij;


import chaij.ExceptionReporter.MultipleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionReporterTest {
	
	@Rule
	public final ExpectedException e = ExpectedException.none();
	
	
	@SuppressWarnings("JUnitTestMethodWithNoAssertions")
	@Test
	public void testEmptyReport() {
		
		ExceptionReporter.resetAndVerify();
		
	}
	
	
	@Test
	public void testSingleReport() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Some error!");
		
		ExceptionReporter.reportException(new UnmetExpectationException("Some error!"));
	}
	
	
	@Test
	public void testSingleMultipleReport() {
		
		ExceptionReporter.enableMultiple();
		ExceptionReporter.reportException(new UnmetExpectationException("Some error!"));
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Some error!");
		
		ExceptionReporter.resetAndVerify();
	}
	
	
	@Test
	public void testTwoMultipleReport() {
		
		ExceptionReporter.enableMultiple();
		ExceptionReporter.reportException(new UnmetExpectationException("Some error 1!"));
		ExceptionReporter.reportException(new UnmetExpectationException("Some error 2!"));
		
		e.expect(MultipleException.class);
		e.expectMessage(String.format("There were 2 errors:%n" +
									  "  chaij.UnmetExpectationException(Some error 1!)%n" +
									  "  chaij.UnmetExpectationException(Some error 2!)"));
		
		ExceptionReporter.resetAndVerify();
	}
}
