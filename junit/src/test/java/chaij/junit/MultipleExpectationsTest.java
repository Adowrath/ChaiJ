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

import java.lang.annotation.Annotation;

import static chaij.ChaiJ.expect;

@SuppressWarnings("UnqualifiedStaticUsage")
public class MultipleExpectationsTest {
	
	@Rule
	public final ExpectedException ex = ExpectedException.none();
	
	
	private static Description desc(Class<?> clz, String name, Annotation... annotations) {
		
		return Description.createTestDescription(clz,
		                                         name,
		                                         annotations
		);
	}
	
	
	private static void run(TestRule rule, Runnable code)
			throws Throwable {
		
		run(rule, code, Description.EMPTY);
	}
	
	
	private static void run(TestRule rule, Runnable code, Description description)
			throws Throwable {
		
		rule.apply(new Statement() {
			@Override
			public void evaluate() {
				
				code.run();
			}
		}, description).evaluate();
	}
	
	
	@Test
	public void testNoFailureWithAll()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		
		run(me, expect(true).to.be::ok);
	}
	
	
	@Test
	public void testNoFailureWithNone()
			throws Throwable {
		
		TestRule me = MultipleExpectations.none();
		
		run(me, expect(true).to.be::ok);
	}
	
	
	@Test
	public void testOneFailure()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		ex.expect(UnmetExpectationException.class);
		ex.expectMessage("Expected a ok-ish boolean.");
		
		run(me, expect(false).to.be::ok);
	}
	
	
	@Test
	public void testTwoFailures()
			throws Throwable {
		
		TestRule me = MultipleExpectations.all();
		ex.expect(MultipleException.class);
		ex.expectMessage(String.format("There were 2 errors:%n" +
		                               " - chaij.UnmetExpectationException(Expected a ok-ish boolean.)%n" +
		                               " - chaij.UnmetExpectationException(Expected 2 to be above 3.)"));
		
		run(me, () -> {
			expect(false).to.be.ok();
			expect(2).to.be.above(3);
		});
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
		
		run(me, () -> {
			expect(false).to.be.ok();
			Assert.fail("The annotation wasn't properly recognized.");
		}, desc(MultipleExpectationsTest.class,
		        methodName,
		        se
		));
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
		
		run(me, () -> {
			
			expect(false).to.be.ok();
			Assert.fail("The annotation wasn't properly recognized.");
		}, desc(MultipleExpectationsTest.class,
		        methodName,
		        se
		));
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
		
		run(me, () -> {
			expect(false).to.be.ok();
			expect(2).to.be.above(3);
		}, desc(MultipleExpectationsTest.class,
		        methodName,
		        se
		));
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
		
		run(me, () -> {
			expect(false).to.be.ok();
			expect(2).to.be.above(3);
		}, desc(MultipleExpectationsTest.class,
		        methodName,
		        se
		));
	}
}
