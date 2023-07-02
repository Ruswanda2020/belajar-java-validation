package progremmerbeginner.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import progremmerbeginner.extractor.DataValueExtractor;
import progremmerbeginner.extractor.EntryValueExtractorKey;
import progremmerbeginner.extractor.EntryValueExtractorValue;

import java.util.Set;

public class AbstractValidatorTest {
    protected ValidatorFactory validatorFactory;
    protected Validator validator;

    protected ExecutableValidator executableValidator;

    @BeforeEach
    void setUp() {
        //validatorFactory= Validation.buildDefaultValidatorFactory();
        validatorFactory=Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue()).buildValidatorFactory();
        validator=validatorFactory.getValidator();
        executableValidator=validator.forExecutables();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }
    void validate(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        for (ConstraintViolation<Object> objectConstraintViolation : validate) {
            System.out.println("message : "+objectConstraintViolation.getMessage());
            System.out.println("constrain : "+objectConstraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("bean : "+objectConstraintViolation.getLeafBean());
            System.out.println("invalid value : "+objectConstraintViolation.getInvalidValue());
            System.out.println("path : "+objectConstraintViolation.getPropertyPath());
            System.out.println("==================================");
        }
    }

    void validateWithException(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        if (!validate.isEmpty()){
            throw new ConstraintViolationException(validate);
        }
    }
    void validateWithGroups(Object object,Class<?>... groups){
        Set<ConstraintViolation<Object>> validate = validator.validate(object,groups);
        for (ConstraintViolation<Object> objectConstraintViolation : validate) {
            System.out.println("message : "+objectConstraintViolation.getMessage());
            System.out.println("constrain : "+objectConstraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("bean : "+objectConstraintViolation.getLeafBean());
            System.out.println("invalid value : "+objectConstraintViolation.getInvalidValue());
            System.out.println("path : "+objectConstraintViolation.getPropertyPath());
            System.out.println("==================================");
        }
    }

}
