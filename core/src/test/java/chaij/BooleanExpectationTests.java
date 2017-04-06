package chaij;


import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static chaij.ChaiJ.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class BooleanExpectationTests {
	
	public static class GeneralContractTests {
		
		@Test
		public void testLanguageChains() {
			
			BooleanExpectation expect = expect(true);
			
			BooleanExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertThat("After every language chain, the object stays the same.", other, is(equalTo(expect)));
		}
		
		
		@Test
		public void testNot() {
			
			expect(true).not();
		}
		
		
		@Test
		public void testOk() {
			
			expect(true).ok();
		}
		
		
		@Test
		public void testTrue() {
			
			expect(true)._true();
		}
		
		
		@Test
		public void testFalse() {
			
			expect(false)._false();
		}
		
		
		@Test
		public void testEquals() {
			
			expect(true).equal(true);
		}
	}
	
	
	public static class NormalTests {
		
		
		@Test
		public void testOk() {
			
			expect(true).ok();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOk() {
			
			expect(false).ok();
		}
		
		
		@Test
		public void testNotOk() {
			
			expect(false).not().ok();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOk() {
			
			expect(true).not().ok();
		}
		
		
		@Test
		public void testTrue() {
			
			expect(true)._true();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongTrue() {
			
			expect(false)._true();
		}
		
		
		@Test
		public void testNotTrue() {
			
			expect(false).not()._true();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotTrue() {
			
			expect(true).not()._true();
		}
		
		
		@Test
		public void testFalse() {
			
			expect(false)._false();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongFalse() {
			
			expect(true)._false();
		}
		
		
		@Test
		public void testNotFalse() {
			
			expect(true).not()._false();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotFalse() {
			
			expect(false).not()._false();
		}
		
		
		@Test
		public void testEquals() {
			
			expect(true).equal(true);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEquals() {
			
			expect(false).equal(true);
		}
		
		
		@Test
		public void testNotEquals() {
			
			expect(false).not().equal(true);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEquals() {
			
			expect(true).not().equal(true);
		}
	}
	
	
	public static class MessageTests {
		
		@Rule
		public ExpectedException e = ExpectedException.none();
		
		
		@Test
		public void testStandardTest() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Custom message.");
			expect(true, "Special").test(false, "Custom", "message.");
		}
		
		
		@Test
		public void testOk() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected a ok-ish boolean.");
			expect(false).ok();
		}
		
		
		@Test
		public void testOkWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Expected a ok-ish boolean.");
			expect(false).ok("Special");
		}
		
		
		@Test
		public void testTrue() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected a true boolean.");
			expect(false)._true();
		}
		
		
		@Test
		public void testTrueWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Expected a true boolean.");
			expect(false)._true("Special");
		}
		
		
		@Test
		public void testFalse() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected a false boolean.");
			expect(true)._false();
		}
		
		
		@Test
		public void testFalseWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Expected a false boolean.");
			expect(true)._false("Special");
		}
		
		
		@Test
		public void testEquals() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected false to equal true.");
			expect(false).equal(true);
		}
		
		
		@Test
		public void testEqualsWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Expected false to equal true.");
			expect(false).equal(true, "Special");
		}
	}
}
