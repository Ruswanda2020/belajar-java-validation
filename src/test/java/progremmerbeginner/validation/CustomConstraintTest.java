package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;

public class CustomConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustomConstraint() {

        Payment payment=new Payment();
        payment.setOrderId("dhjd");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
