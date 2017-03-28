package chaij;


@SuppressWarnings({"MethodReturnOfConcreteClass", "OverloadedMethodsWithSameNumberOfParameters"})
public final class ChaiJ {
	
	private ChaiJ() {}
	
	
	public static IntExpectation expect(int value) {
		
		return new IntExpectation(value, null);
	}
	
	
	public static IntExpectation expect(int value, String message) {
		
		return new IntExpectation(value, message);
	}
	
	
	public static LongExpectation expect(long value) {
		
		return new LongExpectation(value, null);
	}
	
	
	public static LongExpectation expect(long value, String message) {
		
		return new LongExpectation(value, message);
	}
	
	
	public static DoubleExpectation expect(double value) {
		
		return new DoubleExpectation(value, null);
	}
	
	
	public static DoubleExpectation expect(double value, String message) {
		
		return new DoubleExpectation(value, message);
	}
	
	
	public static BooleanExpectation expect(boolean value) {
		
		return new BooleanExpectation(value, null);
	}
	
	
	public static BooleanExpectation expect(boolean value, String message) {
		
		return new BooleanExpectation(value, message);
	}
	
}
