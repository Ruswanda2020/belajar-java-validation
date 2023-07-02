package progremmerbeginner.validation;

import jakarta.validation.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory=Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.getValidator();

    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidNested() {
        Person person=new Person();
        person.setFirstName("Rus");
        person.setLastName("wanda");

        Address address=new Address();
        person.setAddress(address);

        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        for (ConstraintViolation<Person> violation : validate) {
            System.out.println("message :"+violation.getMessage());
            System.out.println("path : "+violation.getPropertyPath());
            System.out.println("===================");
        }
    }
}
