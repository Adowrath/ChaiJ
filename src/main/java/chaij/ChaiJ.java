package chaij;

import static org.eclipse.jdt.annotation.DefaultLocation.FIELD;
import static org.eclipse.jdt.annotation.DefaultLocation.RETURN_TYPE;
import static org.eclipse.jdt.annotation.DefaultLocation.TYPE_ARGUMENT;
import static org.eclipse.jdt.annotation.DefaultLocation.TYPE_BOUND;


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault({RETURN_TYPE, FIELD, TYPE_BOUND, TYPE_ARGUMENT})
public class ChaiJ {
	
	public static IntExpectation expect(int i) {
		return new IntExpectation(i);
	}
	
	public static IntExpectation expect(int i, @NonNull String message) {
		return new IntExpectation(i, message);
	}
	
	public static LongExpectation expect(long i) {
		return new LongExpectation(i);
	}
	
	public static LongExpectation expect(long i, @NonNull String message) {
		return new LongExpectation(i, message);
	}
	
	public static DoubleExpectation expect(double i) {
		return new DoubleExpectation(i);
	}
	
	public static DoubleExpectation expect(double i, @NonNull String message) {
		return new DoubleExpectation(i, message);
	}
	
	public static BooleanExpectation expect(boolean i) {
		return new BooleanExpectation(i);
	}
	
	public static BooleanExpectation expect(boolean i,
											@NonNull String message) {
		return new BooleanExpectation(i, message);
	}
}
