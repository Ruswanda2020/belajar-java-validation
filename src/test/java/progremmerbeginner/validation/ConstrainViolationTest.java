package progremmerbeginner.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstrainViolationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory= Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFailed() {
        Person person=new Person();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2,violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("message : "+violation.getMessage());
            System.out.println("constrain : "+violation.getConstraintDescriptor().getAnnotation());
            System.out.println("bean : "+violation.getLeafBean());
            System.out.println("invalid value : "+violation.getInvalidValue());
            System.out.println("path : "+violation.getPropertyPath());
        }
    }
    @Test
    void testValidationFailedSize() {

        Person person=new Person("WANDA","WANDI");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);


        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("message : "+violation.getMessage());
            System.out.println("constrain : "+violation.getConstraintDescriptor().getAnnotation());
            System.out.println("bean : "+violation.getLeafBean());
            System.out.println("invalid value : "+violation.getInvalidValue());
            System.out.println("path : "+violation.getPropertyPath());
        }
    }
    @Test
    void testValidationSuccess() {

        Person person=new Person("Rus","wanda");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0,violations.size());

    }
}
