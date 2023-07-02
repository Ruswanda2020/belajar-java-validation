package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.group.PaymentGroup;
import progremmerbeginner.group.VirtualAccountPaymentGroup;

public class GroupConvertTest extends AbstractValidatorTest{
    @Test
    void testGroupConvert() {

        Payment payment =new Payment();
        payment.setOrderId("011");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setVirtualAccount("VA123456789");
        payment.setCustomers(new Customers());

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);

    }
}
