package chaij;

import static chaij.ChaiJ.expect;
import static chaij.IntExpectation.unimplementedFunctions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;


import org.eclipse.jdt.annotation.NonNullByDefault;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
@NonNullByDefault
@SuppressWarnings("static-method")
public class IntExpectationTests {
	
	public static class GeneralContracts {
		
		@Test
		public void testLanguageChains() {
			IntExpectation expect = expect(42);
			
			IntExpectation other = expect.to.be.been.is.that.which.and.has.have.with.at.of.same;
			
			assertEquals(	"After every language chain, the object stays the same.",
							expect, other);
		}
		
		@Test
		public void testNot() {
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not();
		}
		
		@Test
		public void testAny() {
			assumeFalse(unimplementedFunctions.contains("any"));
			expect(42).any();
		}
		
		@Test
		public void testAll() {
			assumeFalse(unimplementedFunctions.contains("all"));
			expect(42).all();
		}
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42).equal(42);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42).above(41);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42).least(42);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42).below(43);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42).most(42);
		}
		
		@Test
		public void testWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42).within(42, 42);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42).match(i -> i == 42);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42).satisfy(i -> i == 42);
		}
		
		@Test
		public void testCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42).closeTo(42, 0);
		}
		
		@Test
		public void testValidByte() {
			assumeFalse(unimplementedFunctions.contains("validByte"));
			expect(42).validByte();
		}
		
		@Test
		public void testValidShort() {
			assumeFalse(unimplementedFunctions.contains("validShort"));
			expect(42).validShort();
		}
		
	}
	
	public static class NormalTests {
		
		@Test
		public void testEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42).equal(42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			expect(42).equal(43);
		}
		
		@Test
		public void testNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().equal(43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotEqual() {
			assumeFalse(unimplementedFunctions.contains("equal"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().equal(42);
		}
		
		@Test
		public void testAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42).above(41);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			expect(42).above(42);
		}
		
		@Test
		public void testNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().above(42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotAbove() {
			assumeFalse(unimplementedFunctions.contains("above"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().above(41);
		}
		
		@Test
		public void testLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42).least(42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			expect(42).least(43);
		}
		
		@Test
		public void testNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().least(43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotLeast() {
			assumeFalse(unimplementedFunctions.contains("least"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().least(42);
		}
		
		@Test
		public void testBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42).below(43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			expect(42).below(42);
		}
		
		@Test
		public void testNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().below(42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotBelow() {
			assumeFalse(unimplementedFunctions.contains("below"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().below(43);
		}
		
		@Test
		public void testMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42).most(42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			expect(42).most(41);
		}
		
		@Test
		public void testNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().most(41);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMost() {
			assumeFalse(unimplementedFunctions.contains("most"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().most(42);
		}
		
		@Test
		public void testWithinExact() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42).within(42, 42);
		}
		
		@Test
		public void testWithinNormal() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42).within(41, 43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42).within(41, 41);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			expect(42).within(43, 43);
		}
		
		@Test
		public void testNotWithinSmaller() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().within(41, 41);
		}
		
		@Test
		public void testNotWithinBigger() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().within(43, 43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotWithin() {
			assumeFalse(unimplementedFunctions.contains("within"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().within(41, 43);
		}
		
		@Test
		public void testMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42).match(i -> i == 42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			expect(42).match(i -> i == 43);
		}
		
		@Test
		public void testNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().match(i -> i == 43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotMatch() {
			assumeFalse(unimplementedFunctions.contains("match"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().match(i -> i == 42);
		}
		
		@Test
		public void testSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42).satisfy(i -> i == 42);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongtisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			expect(42).satisfy(i -> i == 43);
		}
		
		@Test
		public void testNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().satisfy(i -> i == 43);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotSatisfy() {
			assumeFalse(unimplementedFunctions.contains("satisfy"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().satisfy(i -> i == 42);
		}
		
		@Test
		public void testCloseToDistanceZero() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42).closeTo(42, 0);
		}
		
		@Test
		public void testCloseToDistanceOne() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42).closeTo(41, 1).closeTo(43, 1);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongoseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			expect(42).closeTo(41, 0);
		}
		
		@Test
		public void testNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().closeTo(41, 0);
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotCloseTo() {
			assumeFalse(unimplementedFunctions.contains("closeTo"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().closeTo(42, 0);
		}
		
		@Test
		public void testOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42).oneOf(new int[] {41, 42, 43});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			expect(42).oneOf(new int[] {41, 43});
		}
		
		@Test
		public void testNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().oneOf(new int[] {41, 43});
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotOneOf() {
			assumeFalse(unimplementedFunctions.contains("oneOf"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(42).not().oneOf(new int[] {41, 42, 43});
		}
		
		@Test
		public void testValidByte() {
			assumeFalse(unimplementedFunctions.contains("validByte"));
			expect(Byte.MAX_VALUE).validByte();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidByte() {
			assumeFalse(unimplementedFunctions.contains("validByte"));
			expect(Byte.MAX_VALUE + 1).validByte();
		}
		
		@Test
		public void testNotValidByte() {
			assumeFalse(unimplementedFunctions.contains("validByte"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(Byte.MAX_VALUE + 1).not().validByte();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidByte() {
			assumeFalse(unimplementedFunctions.contains("validByte"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(Byte.MAX_VALUE).not().validByte();
		}
		
		@Test
		public void testValidShort() {
			assumeFalse(unimplementedFunctions.contains("validShort"));
			expect(Short.MAX_VALUE).validShort();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongValidShort() {
			assumeFalse(unimplementedFunctions.contains("validShort"));
			expect(Short.MAX_VALUE + 1).validShort();
		}
		
		@Test
		public void testNotValidShort() {
			assumeFalse(unimplementedFunctions.contains("validShort"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(Short.MAX_VALUE + 1).not().validShort();
		}
		
		@Test(expected = UnmetExpectationException.class)
		public void testWrongNotValidShort() {
			assumeFalse(unimplementedFunctions.contains("validShort"));
			assumeFalse(unimplementedFunctions.contains("not"));
			expect(Short.MAX_VALUE).not().validShort();
		}
		
	}
}
