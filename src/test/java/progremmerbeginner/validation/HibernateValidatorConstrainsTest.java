package progremmerbeginner.validation;
import org.junit.jupiter.api.Test;

public class HibernateValidatorConstrainsTest extends AbstractValidatorTest {


    @Test
    void testHibernateConstrainInvalid() {

        Payment payment=new Payment();
        payment.setAmount(10000L);
        payment.setCreditCard("234");
        
        validate(payment);
    }

    @Test
    void testHibernateConstrainValid() {

        Payment payment=new Payment();
        payment.setOrderId("1234");
        payment.setAmount(100000L);
        payment.setCreditCard("4111111111111111");

        validate(payment);
    }

}
