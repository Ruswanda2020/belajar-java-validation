package progremmerbeginner.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import progremmerbeginner.Enum.CaseMode;

public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseMode=constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (caseMode == null) return true; //skip validation if value is null

        if (caseMode == CaseMode.Uppercase){
            return value.equals(value.toUpperCase());
        } else if (caseMode == CaseMode.Lowercase) {
            return value.equals(value.toLowerCase());
        }
        return false;
    }
}
