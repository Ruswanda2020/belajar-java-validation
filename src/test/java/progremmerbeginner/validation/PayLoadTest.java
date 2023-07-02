package progremmerbeginner.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.payload.EmailErrorMessage;

import java.util.Set;
import java.util.concurrent.locks.StampedLock;

public class PayLoadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {
        Payment payment=new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111");
        payment.setVirtualAccount("VA123456789");

        Set<ConstraintViolation<Object>> validate = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> objectConstraintViolation : validate) {
            System.out.println("message : "+objectConstraintViolation.getMessage());
            System.out.println("constrain : "+objectConstraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("bean : "+objectConstraintViolation.getLeafBean());
            System.out.println("invalid value : "+objectConstraintViolation.getInvalidValue());
            System.out.println("path : "+objectConstraintViolation.getPropertyPath());

            Set<Class<? extends Payload>> payload = objectConstraintViolation.getConstraintDescriptor().getPayload();

            for (Class<? extends Payload> payLoadClass : payload) {
                if (payLoadClass == EmailErrorMessage.class){
                    EmailErrorMessage emailErrorMessage =new EmailErrorMessage();
                    emailErrorMessage.sendEmailError(objectConstraintViolation);
                }
            }
            System.out.println("====================");

        }


    }
}
