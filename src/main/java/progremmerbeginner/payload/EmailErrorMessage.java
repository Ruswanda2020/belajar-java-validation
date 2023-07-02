package progremmerbeginner.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorMessage implements Payload {

    public void sendEmailError(ConstraintViolation<?> violation){
        System.out.println("send email error because : invalid credit number ");
    }
}
