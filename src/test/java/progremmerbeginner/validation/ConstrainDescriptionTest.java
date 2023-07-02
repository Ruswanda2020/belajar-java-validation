package progremmerbeginner.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstrainDescriptionTest extends AbstractValidatorTest {
    @Test
    void testConstrainDescription() {

        Person person=new Person();

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        for (ConstraintViolation<Person> personConstraintViolation : validate) {
            ConstraintDescriptor<?> constraintDescriptor = personConstraintViolation.getConstraintDescriptor();
            System.out.println(constraintDescriptor.getAnnotation());
            System.out.println(constraintDescriptor.getAttributes());
            System.out.println(constraintDescriptor.getPayload());
            System.out.println(constraintDescriptor.getMessageTemplate());

        }
    }
}
