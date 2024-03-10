package admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

		HttpSession session= request.getSession();
        // Create an instance of the AdminDAO class
        DAO adminDAO = new DAO();

        // Check if the provided credentials are valid
        String name = adminDAO.validateAdmin(username, password);

        if (name!=null) {
            // Redirect to the admin panel upon successful login

			session.setAttribute("name",name); 
            response.sendRedirect("AdminPanel.jsp");
        } else {
            // Display an error message and redirect back to the login page 
            response.sendRedirect("AdminPannelLogin.jsp?msg=Invalid UsernameOrPassword");
        }
    }
}
