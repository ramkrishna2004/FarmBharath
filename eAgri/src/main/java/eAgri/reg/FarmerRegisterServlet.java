package eAgri.reg;
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;

@WebServlet("/FarmerRegisterServlet")
public class FarmerRegisterServlet extends HttpServlet 
{
 static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		    PrintWriter out=response.getWriter();
		    String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String pincode=request.getParameter("pincode");
			DAO dao=new DAO();
			if(dao.doRegister(name,phone, password,city,state,pincode))
			{
				 response.sendRedirect("successfull.jsp");
			}else 
			{
				response.sendRedirect("FarmerRegister.jsp?msg=RegistrationFailed");
			}
	}
	
}
