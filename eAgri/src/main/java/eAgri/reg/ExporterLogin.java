package eAgri.reg;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.DAO;
@WebServlet("/ExporterLogin")
public class ExporterLogin extends HttpServlet 
{   
	 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		String mail=request.getParameter("email");
		String password=request.getParameter("password");
		
		HttpSession session= request.getSession(); 
		DAO dao=new DAO();
		String companyname=dao.ExporterloginCheck(mail, password);
		
		if (companyname!=null) 
		{
			session.setAttribute("name",companyname); 
			response.sendRedirect("ExporterIndex.jsp");
		}
		else {
				response.sendRedirect("ExporterLogin.jsp?msg=InvalidUseridOrPassword");
			}
		}
	    
	}


