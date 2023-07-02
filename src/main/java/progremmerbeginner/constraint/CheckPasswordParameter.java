package progremmerbeginner.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParamValidator.class})
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE, ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();
    int retypePasswordParam();

    String message() default "retype password and password must same";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
