package progremmerbeginner.validation;

import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;
import progremmerbeginner.group.VirtualAccountPaymentGroup;

public class MessageInterpolationsTest extends AbstractValidatorTest{
    @Test
    void testMessageInterpolations() {
        Payment payment=new Payment();
        payment.setOrderId("1");
        payment.setAmount(1l);
        payment.setVirtualAccount("333");

        Customers customers=new Customers();
        customers.setName("wanda");
        customers.setEmail("wanda@gmail.com");

        payment.setCustomers(customers);



        validateWithGroups(payment,VirtualAccountPaymentGroup.class);
    }
}
