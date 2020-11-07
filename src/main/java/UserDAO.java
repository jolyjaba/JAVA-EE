import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * UserDAO
 */
public class UserDAO implements Connector {
    public static int insert(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO users (user_first, user_last, user_email, user_password) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

                    preparedStatement.setString(1, user.getFirstName());
                    preparedStatement.setString(2, user.getLastName());
                    preparedStatement.setString(3, user.getEmail());
                    preparedStatement.setString(4, user.getPassword());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static boolean containsUserEmail(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM users WHERE user_email = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getEmail());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static boolean containsUser(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM users WHERE user_password = ? AND user_email = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getPassword());
                    preparedStatement.setString(2, user.getEmail());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
}