package chaij;

import static chaij.ChaiJ.expect;
import static chaij.DoubleExpectation.unimplementedFunctions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;


import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
@NonNullByDefault
@SuppressWarnings("static-method")
public class DoubleExpectationTests {
	
	public static class GeneralContracts {
		
		@Test
		public void testLanguageChains() {
			DoubleExpectation expect = expect(42.0);
			
			DoubleExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertEquals(	"After every language chain, the object stays the same.",
							expect, other);
		}
		
		@Test
		public void testNot() {
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not();
		}
		
		@Test
		public void testAny() {
			assumeFalse(unimplementedFunctions.contains("any"));
			expect(42.0).any();
		}
		
		@Test
		public void testAll() {
			assumeFalse(unimplementedFunctions.contains("all"));
			expect(42.0).all();
		}
		
		@Test
		public void testFinite() {
			assumeFalse(unimplementedFunctions.contains("finite"));
			expect(42.0).finite();
		}
		
		@Test
		public void testInfinite() {
			assumeFalse(unimplementedFunctions.contains("infinite"));
			expect(1.0 / 0.0).infinite();
		}
		
		@Test
		public void testNaN() {
			assumeFalse(unimplementedFunctions.contains("NaN"));
			expect(0.0 / 0.0).NaN();
		}
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42.0).equal(42.0);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42.0).above(41.0);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42.0).least(42.0);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42.0).below(43.0);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42.0).most(42.0);
		}
		
		@Test
		public void testWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42.0).within(42.0, 42.0);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42.0).match(i -> i == 42.0);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42.0).satisfy(i -> i == 42.0);
		}
		
		@Test
		public void testCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42.0).closeTo(42.0, 0);
		}
		
		@Test
		public void testOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42.0).oneOf(new double[] {42.0});
		}
		
	}
	
	public static class NormalTests {
		
		@Test
		public void testFinite() {
			assumeFalse(unimplementedFunctions.contains("finite"));
			expect(42.0).finite();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongFinite() {
			assumeFalse(unimplementedFunctions.contains("finite"));
			expect(1.0 / 0.0).finite();
		}
		
		@Test
		public void testNotFinite() {
			assumeFalse(unimplementedFunctions.contains("finite"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(1.0 / 0.0).not().finite();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotFinite() {
			assumeFalse(unimplementedFunctions.contains("finite"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().finite();
		}
		
		@Test
		public void testInfinite() {
			assumeFalse(unimplementedFunctions.contains("infinite"));
			expect(1.0 / 0.0).infinite();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongInfinite() {
			assumeFalse(unimplementedFunctions.contains("infinite"));
			expect(42.0).infinite();
		}
		
		@Test
		public void testNotInfinite() {
			assumeFalse(unimplementedFunctions.contains("infinite"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().infinite();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotInfinite() {
			assumeFalse(unimplementedFunctions.contains("infinite"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(1.0 / 0.0).not().infinite();
		}
		
		@Test
		public void testNaN() {
			assumeFalse(unimplementedFunctions.contains("NaN"));
			expect(0.0 / 0.0).NaN();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNaN() {
			assumeFalse(unimplementedFunctions.contains("NaN"));
			expect(42.0).NaN();
		}
		
		@Test
		public void testNotNaN() {
			assumeFalse(unimplementedFunctions.contains("NaN"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().NaN();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotNaN() {
			assumeFalse(unimplementedFunctions.contains("NaN"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(0.0 / 0.0).not().NaN();
		}
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42.0).equal(42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42.0).equal(43.0);
		}
		
		@Test
		public void testNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().equal(43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().equal(42.0);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42.0).above(41.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42.0).above(42.0);
		}
		
		@Test
		public void testNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().above(42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().above(41.0);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42.0).least(42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42.0).least(43.0);
		}
		
		@Test
		public void testNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().least(43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().least(42.0);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42.0).below(43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42.0).below(42.0);
		}
		
		@Test
		public void testNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().below(42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().below(43.0);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42.0).most(42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42.0).most(41.0);
		}
		
		@Test
		public void testNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().most(41.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().most(42.0);
		}
		
		@Test
		public void testWithinExact() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42.0).within(42.0, 42.0);
		}
		
		@Test
		public void testWithinNormal() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42.0).within(41.0, 43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42.0).within(41.0, 41.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42.0).within(43.0, 43.0);
		}
		
		@Test
		public void testNotWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().within(41.0, 41.0);
		}
		
		@Test
		public void testNotWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().within(43.0, 43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().within(41.0, 43.0);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42.0).match(i -> i == 42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42.0).match(i -> i == 43.0);
		}
		
		@Test
		public void testNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().match(i -> i == 43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().match(i -> i == 42.0);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42.0).satisfy(i -> i == 42.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42.0).satisfy(i -> i == 43.0);
		}
		
		@Test
		public void testNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().satisfy(i -> i == 43.0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().satisfy(i -> i == 42.0);
		}
		
		@Test
		public void testCloseToDistanceZero() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42.0).closeTo(42.0, 0);
		}
		
		@Test
		public void testCloseToDistanceOne() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42.0).closeTo(41.0, 1).closeTo(43.0, 1);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongoseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42.0).closeTo(41.0, 0);
		}
		
		@Test
		public void testNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().closeTo(41.0, 0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().closeTo(42.0, 0);
		}
		
		@Test
		public void testOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42.0).oneOf(new double[] {41.0, 42.0, 43.0});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42.0).oneOf(new double[] {41.0, 43.0});
		}
		
		@Test
		public void testNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().oneOf(new double[] {41.0, 43.0});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42.0).not().oneOf(new double[] {41.0, 42.0, 43.0});
		}
		
	}
}
