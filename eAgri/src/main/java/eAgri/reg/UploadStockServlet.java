package eAgri.reg;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

@WebServlet("/UploadStockServlet")
public class UploadStockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String phone = request.getParameter("phone");
        String cropName = request.getParameter("cropName");
        String cropQuantityStr = request.getParameter("cropQuantity"); 
        String pincode =request.getParameter("pincode");
        String state=request.getParameter("state");
        if (cropName != null) {
            cropName = cropName.toLowerCase();
        }

        // Convert crop quantity to a numeric value (you can add validation)
        double cropQuantity = Double.parseDouble(cropQuantityStr);

        // Process the uploaded stock information (you can save it to a database)
        // Here, we are printing the information to the console for demonstration
        System.out.println("Phone: " + phone);
        System.out.println("Crop Name: " + cropName);
        System.out.println("Crop Quantity: " + cropQuantity + " kg"); 

        DAO dao=new DAO();
		if(dao.doUpload(phone,cropName,cropQuantityStr,pincode,state))
		{
			 response.sendRedirect("StockUploadSuccessfull.jsp");
		}else 
		{
			response.sendRedirect("FarmerUploadStock.jsp?msg=RegistrationFailed");
		}
    }
}
