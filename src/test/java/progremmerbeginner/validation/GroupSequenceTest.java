package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest {
    @Test
    void testGroupSequenceTest() {

        Payment payment =new Payment();
        payment.setOrderId("011");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setVirtualAccount("VA123456789");

        validateWithGroups(payment,PaymentGroup.class);
    }
}
