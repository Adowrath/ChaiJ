package chaij;


import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static chaij.ChaiJ.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class DoubleExpectationTests {
	
	public static class GeneralContractTests {
		
		@Test
		public void testLanguageChains() {
			
			DoubleExpectation expect = expect(42.0);
			
			DoubleExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertThat("After every language chain, the object stays the same.",
					   other, is(equalTo(expect))
			);
		}
		
		
		@Test
		public void testNot() {
			
			expect(42.0).not();
		}
		
		
		@Test
		public void testFinite() {
			
			expect(42.0).finite();
		}
		
		
		@Test
		public void testInfinite() {
			
			expect(Double.POSITIVE_INFINITY).infinite();
		}
		
		
		@Test
		public void testNaN() {
			
			expect(Double.NaN).NaN();
		}
		
		
		@Test
		public void testEqual() {
			
			expect(42.0).equal(42.0);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42.0).above(41.0);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42.0).least(42.0);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42.0).below(43.0);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42.0).most(42.0);
		}
		
		
		@Test
		public void testWithin() {
			
			expect(42.0).within(42.0, 42.0);
		}
		
		
		@Test
		public void testMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0).match(d -> d == 42.0);
		}
		
		
		@Test
		public void testSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0).satisfy(d -> d == 42.0);
		}
		
		
		@Test
		public void testCloseTo() {
			
			expect(42.0).closeTo(42.0, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42.0).oneOf(42.0);
		}
		
	}
	
	
	public static class NormalTests {
		
		@Test
		public void testFinite() {
			
			expect(42.0).finite();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongFinite() {
			
			expect(Double.POSITIVE_INFINITY).finite();
		}
		
		
		@Test
		public void testNotFinite() {
			
			expect(Double.POSITIVE_INFINITY).not().finite();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotFinite() {
			
			expect(42.0).not().finite();
		}
		
		
		@Test
		public void testInfinite() {
			
			expect(Double.POSITIVE_INFINITY).infinite();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongInfinite() {
			
			expect(42.0).infinite();
		}
		
		
		@Test
		public void testNotInfinite() {
			
			expect(42.0).not().infinite();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotInfinite() {
			
			expect(Double.POSITIVE_INFINITY).not().infinite();
		}
		
		
		@Test
		public void testNaN() {
			
			expect(Double.NaN).NaN();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNaN() {
			
			expect(42.0).NaN();
		}
		
		
		@Test
		public void testNotNaN() {
			
			expect(42.0).not().NaN();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotNaN() {
			
			expect(Double.NaN).not().NaN();
		}
		
		
		@Test
		public void testEqual() {
			
			expect(42.0).equal(42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			
			expect(42.0).equal(43.0);
		}
		
		
		@Test
		public void testNotEqual() {
			
			expect(42.0).not().equal(43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			
			expect(42.0).not().equal(42.0);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42.0).above(41.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			
			expect(42.0).above(42.0);
		}
		
		
		@Test
		public void testNotAbove() {
			
			expect(42.0).not().above(42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			
			expect(42.0).not().above(41.0);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42.0).least(42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			
			expect(42.0).least(43.0);
		}
		
		
		@Test
		public void testNotLeast() {
			
			expect(42.0).not().least(43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			
			expect(42.0).not().least(42.0);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42.0).below(43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			
			expect(42.0).below(42.0);
		}
		
		
		@Test
		public void testNotBelow() {
			
			expect(42.0).not().below(42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			
			expect(42.0).not().below(43.0);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42.0).most(42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMost() {
			
			expect(42.0).most(41.0);
		}
		
		
		@Test
		public void testNotMost() {
			
			expect(42.0).not().most(41.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			
			expect(42.0).not().most(42.0);
		}
		
		
		@Test
		public void testWithinExact() {
			
			expect(42.0).within(42.0, 42.0);
		}
		
		
		@Test
		public void testWithinNormal() {
			
			expect(42.0).within(41.0, 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			
			expect(42.0).within(41.0, 41.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			
			expect(42.0).within(43.0, 43.0);
		}
		
		
		@Test
		public void testNotWithinSmaller() {
			
			expect(42.0).not().within(41.0, 41.0);
		}
		
		
		@Test
		public void testNotWithinBigger() {
			
			expect(42.0).not().within(43.0, 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			
			expect(42.0).not().within(41.0, 43.0);
		}
		
		
		@Test
		public void testMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0).match(d -> d == 42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0).match(d -> d == 43.0);
		}
		
		
		@Test
		public void testNotMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0).not().match(d -> d == 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0).not().match(d -> d == 42.0);
		}
		
		
		@Test
		public void testSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0).satisfy(d -> d == 42.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0).satisfy(d -> d == 43.0);
		}
		
		
		@Test
		public void testNotSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0).not().satisfy(d -> d == 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0).not().satisfy(d -> d == 42.0);
		}
		
		
		@Test
		public void testCloseToDistanceZero() {
			
			expect(42.0).closeTo(42.0, 0);
		}
		
		
		@Test
		public void testCloseToDistanceOne() {
			
			expect(42.0).closeTo(41.0, 1).closeTo(43.0, 1);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongCloseTo() {
			
			expect(42.0).closeTo(41.0, 0);
		}
		
		
		@Test
		public void testNotCloseTo() {
			
			expect(42.0).not().closeTo(41.0, 0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			
			expect(42.0).not().closeTo(42.0, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42.0).oneOf(41.0, 42.0, 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			
			expect(42.0).oneOf(41.0, 43.0);
		}
		
		
		@Test
		public void testNotOneOf() {
			
			expect(42.0).not().oneOf(41.0, 43.0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			
			expect(42.0).not().oneOf(41.0, 42.0, 43.0);
		}
	}
}
