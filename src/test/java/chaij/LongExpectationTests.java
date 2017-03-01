package chaij;

import static chaij.ChaiJ.expect;
import static chaij.LongExpectation.unimplementedFunctions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;


import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
@NonNullByDefault
@SuppressWarnings("static-method")
public class LongExpectationTests {
	
	public static class GeneralContracts {
		
		@Test
		public void testLanguageChains() {
			LongExpectation expect = expect(42L);
			
			LongExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertEquals(	"After every language chain, the object stays the same.",
							expect, other);
		}
		
		@Test
		public void testNot() {
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not();
		}
		
		@Test
		public void testAny() {
			assumeFalse(unimplementedFunctions.contains("any"));
			expect(42L).any();
		}
		
		@Test
		public void testAll() {
			assumeFalse(unimplementedFunctions.contains("all"));
			expect(42L).all();
		}
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42L).equal(42L);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42L).above(41L);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42L).least(42L);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42L).below(43L);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42L).most(42L);
		}
		
		@Test
		public void testWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42L).within(42L, 42L);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42L).match(i -> i == 42L);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42L).satisfy(i -> i == 42L);
		}
		
		@Test
		public void testCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42L).closeTo(42L, 0L);
		}
		
		@Test
		public void testOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42L).oneOf(new long[] {42L});
		}
		
	}
	
	public static class NormalTests {
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42L).equal(42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42L).equal(43L);
		}
		
		@Test
		public void testNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().equal(43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().equal(42L);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42L).above(41L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42L).above(42L);
		}
		
		@Test
		public void testNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().above(42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().above(41L);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42L).least(42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42L).least(43L);
		}
		
		@Test
		public void testNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().least(43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().least(42L);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42L).below(43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42L).below(42L);
		}
		
		@Test
		public void testNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().below(42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().below(43L);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42L).most(42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42L).most(41L);
		}
		
		@Test
		public void testNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().most(41L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().most(42L);
		}
		
		@Test
		public void testWithinExact() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42L).within(42L, 42L);
		}
		
		@Test
		public void testWithinNormal() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42L).within(41L, 43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42L).within(41L, 41L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42L).within(43L, 43L);
		}
		
		@Test
		public void testNotWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().within(41L, 41L);
		}
		
		@Test
		public void testNotWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().within(43L, 43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().within(41L, 43L);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42L).match(i -> i == 42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42L).match(i -> i == 43L);
		}
		
		@Test
		public void testNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().match(i -> i == 43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().match(i -> i == 42L);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42L).satisfy(i -> i == 42L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42L).satisfy(i -> i == 43L);
		}
		
		@Test
		public void testNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().satisfy(i -> i == 43L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().satisfy(i -> i == 42L);
		}
		
		@Test
		public void testCloseToDistanceZero() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42L).closeTo(42L, 0L);
		}
		
		@Test
		public void testCloseToDistanceOne() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42L).closeTo(41L, 1L).closeTo(43L, 1L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongoseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42L).closeTo(41L, 0L);
		}
		
		@Test
		public void testNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().closeTo(41L, 0L);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().closeTo(42L, 0L);
		}
		
		@Test
		public void testOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42L).oneOf(new long[] {41L, 42L, 43L});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42L).oneOf(new long[] {41L, 43L});
		}
		
		@Test
		public void testNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().oneOf(new long[] {41L, 43L});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42L).not().oneOf(new long[] {41L, 42L, 43L});
		}
		
	}
}
