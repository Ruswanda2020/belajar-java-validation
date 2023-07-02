package progremmerbeginner.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    private List<@NotBlank(message = "hobbies can not blank") String> hobbies;
    @NotBlank(message = "firts name can not blank")
    @Size(max = 20 ,message = "firts name length max must 20 caractere")
    private String firstName;

    @NotBlank(message = "last name not blank")
    @Size(max = 20 ,message = "last name length must 20 caractere")
    private String lastName;

    @Valid
    @NotNull(message = "address can not null")
    private Address address;

    @Valid
    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Valid
    public Person(@NotBlank (message = "first name can not blank") String firstName,
                  @NotBlank (message = "last name can not blank")String lastName,
                  @NotNull(message = "address can not null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHallo(@NotBlank(message = "name must not blank") String name){
        System.out.println("hallo "+name+" my name is "+firstName);
    }

    @NotBlank(message = "full name can not blank")
    public String fullName(){

        return firstName +" "+lastName;
    }
}
