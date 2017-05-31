package chaij;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.isA;

public class UtilConstructorTests {
	
	@Rule
	public final ExpectedException e = ExpectedException.none();
	
	
	@Test
	public void testExceptionReporterConstructor()
			throws Exception {
		
		e.expect(InvocationTargetException.class);
		e.expectCause(isA(IllegalAccessException.class));
		Constructor<ExceptionReporter> cons = ExceptionReporter.class.getDeclaredConstructor();
		cons.setAccessible(true);
		cons.newInstance();
	}
	
	
	@Test
	public void testChaiJConstructor()
			throws Exception {
		
		e.expect(InvocationTargetException.class);
		e.expectCause(isA(IllegalAccessException.class));
		Constructor<ChaiJ> cons = ChaiJ.class.getDeclaredConstructor();
		cons.setAccessible(true);
		cons.newInstance();
	}
}
