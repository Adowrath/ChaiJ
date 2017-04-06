package chaij.junit;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a method to specifically use a single expectation.
 *
 * <p>
 * Use in combination with {@link MultipleExpectations#all()}.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleExpectation {
}
