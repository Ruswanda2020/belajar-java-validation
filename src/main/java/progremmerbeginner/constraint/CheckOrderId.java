package progremmerbeginner.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import progremmerbeginner.Enum.CaseMode;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@CheckCase(groups = {CreditCardPaymentGroup.class},mode = CaseMode.Uppercase,message = "{order.id.upper}")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},message = "{order.id.notblank}")
@Size(groups = {VirtualAccountPaymentGroup.class,CreditCardPaymentGroup.class},min = 1,max = 10,message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {



    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
