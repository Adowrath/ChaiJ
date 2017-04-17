package chaij;


import chaij.ExceptionReporter.MultipleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static chaij.ExceptionReporter.reportException;
import static chaij.ExceptionReporter.runMultipleAndReport;

public class ExceptionReporterTest {
	
	@Rule
	public final ExpectedException e = ExpectedException.none();
	
	
	@SuppressWarnings("JUnitTestMethodWithNoAssertions")
	@Test
	public void testEmptyReport() {
		
		runMultipleAndReport(() -> {
			// nothing happens!
		});
		
	}
	
	
	@Test
	public void testCaughtException() {
		
		runMultipleAndReport(() -> {
			reportException(new UnmetExpectationException("Some normal error 1!"));
			
			e.expect(MultipleException.class);
			e.expectMessage(String.format("There were 2 errors:%n" +
										  " - chaij.UnmetExpectationException(Some normal error 1!)%n" +
										  " - chaij.WrappedCheckedException(java.lang.RuntimeException: Abnormal! HELP!) with cause%n" +
										  "    java.lang.RuntimeException(Abnormal! HELP!)"));
			
			throw new RuntimeException("Abnormal! HELP!");
		});
	}
	
	
	@Test
	public void testSingleReport() {
		
		e.expect(UnmetExpectationException.class);
		e.expectMessage("Some error!");
		
		reportException(new UnmetExpectationException("Some error!"));
	}
	
	
	@Test
	public void testSingleMultipleReport() {
		
		runMultipleAndReport(() -> {
			reportException(new UnmetExpectationException("Some error!"));
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Some error!");
		});
	}
	
	
	@Test
	public void testTwoMultipleReport() {
		
		runMultipleAndReport(() -> {
			reportException(new UnmetExpectationException("Some error 1!"));
			reportException(new UnmetExpectationException("Some error 2!"));
			
			e.expect(MultipleException.class);
			e.expectMessage(String.format("There were 2 errors:%n" +
										  " - chaij.UnmetExpectationException(Some error 1!)%n" +
										  " - chaij.UnmetExpectationException(Some error 2!)"));
			
		});
	}
}
