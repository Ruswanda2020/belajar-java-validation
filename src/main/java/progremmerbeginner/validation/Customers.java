package progremmerbeginner.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customers {

    @NotBlank(message = "name can not blank")
    private String name;

    @NotBlank(message = "email can not blank")
    @Email(message = "email must valid format")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
