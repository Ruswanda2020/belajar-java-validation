package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;
import progremmerbeginner.group.CreditCardPaymentGroup;

import java.util.Locale;

public class MessageInternationalizationTest extends AbstractValidatorTest{
    @Test
    void testI18n() {
        Locale.setDefault(new Locale("in","ID"));

        Payment payment=new Payment();
        payment.setOrderId("12122222222222");
        payment.setAmount(2l);
        payment.setCreditCard("23");

        validateWithGroups(payment, CreditCardPaymentGroup.class);

    }
}
