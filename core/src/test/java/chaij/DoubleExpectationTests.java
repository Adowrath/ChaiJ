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
public class DoubleExpectationTests {
	
	public static class GeneralContractTests {
		
		@Test
		public void testLanguageChains() {
			
			DoubleExpectation expect = expect(42.0D);
			
			DoubleExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertThat("After every language chain, the object stays the same.",
					   other, is(equalTo(expect))
			);
		}
		
		
		@Test
		public void testNot() {
			
			expect(42.0D).not();
		}
		
		
		@Test
		public void testFinite() {
			
			expect(42.0D).finite();
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
			
			expect(42.0D).equal(42.0D);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42.0D).above(41.0D);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42.0D).least(42.0D);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42.0D).below(43.0D);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42.0D).most(42.0D);
		}
		
		
		@Test
		public void testWithin() {
			
			expect(42.0D).within(42.0D, 42.0D);
		}
		
		
		@Test
		public void testMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).match(d -> d == 42.0D);
		}
		
		
		@Test
		public void testSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).satisfy(d -> d == 42.0D);
		}
		
		
		@Test
		public void testCloseTo() {
			
			expect(42.0D).closeTo(42.0D, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42.0D).oneOf(42.0D);
		}
		
	}
	
	
	public static class NormalTests {
		
		@Test
		public void testFinite() {
			
			expect(42.0D).finite();
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
			
			expect(42.0D).not().finite();
		}
		
		
		@Test
		public void testInfinite() {
			
			expect(Double.POSITIVE_INFINITY).infinite();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongInfinite() {
			
			expect(42.0D).infinite();
		}
		
		
		@Test
		public void testNotInfinite() {
			
			expect(42.0D).not().infinite();
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
			
			expect(42.0D).NaN();
		}
		
		
		@Test
		public void testNotNaN() {
			
			expect(42.0D).not().NaN();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotNaN() {
			
			expect(Double.NaN).not().NaN();
		}
		
		
		@Test
		public void testEqual() {
			
			expect(42.0D).equal(42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			
			expect(42.0D).equal(43.0D);
		}
		
		
		@Test
		public void testNotEqual() {
			
			expect(42.0D).not().equal(43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			
			expect(42.0D).not().equal(42.0D);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42.0D).above(41.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			
			expect(42.0D).above(42.0D);
		}
		
		
		@Test
		public void testNotAbove() {
			
			expect(42.0D).not().above(42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			
			expect(42.0D).not().above(41.0D);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42.0D).least(42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			
			expect(42.0D).least(43.0D);
		}
		
		
		@Test
		public void testNotLeast() {
			
			expect(42.0D).not().least(43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			
			expect(42.0D).not().least(42.0D);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42.0D).below(43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			
			expect(42.0D).below(42.0D);
		}
		
		
		@Test
		public void testNotBelow() {
			
			expect(42.0D).not().below(42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			
			expect(42.0D).not().below(43.0D);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42.0D).most(42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMost() {
			
			expect(42.0D).most(41.0D);
		}
		
		
		@Test
		public void testNotMost() {
			
			expect(42.0D).not().most(41.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			
			expect(42.0D).not().most(42.0D);
		}
		
		
		@Test
		public void testWithinExact() {
			
			expect(42.0D).within(42.0D, 42.0D);
		}
		
		
		@Test
		public void testWithinNormal() {
			
			expect(42.0D).within(41.0D, 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			
			expect(42.0D).within(41.0D, 41.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			
			expect(42.0D).within(43.0D, 43.0D);
		}
		
		
		@Test
		public void testNotWithinSmaller() {
			
			expect(42.0D).not().within(41.0D, 41.0D);
		}
		
		
		@Test
		public void testNotWithinBigger() {
			
			expect(42.0D).not().within(43.0D, 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			
			expect(42.0D).not().within(41.0D, 43.0D);
		}
		
		
		@Test
		public void testMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).match(d -> d == 42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).match(d -> d == 43.0D);
		}
		
		
		@Test
		public void testNotMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).not().match(d -> d == 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).not().match(d -> d == 42.0D);
		}
		
		
		@Test
		public void testSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).satisfy(d -> d == 42.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).satisfy(d -> d == 43.0D);
		}
		
		
		@Test
		public void testNotSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).not().satisfy(d -> d == 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			
			//noinspection FloatingPointEquality
			expect(42.0D).not().satisfy(d -> d == 42.0D);
		}
		
		
		@Test
		public void testCloseToDistanceZero() {
			
			expect(42.0D).closeTo(42.0D, 0);
		}
		
		
		@Test
		public void testCloseToDistanceOne() {
			
			expect(42.0D).closeTo(41.0D, 1).closeTo(43.0D, 1);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongCloseTo() {
			
			expect(42.0D).closeTo(41.0D, 0);
		}
		
		
		@Test
		public void testNotCloseTo() {
			
			expect(42.0D).not().closeTo(41.0D, 0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			
			expect(42.0D).not().closeTo(42.0D, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42.0D).oneOf(41.0D, 42.0D, 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			
			expect(42.0D).oneOf(41.0D, 43.0D);
		}
		
		
		@Test
		public void testNotOneOf() {
			
			expect(42.0D).not().oneOf(41.0D, 43.0D);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			
			expect(42.0D).not().oneOf(41.0D, 42.0D, 43.0D);
		}
	}
	
	
	public static class MessageTests {
		
		@Rule
		public ExpectedException e = ExpectedException.none();
		
		
		@Test
		public void testStandardTest() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Custom message.");
			expect(42.0D, "Special").test(false, "Custom", "message.");
		}
		
		
		@Test
		public void testFinite() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected Infinity to be finite.");
			expect(Double.POSITIVE_INFINITY).finite();
		}
		
		
		@Test
		public void testFiniteWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected Infinity to be finite.");
			expect(Double.POSITIVE_INFINITY).finite("Custom message!");
		}
		
		
		@Test
		public void testInfinite() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be infinite.");
			expect(42.0D).infinite();
		}
		
		
		@Test
		public void testInfiniteWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be infinite.");
			expect(42.0D).infinite("Custom message!");
		}
		
		
		@Test
		public void testNaN() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be NaN.");
			expect(42.0D).NaN();
		}
		
		
		@Test
		public void testNaNWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be NaN.");
			expect(42.0D).NaN("Custom message!");
		}
		
		
		@Test
		public void testEqual() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to equal 43.0.");
			expect(42.0D).equal(43.0D);
		}
		
		
		@Test
		public void testEqualWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to equal 43.0.");
			expect(42.0D).equal(43.0D, "Custom message!");
		}
		
		
		@Test
		public void testAbove() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be above 43.0.");
			expect(42.0D).above(43.0D);
		}
		
		
		@Test
		public void testAboveWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be above 43.0.");
			expect(42.0D).above(43.0D, "Custom message!");
		}
		
		
		@Test
		public void testLeast() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be at least 43.0.");
			expect(42.0D).least(43.0D);
		}
		
		
		@Test
		public void testLeastWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be at least 43.0.");
			expect(42.0D).least(43.0D, "Custom message!");
		}
		
		
		@Test
		public void testBelow() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be below 41.0.");
			expect(42.0D).below(41.0D);
		}
		
		
		@Test
		public void testBelowWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be below 41.0.");
			expect(42.0D).below(41.0D, "Custom message!");
		}
		
		
		@Test
		public void testMost() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be at most 41.0.");
			expect(42.0D).most(41.0D);
		}
		
		
		@Test
		public void testMostWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be at most 41.0.");
			expect(42.0D).most(41.0D, "Custom message!");
		}
		
		
		@Test
		public void testWithin() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be within 43.0 and 43.0.");
			expect(42.0D).within(43.0D, 43.0D);
		}
		
		
		@Test
		public void testWithinWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be within 43.0 and 43.0.");
			expect(42.0D).within(43.0D, 43.0D, "Custom message!");
		}
		
		
		@Test
		public void testMatch() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to match a custom predicate.");
			expect(42.0D).match(d -> false);
		}
		
		
		@Test
		public void testMatchWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to match a custom predicate.");
			expect(42.0D).match(d -> false, "Custom message!");
		}
		
		
		@Test
		public void testSatisfy() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to satisfy a custom predicate.");
			expect(42.0D).satisfy(d -> false);
		}
		
		
		@Test
		public void testSatisfyWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to satisfy a custom predicate.");
			expect(42.0D).satisfy(d -> false, "Custom message!");
		}
		
		
		@Test
		public void testCloseTo() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be close to 43.0 with a delta of 0.0.");
			expect(42.0D).closeTo(43.0D, 0.0D);
		}
		
		
		@Test
		public void testCloseToWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be close to 43.0 with a delta of 0.0.");
			expect(42.0D).closeTo(43.0D, 0.0D, "Custom message!");
		}
		
		
		@Test
		public void testOneOf() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42.0 to be one of [41.0, 43.0].");
			expect(42.0D).oneOf(41.0D, 43.0D);
		}
		
		
		@Test
		public void testOneOfWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom message!: Expected 42.0 to be one of [41.0, 43.0].");
			expect(42.0D).oneOf("Custom message!", 41.0D, 43.0D);
		}
	}
}
