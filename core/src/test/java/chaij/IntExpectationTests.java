package chaij;


import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static chaij.ChaiJ.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class IntExpectationTests {
	
	public static class GeneralContractTests {
		
		@Test
		public void testLanguageChains() {
			
			IntExpectation expect = expect(42);
			
			IntExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertThat("After every language chain, the object stays the same.",
					   other, is(equalTo(expect))
			);
		}
		
		
		@Test
		public void testNot() {
			
			expect(42).not();
		}
		
		
		@Test
		public void testEqual() {
			
			expect(42).equal(42);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42).above(41);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42).least(42);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42).below(43);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42).most(42);
		}
		
		
		@Test
		public void testWithin() {
			
			expect(42).within(42, 42);
		}
		
		
		@Test
		public void testMatch() {
			
			expect(42).match(i -> i == 42);
		}
		
		
		@Test
		public void testSatisfy() {
			
			expect(42).satisfy(i -> i == 42);
		}
		
		
		@Test
		public void testCloseTo() {
			
			expect(42).closeTo(42, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42).oneOf(42);
		}
		
		
		@Test
		public void testValidByte() {
			
			expect(42).validByte();
		}
		
		
		@Test
		public void testValidShort() {
			
			expect(42).validShort();
		}
	}
	
	
	@SuppressWarnings("UnnecessaryExplicitNumericCast")
	public static class NormalTests {
		
		@Test
		public void testEqual() {
			
			expect(42).equal(42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			
			expect(42).equal(43);
		}
		
		
		@Test
		public void testNotEqual() {
			
			expect(42).not().equal(43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			
			expect(42).not().equal(42);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42).above(41);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			
			expect(42).above(42);
		}
		
		
		@Test
		public void testNotAbove() {
			
			expect(42).not().above(42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			
			expect(42).not().above(41);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42).least(42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			
			expect(42).least(43);
		}
		
		
		@Test
		public void testNotLeast() {
			
			expect(42).not().least(43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			
			expect(42).not().least(42);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42).below(43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			
			expect(42).below(42);
		}
		
		
		@Test
		public void testNotBelow() {
			
			expect(42).not().below(42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			
			expect(42).not().below(43);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42).most(42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMost() {
			
			expect(42).most(41);
		}
		
		
		@Test
		public void testNotMost() {
			
			expect(42).not().most(41);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			
			expect(42).not().most(42);
		}
		
		
		@Test
		public void testWithinExact() {
			
			expect(42).within(42, 42);
		}
		
		
		@Test
		public void testWithinNormal() {
			
			expect(42).within(41, 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			
			expect(42).within(41, 41);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			
			expect(42).within(43, 43);
		}
		
		
		@Test
		public void testNotWithinSmaller() {
			
			expect(42).not().within(41, 41);
		}
		
		
		@Test
		public void testNotWithinBigger() {
			
			expect(42).not().within(43, 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			
			expect(42).not().within(41, 43);
		}
		
		
		@Test
		public void testMatch() {
			
			expect(42).match(i -> i == 42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			
			expect(42).match(i -> i == 43);
		}
		
		
		@Test
		public void testNotMatch() {
			
			expect(42).not().match(i -> i == 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			
			expect(42).not().match(i -> i == 42);
		}
		
		
		@Test
		public void testSatisfy() {
			
			expect(42).satisfy(i -> i == 42);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongSatisfy() {
			
			expect(42).satisfy(i -> i == 43);
		}
		
		
		@Test
		public void testNotSatisfy() {
			
			expect(42).not().satisfy(i -> i == 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			
			expect(42).not().satisfy(i -> i == 42);
		}
		
		
		@Test
		public void testCloseToDistanceZero() {
			
			expect(42).closeTo(42, 0);
		}
		
		
		@Test
		public void testCloseToDistanceOne() {
			
			expect(42).closeTo(41, 1).closeTo(43, 1);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongCloseTo() {
			
			expect(42).closeTo(41, 0);
		}
		
		
		@Test
		public void testNotCloseTo() {
			
			expect(42).not().closeTo(41, 0);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			
			expect(42).not().closeTo(42, 0);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42).oneOf(41, 42, 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			
			expect(42).oneOf(41, 43);
		}
		
		
		@Test
		public void testNotOneOf() {
			
			expect(42).not().oneOf(41, 43);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			
			expect(42).not().oneOf(41, 42, 43);
		}
		
		
		@Test
		public void testValidByte() {
			
			expect((int) Byte.MAX_VALUE).validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidByte() {
			
			expect((int) Byte.MAX_VALUE + 1).validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNegativeValidByte() {
			
			expect((int) Byte.MIN_VALUE - 1).validByte();
		}
		
		
		@Test
		public void testNotValidByte() {
			
			expect((int) Byte.MAX_VALUE + 1).not().validByte();
		}
		
		
		@Test
		public void testNotNegativeValidByte() {
			
			expect((int) Byte.MIN_VALUE - 1).not().validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidByte() {
			
			expect((int) Byte.MAX_VALUE).not().validByte();
		}
		
		
		@Test
		public void testValidShort() {
			
			expect((int) Short.MAX_VALUE).validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidShort() {
			
			expect((int) Short.MAX_VALUE + 1).validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNegativeValidShort() {
			
			expect((int) Short.MIN_VALUE - 1).validShort();
		}
		
		
		@Test
		public void testNotValidShort() {
			
			expect((int) Short.MAX_VALUE + 1).not().validShort();
		}
		
		
		@Test
		public void testNotNegativeValidShort() {
			
			expect((int) Short.MIN_VALUE - 1).not().validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidShort() {
			
			expect((int) Short.MAX_VALUE).not().validShort();
		}
	}
}
