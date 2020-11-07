import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegistrationForm
 */
public class RegistrationForm implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String email = "";
    private String password = "";
    private String confirmPassword = "";
    private String firstName = "";
    private String lastName = "";
    private boolean errorMatched = false;

    private String notValidEmail = "";
    private String notValidPassword = "";
    private String notMatchConfirm = "";
    private String notValidFirst = "";
    private String notValidLast = "";

    public boolean hasError() {
        if (email.isEmpty()) {
            errorMatched = true;
            notValidEmail = "Email required!";
        } else {
            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                errorMatched = true;
                notValidEmail = "Not valid Email!";
            }
            User user = new User();
            user.setEmail(email);
            if (UserDAO.containsUserEmail(user)) {
                errorMatched = true;
                notValidEmail = "User already registered!";
                return errorMatched;
            }
        }
        if (password.isEmpty()) {
            errorMatched = true;
            notValidPassword = "Password required!";
        } else {
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                errorMatched = true;
                notValidPassword = "Not valid password!";
            }
        }
        if (confirmPassword.isEmpty()) {
            errorMatched = true;
            notMatchConfirm = "Repeat password!";
        } else {
            if (!confirmPassword.equals(password)) {
                errorMatched = true;
                notMatchConfirm = "Not same password!";
            }
        }
        if (firstName.isEmpty()) {
            errorMatched = true;
            notValidFirst = "First Name required!";
        }
        if (lastName.isEmpty()) {
            errorMatched = true;
            notValidLast = "Last Name required!";
        }
        return errorMatched;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNotValidEmail() {
        return notValidEmail;
    }

    public String getNotValidPassword() {
        return notValidPassword;
    }

    public String getNotMatchConfirm() {
        return notMatchConfirm;
    }

    public String getNotValidFirst() {
        return notValidFirst;
    }

    public String getNotValidLast() {
        return notValidLast;
    }
}