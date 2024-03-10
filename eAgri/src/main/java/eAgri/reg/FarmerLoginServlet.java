package eAgri.reg;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.DAO;
@WebServlet("/FarmerLoginServlet")
public class FarmerLoginServlet extends HttpServlet 
{   
	 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		HttpSession session= request.getSession(); 
		
		DAO dao=new DAO();
		String name=dao.loginCheck(phone, password); 
		if (name!=null) 
		{
			session.setAttribute("name",name); 
			response.sendRedirect("FarmerIndex.jsp");
		}
		else {
				response.sendRedirect("FarmerLogin.jsp?msg=InvalidUseridOrPassword");
			}
		}
	    
	}


