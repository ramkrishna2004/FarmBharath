package admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
@WebServlet("/DisplayCropPrices")
public class DisplayCropsPrices extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        // Create an instance of the DAO class
         DAO cropPriceDAO = new  DAO(/* Initialize your database connection */);

        // Retrieve crop prices based on the selected crop name
        List<CropPrice> cropPrices = cropPriceDAO.getAllCropPrices();

        // Store the retrieved data in a request attribute
        request.setAttribute("cropPrices", cropPrices);

        // Forward the request to the JSP for displaying the data
        request.getRequestDispatcher("DisplayPrices.jsp").forward(request, response);
    }
}
