import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 8848302561903441692L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm__password");
        String firstName = req.getParameter("first__name");
        String lastName = req.getParameter("last__name");

        RegistrationForm form = new RegistrationForm();

        form.setEmail(email);
        form.setPassword(password);
        form.setConfirmPassword(confirmPassword);
        form.setFirstName(firstName);
        form.setLastName(lastName);

        if (form.hasError()) {
            req.setAttribute("notValidEmail", form.getNotValidEmail());
            req.setAttribute("notValidPassword", form.getNotValidPassword());
            req.setAttribute("notMatchConfirm", form.getNotMatchConfirm());
            req.setAttribute("notValidFirst", form.getNotValidFirst());
            req.setAttribute("notValidLast", form.getNotValidLast());

            req.setAttribute("mail", form.getEmail());
            req.setAttribute("pass", form.getPassword());
            req.setAttribute("confPass", form.getConfirmPassword());
            req.setAttribute("fN", form.getFirstName());
            req.setAttribute("lN", form.getLastName());

            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            UserDAO.insert(user);

            req.setAttribute("isLoggedIn", true);

            resp.sendRedirect(req.getContextPath() + "/visitorsPage.jsp");
        }
    }
}
