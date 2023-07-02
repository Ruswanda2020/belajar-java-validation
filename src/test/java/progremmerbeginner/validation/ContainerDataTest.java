package progremmerbeginner.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {
    @Test
    void testContainerData() {

        Person person=new Person();
        person.setFirstName("wanda");
        person.setLastName("wanda");
        person.setAddress(new Address());
        person.getAddress().setCity("tangeran");
        person.getAddress().setCountry("indo");
        person.getAddress().setStreet("lalaaaa");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("wandi");
        person.getHobbies().add("wanda");

        validate(person);
    }
}
