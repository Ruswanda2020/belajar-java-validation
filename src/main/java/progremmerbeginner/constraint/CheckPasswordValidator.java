package progremmerbeginner.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import progremmerbeginner.validation.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext constraintValidatorContext) {
        if (value.getPassword() == null || value.getRetypePassword() == null){
            return true;//skip validate
        }
        boolean isValid=value.getPassword().equals(value.getRetypePassword());

        if (!isValid){

            constraintValidatorContext.disableDefaultConstraintViolation();

            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password").addConstraintViolation();

            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword").addConstraintViolation();
        }

        return isValid;
    }
}
