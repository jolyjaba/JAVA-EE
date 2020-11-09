import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginForm form = new LoginForm();
        form.setEmail(email);
        form.setPassword(password);

        User user;

        if (form.hasError()) {
            req.setAttribute("userNotExist", form.getUserNotExist());
            req.setAttribute("inCorrectPassword", form.getInCorrectPassword());

            user = new User(email, password, "", "");
            req.setAttribute("user", user);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            user = UserDAO.selectOne(new User(email, password, "", ""));
            session.setAttribute("user", user);

            User getUser = (User) session.getAttribute("user");
            System.out.println(getUser.getEmail() + ", " + getUser.getPassword());
            req.setAttribute("user", user);
            // req.getRequestDispatcher("/visitorsPage.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/visitorsPage.jsp");
        }
    }
}
