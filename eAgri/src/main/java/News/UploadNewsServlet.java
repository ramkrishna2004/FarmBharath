package News;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dao.DAO;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/UploadNewsServlet")
@MultipartConfig
public class UploadNewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        String datePublished = request.getParameter("date_published");
    
        String category = request.getParameter("category");
        
        // Handle uploaded image
        Part imagePart = request.getPart("image");
        
        // Check if the imagePart is null
        if (imagePart == null) {
            response.sendRedirect("UploadNews.jsp?msg=ImageMissing");
            return;
        }

        String sourceUrl = request.getParameter("source_url");

        // Create an instance of the DAO class
        DAO newsDAO = new DAO();

        // Insert news into the database and check if insertion was successful
        boolean insertionSuccessful = newsDAO.insertNews(id,title, content, author, datePublished, category, imagePart.getInputStream(), sourceUrl);

        if (insertionSuccessful) {
            response.sendRedirect("UploadNews.jsp?msg=UploadedSuccesfully");
        } else {
            response.sendRedirect("UploadNews.jsp?msg=UploadFailed");
        }
    }
}
