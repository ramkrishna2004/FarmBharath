package News;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

@WebServlet("/NewsRetrieveServlet")
public class NewsRetrieveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of the DAO class
        DAO dao = new DAO();

        // Call the DAO method to retrieve news data
        List<NewsItem> newsList = dao.retrieveNews();

        // Store the retrieved data in a request attribute
        request.setAttribute("newsList", newsList);

        // Forward the request to a JSP page for displaying the data
        request.getRequestDispatcher("DisplayNews.jsp").forward(request, response);
    }
}
