package chaij.junit;


import chaij.ExceptionReporter.MultipleException;
import chaij.UnmetExpectationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static chaij.ChaiJ.expect;

public class MultipleExpectationsTest {
	
	@Rule
	public final ExpectedException ex = ExpectedException.none();
	
	
	@Test
	public void testNoFailureWithAll()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(true).to.be.ok();
			}
		}, Description.EMPTY).evaluate();
	}
	
	
	@Test
	public void testNoFailureWithNone()
			throws Throwable {
		
		TestRule me = MultipleExpectations.none();
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(true).to.be.ok();
			}
		}, Description.EMPTY).evaluate();
	}
	
	
	@Test
	public void testOneFailure()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		ex.expect(UnmetExpectationException.class);
		ex.expectMessage("Expected a ok-ish boolean.");
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
			}
		}, Description.EMPTY).evaluate();
	}
	
	
	@Test
	public void testTwoFailures()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		ex.expect(MultipleException.class);
		ex.expectMessage(String.format("There were 2 errors:%n" +
		                               " - chaij.UnmetExpectationException(Expected a ok-ish boolean.)%n" +
		                               " - chaij.UnmetExpectationException(Expected 2 to be above 3.)"));
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
				expect(2).to.be.above(3);
			}
		}, Description.EMPTY).evaluate();
	}
	
	
	@Test
	@SingleExpectation
	public void testSingleExpectationAnnotation()
			throws Throwable {
		
		String methodName = "testSingleExpectationAnnotation";
		SingleExpectation se = getClass().getMethod(methodName).getAnnotation(SingleExpectation.class);
		TestRule me = MultipleExpectations.all();
		ex.expect(UnmetExpectationException.class);
		ex.expectMessage("Expected a ok-ish boolean.");
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
				Assert.fail("The annotation wasn't properly recognized.");
			}
		}, Description.createTestDescription(MultipleExpectationsTest.class,
		                                     methodName, se
		)).evaluate();
	}
	
	
	@Test
	@SingleExpectation
	public void testSingleExpectationAnnotationWithNone()
			throws Throwable {
		
		String methodName = "testSingleExpectationAnnotationWithNone";
		SingleExpectation se = getClass().getMethod(methodName).getAnnotation(SingleExpectation.class);
		TestRule me = MultipleExpectations.none();
		ex.expect(UnmetExpectationException.class);
		ex.expectMessage("Expected a ok-ish boolean.");
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
				Assert.fail("The annotation wasn't properly recognized.");
			}
		}, Description.createTestDescription(MultipleExpectationsTest.class,
		                                     methodName, se
		)).evaluate();
	}
	
	
	@Test
	@MultipleExpectation
	public void testMultipleExpectationAnnotation()
			throws Throwable {
		
		String methodName = "testMultipleExpectationAnnotation";
		MultipleExpectation se = getClass().getMethod(methodName).getAnnotation(MultipleExpectation.class);
		TestRule me = MultipleExpectations.none();
		ex.expect(MultipleException.class);
		ex.expectMessage(String.format("There were 2 errors:%n" +
		                               " - chaij.UnmetExpectationException(Expected a ok-ish boolean.)%n" +
		                               " - chaij.UnmetExpectationException(Expected 2 to be above 3.)"));
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
				expect(2).to.be.above(3);
			}
		}, Description.createTestDescription(MultipleExpectationsTest.class,
		                                     methodName, se
		)).evaluate();
	}
	
	
	@Test
	@MultipleExpectation
	public void testMultipleExpectationAnnotationWithAll()
			throws Throwable {
		
		String methodName = "testMultipleExpectationAnnotationWithAll";
		MultipleExpectation se = getClass().getMethod(methodName).getAnnotation(MultipleExpectation.class);
		TestRule me = MultipleExpectations.all();
		ex.expect(MultipleException.class);
		ex.expectMessage(String.format("There were 2 errors:%n" +
		                               " - chaij.UnmetExpectationException(Expected a ok-ish boolean.)%n" +
		                               " - chaij.UnmetExpectationException(Expected 2 to be above 3.)"));
		
		me.apply(new Statement() {
			@Override
			public void evaluate() {
				
				expect(false).to.be.ok();
				expect(2).to.be.above(3);
			}
		}, Description.createTestDescription(MultipleExpectationsTest.class, methodName, se
		)).evaluate();
	}
}
