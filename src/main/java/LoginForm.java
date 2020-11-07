import java.io.Serializable;

public class LoginForm implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String email = "";
    private String password = "";

    private String inCorrectPassword = "";
    private String userNotExist = "";

    private boolean errorMatched = false;

    public boolean hasError() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        if (user.getEmail().isEmpty()) {
            errorMatched = true;
            userNotExist = "Enter email!";
        } else {
            if (!UserDAO.containsUserEmail(user)) {
                errorMatched = true;
                userNotExist = "User not exists! Register your account!";
            } else {
                if (user.getPassword().isEmpty()) {
                    errorMatched = true;
                    inCorrectPassword = "Enter password!";
                } else {
                    if (!UserDAO.containsUser(user)) {
                        errorMatched = true;
                        inCorrectPassword = "Incorrect email or password!";
                    }
                }
            }
        }
        return errorMatched;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNotExist() {
        return userNotExist;
    }

    public String getInCorrectPassword() {
        return inCorrectPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
