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
	
	
	public static class MessageTests {
		
		@Rule
		public ExpectedException e = ExpectedException.none();
		
		
		@Test
		public void testStandardTest() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Custom message.");
			expect(42, "Special").test(false, "Custom", "message.");
		}
		
		
		@Test
		public void testEqual() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to equal 43.");
			expect(42).equal(43);
		}
		
		
		@Test
		public void testEqualWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to equal 43.");
			expect(42).equal(43, "Custom");
		}
		
		
		@Test
		public void testAbove() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be above 43.");
			expect(42).above(43);
		}
		
		
		@Test
		public void testAboveWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be above 43.");
			expect(42).above(43, "Custom");
		}
		
		
		@Test
		public void testLeast() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be at least 43.");
			expect(42).least(43);
		}
		
		
		@Test
		public void testLeastWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be at least 43.");
			expect(42).least(43, "Custom");
		}
		
		
		@Test
		public void testBelow() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be below 41.");
			expect(42).below(41);
		}
		
		
		@Test
		public void testBelowWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be below 41.");
			expect(42).below(41, "Custom");
		}
		
		
		@Test
		public void testMost() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be at most 41.");
			expect(42).most(41);
		}
		
		
		@Test
		public void testMostWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be at most 41.");
			expect(42).most(41, "Custom");
		}
		
		
		@Test
		public void testWithin() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be within 43 and 43.");
			expect(42).within(43, 43);
		}
		
		
		@Test
		public void testWithinWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be within 43 and 43.");
			expect(42).within(43, 43, "Custom");
		}
		
		
		@Test
		public void testMatch() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to match a custom predicate.");
			expect(42).match(i -> false);
		}
		
		
		@Test
		public void testMatchWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to match a custom predicate.");
			expect(42).match(i -> false, "Custom");
		}
		
		
		@Test
		public void testSatisfy() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to satisfy a custom predicate.");
			expect(42).satisfy(i -> false);
		}
		
		
		@Test
		public void testSatisfyWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to satisfy a custom predicate.");
			expect(42).satisfy(i -> false, "Custom");
		}
		
		
		@Test
		public void testCloseTo() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be close to 43 with a delta of 0.");
			expect(42).closeTo(43, 0);
		}
		
		
		@Test
		public void testCloseToWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be close to 43 with a delta of 0.");
			expect(42).closeTo(43, 0, "Custom");
		}
		
		
		@Test
		public void testOneOf() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be one of [41, 43].");
			expect(42).oneOf(41, 43);
		}
		
		
		@Test
		public void testOneOfWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be one of [41, 43].");
			expect(42).oneOf("Custom", 41, 43);
		}
		
		
		@Test
		public void testValidByte() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 128 to be a valid byte value.");
			expect(Byte.MAX_VALUE + 1).validByte();
		}
		
		
		@Test
		public void testValidByteWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 128 to be a valid byte value.");
			expect(Byte.MAX_VALUE + 1).validByte("Custom");
		}
		
		
		@Test
		public void testValidShort() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 32768 to be a valid short value.");
			expect(Short.MAX_VALUE + 1).validShort();
		}
		
		
		@Test
		public void testValidShortWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 32768 to be a valid short value.");
			expect(Short.MAX_VALUE + 1).validShort("Custom");
		}
	}
}
