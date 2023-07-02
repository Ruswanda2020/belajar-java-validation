package progremmerbeginner.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import progremmerbeginner.sevice.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest{
    @Test
    void testCrossParameter() throws NoSuchMethodException {

        UserService userService=new UserService();
        Method method=UserService.class.getMethod("register", String.class, String.class, String.class);

        String userName="wanda";
        String password="rahasia";
        String retypePamareter="rahasia";

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, method, new Object[]{
                userName, password, retypePamareter
        });


        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
        }

    }
}
