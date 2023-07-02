package progremmerbeginner.sevice;

import jakarta.validation.constraints.NotBlank;
import progremmerbeginner.constraint.CheckPasswordParameter;



public class UserService {
    @CheckPasswordParameter(passwordParam = 1,retypePasswordParam = 2)
    public void register(@NotBlank(message = "user name can not blank") String userName,
                         @NotBlank(message = "password can not blank") String password,
                         @NotBlank(message = "retype can not blank") String retypePassword){
        //todo Register
    }
}
