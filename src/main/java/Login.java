import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 8848302561903441692L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginForm form = new LoginForm();
        form.setEmail(email);
        form.setPassword(password);

        if (form.hasError()) {
            req.setAttribute("userNotExist", form.getUserNotExist());
            req.setAttribute("inCorrectPassword", form.getInCorrectPassword());

            User user = new User(email, password, "", "");
            req.setAttribute("user", user);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("isLoggedIn", true);
            resp.sendRedirect(req.getContextPath() + "/visitorsPage.jsp");
        }
    }
}
