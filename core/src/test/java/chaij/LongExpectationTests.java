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
public class LongExpectationTests {
	
	public static class GeneralContractTests {
		
		@Test
		public void testLanguageChains() {
			
			LongExpectation expect = expect(42L);
			
			LongExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertThat("After every language chain, the object stays the same.",
					   expect, is(equalTo(other))
			);
		}
		
		
		@Test
		public void testNot() {
			
			expect(42L).not();
		}
		
		
		@Test
		public void testEqual() {
			
			expect(42L).equal(42L);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42L).above(41L);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42L).least(42L);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42L).below(43L);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42L).most(42L);
		}
		
		
		@Test
		public void testWithin() {
			
			expect(42L).within(42L, 42L);
		}
		
		
		@Test
		public void testMatch() {
			
			expect(42L).match(l -> l == 42L);
		}
		
		
		@Test
		public void testSatisfy() {
			
			expect(42L).satisfy(l -> l == 42L);
		}
		
		
		@Test
		public void testCloseTo() {
			
			expect(42L).closeTo(42L, 0L);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42L).oneOf(42L);
		}
		
		
		@Test
		public void testValidInt() {
			
			expect(42L).validInt();
		}
		
		
		@Test
		public void testValidByte() {
			
			expect(42L).validByte();
		}
		
		
		@Test
		public void testValidShort() {
			
			expect(42L).validShort();
		}
	}
	
	
	@SuppressWarnings("UnnecessaryExplicitNumericCast")
	public static class NormalTests {
		
		@Test
		public void testEqual() {
			
			expect(42L).equal(42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			
			expect(42L).equal(43L);
		}
		
		
		@Test
		public void testNotEqual() {
			
			expect(42L).not().equal(43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			
			expect(42L).not().equal(42L);
		}
		
		
		@Test
		public void testAbove() {
			
			expect(42L).above(41L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			
			expect(42L).above(42L);
		}
		
		
		@Test
		public void testNotAbove() {
			
			expect(42L).not().above(42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			
			expect(42L).not().above(41L);
		}
		
		
		@Test
		public void testLeast() {
			
			expect(42L).least(42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			
			expect(42L).least(43L);
		}
		
		
		@Test
		public void testNotLeast() {
			
			expect(42L).not().least(43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			
			expect(42L).not().least(42L);
		}
		
		
		@Test
		public void testBelow() {
			
			expect(42L).below(43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			
			expect(42L).below(42L);
		}
		
		
		@Test
		public void testNotBelow() {
			
			expect(42L).not().below(42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			
			expect(42L).not().below(43L);
		}
		
		
		@Test
		public void testMost() {
			
			expect(42L).most(42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtMost() {
			
			expect(42L).most(41L);
		}
		
		
		@Test
		public void testNotMost() {
			
			expect(42L).not().most(41L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			
			expect(42L).not().most(42L);
		}
		
		
		@Test
		public void testWithinExact() {
			
			expect(42L).within(42L, 42L);
		}
		
		
		@Test
		public void testWithinNormal() {
			
			expect(42L).within(41L, 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			
			expect(42L).within(41L, 41L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			
			expect(42L).within(43L, 43L);
		}
		
		
		@Test
		public void testNotWithinSmaller() {
			
			expect(42L).not().within(41L, 41L);
		}
		
		
		@Test
		public void testNotWithinBigger() {
			
			expect(42L).not().within(43L, 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			
			expect(42L).not().within(41L, 43L);
		}
		
		
		@Test
		public void testMatch() {
			
			expect(42L).match(l -> l == 42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			
			expect(42L).match(l -> l == 43L);
		}
		
		
		@Test
		public void testNotMatch() {
			
			expect(42L).not().match(l -> l == 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			
			expect(42L).not().match(l -> l == 42L);
		}
		
		
		@Test
		public void testSatisfy() {
			
			expect(42L).satisfy(l -> l == 42L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtisfy() {
			
			expect(42L).satisfy(l -> l == 43L);
		}
		
		
		@Test
		public void testNotSatisfy() {
			
			expect(42L).not().satisfy(l -> l == 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			
			expect(42L).not().satisfy(l -> l == 42L);
		}
		
		
		@Test
		public void testCloseToDistanceZero() {
			
			expect(42L).closeTo(42L, 0L);
		}
		
		
		@Test
		public void testCloseToDistanceOne() {
			
			expect(42L).closeTo(41L, 1L).closeTo(43L, 1L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongoseTo() {
			
			expect(42L).closeTo(41L, 0L);
		}
		
		
		@Test
		public void testNotCloseTo() {
			
			expect(42L).not().closeTo(41L, 0L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			
			expect(42L).not().closeTo(42L, 0L);
		}
		
		
		@Test
		public void testOneOf() {
			
			expect(42L).oneOf(41L, 42L, 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			
			expect(42L).oneOf(41L, 43L);
		}
		
		
		@Test
		public void testNotOneOf() {
			
			expect(42L).not().oneOf(41L, 43L);
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			
			expect(42L).not().oneOf(41L, 42L, 43L);
		}
		
		
		@Test
		public void testValidInt() {
			
			expect((long) Integer.MAX_VALUE).validInt();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidInt() {
			
			expect((long) Integer.MAX_VALUE + 1L).validInt();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNegativeValidInt() {
			
			expect((long) Integer.MIN_VALUE - 1L).validInt();
		}
		
		
		@Test
		public void testNotValidInt() {
			
			expect((long) Integer.MAX_VALUE + 1L).not().validInt();
		}
		
		
		@Test
		public void testNotNegativeValidInt() {
			
			expect((long) Integer.MIN_VALUE - 1L).not().validInt();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidInt() {
			
			expect((long) Integer.MAX_VALUE).not().validInt();
		}
		
		
		@Test
		public void testValidByte() {
			
			expect((long) Byte.MAX_VALUE).validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidByte() {
			
			expect((long) Byte.MAX_VALUE + 1L).validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNegativeValidByte() {
			
			expect((long) Byte.MIN_VALUE - 1L).validByte();
		}
		
		
		@Test
		public void testNotValidByte() {
			
			expect((long) Byte.MAX_VALUE + 1L).not().validByte();
		}
		
		
		@Test
		public void testNotNegativeValidByte() {
			
			expect((long) Byte.MIN_VALUE - 1L).not().validByte();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidByte() {
			
			expect((long) Byte.MAX_VALUE).not().validByte();
		}
		
		
		@Test
		public void testValidShort() {
			
			expect((long) Short.MAX_VALUE).validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidShort() {
			
			expect((long) Short.MAX_VALUE + 1L).validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNegativeValidShort() {
			
			expect((long) Short.MIN_VALUE - 1L).validShort();
		}
		
		
		@Test
		public void testNotValidShort() {
			
			expect((long) Short.MAX_VALUE + 1L).not().validShort();
		}
		
		
		@Test
		public void testNotNegativeValidShort() {
			
			expect((long) Short.MIN_VALUE - 1L).not().validShort();
		}
		
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidShort() {
			
			expect((long) Short.MAX_VALUE).not().validShort();
		}
	}
	
	
	public static class MessageTests {
		
		@Rule
		public ExpectedException e = ExpectedException.none();
		
		
		@Test
		public void testStandardTest() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Special: Custom message.");
			expect(42L, "Special").test(false, "Custom", "message.");
		}
		
		
		@Test
		public void testEqual() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to equal 43.");
			expect(42L).equal(43L);
		}
		
		
		@Test
		public void testEqualWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to equal 43.");
			expect(42L).equal(43L, "Custom");
		}
		
		
		@Test
		public void testAbove() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be above 43.");
			expect(42L).above(43L);
		}
		
		
		@Test
		public void testAboveWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be above 43.");
			expect(42L).above(43L, "Custom");
		}
		
		
		@Test
		public void testLeast() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be at least 43.");
			expect(42L).least(43L);
		}
		
		
		@Test
		public void testLeastWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be at least 43.");
			expect(42L).least(43L, "Custom");
		}
		
		
		@Test
		public void testBelow() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be below 41.");
			expect(42L).below(41L);
		}
		
		
		@Test
		public void testBelowWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be below 41.");
			expect(42L).below(41L, "Custom");
		}
		
		
		@Test
		public void testMost() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be at most 41.");
			expect(42L).most(41L);
		}
		
		
		@Test
		public void testMostWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be at most 41.");
			expect(42L).most(41L, "Custom");
		}
		
		
		@Test
		public void testWithin() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be within 43 and 43.");
			expect(42L).within(43L, 43L);
		}
		
		
		@Test
		public void testWithinWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be within 43 and 43.");
			expect(42L).within(43L, 43L, "Custom");
		}
		
		
		@Test
		public void testMatch() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to match a custom predicate.");
			expect(42L).match(l -> false);
		}
		
		
		@Test
		public void testMatchWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to match a custom predicate.");
			expect(42L).match(l -> false, "Custom");
		}
		
		
		@Test
		public void testSatisfy() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to satisfy a custom predicate.");
			expect(42L).satisfy(l -> false);
		}
		
		
		@Test
		public void testSatisfyWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to satisfy a custom predicate.");
			expect(42L).satisfy(l -> false, "Custom");
		}
		
		
		@Test
		public void testCloseTo() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be close to 43 with a delta of 0.");
			expect(42L).closeTo(43L, 0L);
		}
		
		
		@Test
		public void testCloseToWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be close to 43 with a delta of 0.");
			expect(42L).closeTo(43L, 0L, "Custom");
		}
		
		
		@Test
		public void testOneOf() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 42 to be one of [41, 43].");
			expect(42L).oneOf(41L, 43L);
		}
		
		
		@Test
		public void testOneOfWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 42 to be one of [41, 43].");
			expect(42L).oneOf("Custom", 41L, 43L);
		}
		
		
		@Test
		public void testValidByte() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 128 to be a valid byte value.");
			expect(Byte.MAX_VALUE + 1L).validByte();
		}
		
		
		@Test
		public void testValidByteWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 128 to be a valid byte value.");
			expect(Byte.MAX_VALUE + 1L).validByte("Custom");
		}
		
		
		@Test
		public void testValidShort() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 32768 to be a valid short value.");
			expect(Short.MAX_VALUE + 1L).validShort();
		}
		
		
		@Test
		public void testValidShortWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 32768 to be a valid short value.");
			expect(Short.MAX_VALUE + 1L).validShort("Custom");
		}
		
		
		@Test
		public void testValidInteger() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Expected 2147483648 to be a valid integer value.");
			expect(Integer.MAX_VALUE + 1L).validInt();
		}
		
		
		@Test
		public void testValidIntegerWithMessage() {
			
			e.expect(UnmetExpectationException.class);
			e.expectMessage("Custom: Expected 2147483648 to be a valid integer value.");
			expect(Integer.MAX_VALUE + 1L).validInt("Custom");
		}
	}
}
