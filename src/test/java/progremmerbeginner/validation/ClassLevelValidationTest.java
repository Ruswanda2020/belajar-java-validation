package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest{
    @Test
    void testClassLevel() {

        Register register=new Register();
        register.setUserName("");
        register.setPassword("salha");
        register.setRetypePassword("siih");

        validate(register);
    }
}
