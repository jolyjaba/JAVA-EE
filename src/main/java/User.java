import java.io.Serializable;

public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public User() {
        this.email = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}
