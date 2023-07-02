package progremmerbeginner.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest{
    @Test
    void testSayHallo() throws NoSuchMethodException {

        Person person=new Person();
        String name="wanda";

        Method method=Person.class.getMethod("sayHallo", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.
                validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("message: "+violation.getMessage());
            System.out.println("path : "+violation.getPropertyPath());
            System.out.println("=========================");
        }
    }
    @Test
    void testGetFullName() throws NoSuchMethodException {

        Person person=new Person();
        person.setFirstName("wanda");
        person.setLastName("ganteng");

        String returnValue=person.fullName();

        Method method=Person.class.getMethod("fullName");

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.
                validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> violation : constraintViolations) {
            System.out.println("message: "+violation.getMessage());
            System.out.println("path : "+violation.getPropertyPath());
            System.out.println("=========================");
        }
    }
}
