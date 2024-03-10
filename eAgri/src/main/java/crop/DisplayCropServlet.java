package crop;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
 
@WebServlet("/DisplayCropsServlet")
public class DisplayCropServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedCrop = request.getParameter("selectedCrop");
        String pincode = request.getParameter("pincode");
        
        // Create an instance of the CropDAO class
        DAO cropDAO = new DAO();

        try {
            // Get crops based on filters
            List<Crop> crops = cropDAO.getAllCrops(selectedCrop, pincode);

            // Set the retrieved crop data in a request attribute
            request.setAttribute("crops", crops);

            // Forward the request to a JSP page for displaying the data
            request.getRequestDispatcher("DisplayCrops.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database-related exceptions here and provide user-friendly error messages
            e.printStackTrace(); // Log the exception
            request.setAttribute("errorMessage", "An error occurred while fetching crop data.");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }
}
