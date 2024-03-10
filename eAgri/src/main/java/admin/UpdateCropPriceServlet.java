package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import admin.CropPrice;

@WebServlet("/InsertCropPriceServlet")
public class UpdateCropPriceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cropName = request.getParameter("cropName");
        double basePrice = Double.parseDouble(request.getParameter("basePrice"));
        CropPrice cropPrice = new CropPrice();
        cropPrice.setCropName(cropName);
        cropPrice.setBasePrice(basePrice); 
        DAO cropPriceDAO = new DAO();
        boolean success = cropPriceDAO.updateCropPrice(cropPrice);
        if (success) {
            response.sendRedirect("UpdateBasePrices.jsp?msg=PriceUpdated");
        } else {
            response.sendRedirect("UpdateBasePrices.jsp?msg=UpdateFailed");
        }
    }
}
