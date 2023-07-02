package progremmerbeginner.validation;

import jakarta.validation.constraints.NotBlank;
import progremmerbeginner.constraint.CheckPassword;

@CheckPassword
public class Register {

    @NotBlank(message = "username can not blank")
    private String userName;

    @NotBlank(message = " password can not blank")
    private String password;

    @NotBlank(message = "retype password can not blank")
    private String retypePassword;

    @Override
    public String toString() {
        return "Register{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
