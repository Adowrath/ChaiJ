package chaij;

import static chaij.BooleanExpectation.unimplementedFunctions;
import static chaij.ChaiJ.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;


import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
@NonNullByDefault
@SuppressWarnings("static-method")
public class BooleanExpectationTests {
	
	public static class GeneralContracts {
		
		@Test
		public void testLanguageChains() {
			BooleanExpectation expect = expect(true);
			
			BooleanExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertEquals(	"After every language chain, the object stays the same.",
							expect, other);
		}
		
		@Test
		public void testNot() {
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(true).not();
		}
		
		@Test
		public void testAny() {
			assumeFalse(unimplementedFunctions.contains("any"));
			expect(true).any();
		}
		
		@Test
		public void testAll() {
			assumeFalse(unimplementedFunctions.contains("all"));
			expect(true).all();
		}
		
		@Test
		public void testOk() {
			assumeFalse(unimplementedFunctions.contains("ok"));
			expect(true).ok();
		}
		
		@Test
		public void testTrue() {
			assumeFalse(unimplementedFunctions.contains("_true"));
			expect(true)._true();
		}
		
		@Test
		public void testFalse() {
			assumeFalse(unimplementedFunctions.contains("_false"));
			expect(false)._false();
		}
		
		@Test
		public void testEquals() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(true).equal(true);
		}
	}
	
	public static class NormalTests {
		
		
		@Test
		public void testOk() {
			assumeFalse(unimplementedFunctions.contains("ok"));
			expect(true).ok();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOk() {
			assumeFalse(unimplementedFunctions.contains("ok"));
			expect(false).ok();
		}
		
		@Test
		public void testNotOk() {
			assumeFalse(unimplementedFunctions.contains("ok"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(false).not().ok();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOk() {
			assumeFalse(unimplementedFunctions.contains("ok"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(true).not().ok();
		}
		
		@Test
		public void testTrue() {
			assumeFalse(unimplementedFunctions.contains("_true"));
			expect(true)._true();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongTrue() {
			assumeFalse(unimplementedFunctions.contains("_true"));
			expect(false)._true();
		}
		
		@Test
		public void testNotTrue() {
			assumeFalse(unimplementedFunctions.contains("_true"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(false).not()._true();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotTrue() {
			assumeFalse(unimplementedFunctions.contains("_true"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(true).not()._true();
		}
		
		@Test
		public void testFalse() {
			assumeFalse(unimplementedFunctions.contains("_false"));
			expect(false)._false();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongFalse() {
			assumeFalse(unimplementedFunctions.contains("_false"));
			expect(true)._false();
		}
		
		@Test
		public void testNotFalse() {
			assumeFalse(unimplementedFunctions.contains("_false"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(true).not()._false();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotFalse() {
			assumeFalse(unimplementedFunctions.contains("_false"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(false).not()._false();
		}
		
		@Test
		public void testEquals() {
			assumeFalse(unimplementedFunctions.contains("equals"));
			expect(true).equal(true);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEquals() {
			assumeFalse(unimplementedFunctions.contains("equals"));
			expect(false).equal(true);
		}
		
		@Test
		public void testNotEquals() {
			assumeFalse(unimplementedFunctions.contains("equals"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(false).not().equal(true);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEquals() {
			assumeFalse(unimplementedFunctions.contains("equals"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(true).not().equal(true);
		}
	}
}
