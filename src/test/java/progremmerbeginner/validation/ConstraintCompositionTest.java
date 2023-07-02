package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.group.VirtualAccountPaymentGroup;

import java.util.Locale;

public class ConstraintCompositionTest extends AbstractValidatorTest{
    @Test
    void testCompositionConstraint() {

        Locale.setDefault(new Locale("in","ID"));

        Payment payment=new Payment();
        payment.setOrderId("");
        payment.setAmount(2l);
        payment.setCreditCard("23");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
