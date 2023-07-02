package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;
import progremmerbeginner.group.VirtualAccountPaymentGroup;

public class GroupsConstrainsTest extends AbstractValidatorTest {

    @Test
    void testInvalidCreditCardNumber() {

        Payment payment=new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("2323");

        validateWithGroups(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testInvalidVirtualAccountNumber() {

        Payment payment=new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("2323");
        payment.setVirtualAccount("");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);

    }

    @Test
    void testValidCreditCardNumber() {

        Payment payment=new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setVirtualAccount("VA123456789");

        validateWithGroups(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testValidVirtualAccountNumber() {

        Payment payment=new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("2323");
        payment.setVirtualAccount("VA123456789");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);

    }
}
