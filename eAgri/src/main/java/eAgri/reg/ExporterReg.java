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

@WebServlet("/ExporterReg")
public class ExporterReg extends HttpServlet 
{
 static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		    PrintWriter out=response.getWriter();
		    String name=request.getParameter("cname"); 
			String password=request.getParameter("password");
			String email=request.getParameter("email"); 
			DAO dao=new DAO();
			if(dao.doExporterRegister(name, password, email))
			{
				 response.sendRedirect("ExporterRegister.jsp?msg=RegistrationSuccessfull");
			}else 
			{
				response.sendRedirect("ExporterRegister.jsp?msg=RegistrationFailed");
			}
	}
	
}
