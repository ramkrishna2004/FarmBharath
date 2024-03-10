package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
/**
 * Servlet implementation class UpdateBasePrices
 */
@WebServlet("/InsertBasePrices")
public class InsertBasePrices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
			String name=request.getParameter("name");
			String price=request.getParameter("price");
			if (name!=null) {
				name=name.toLowerCase();
			}
			DAO dao=new DAO();
			if(dao.insertPrices(name,price)) {
				response.sendRedirect("AdminCropBasePrice.jsp?msg=Insertion_Succesfull");
			}
			else {
				response.sendRedirect("AdminCropBasePrice.jsp?msg=Insertion_Failed");
			}
			
			
	}

}
