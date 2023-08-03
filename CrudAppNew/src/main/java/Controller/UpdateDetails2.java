package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CrudBo.AddEmpDetails;
import MainDao.MainDao;


/**
 * Servlet implementation class UpdateDetails2
 */
@WebServlet("/UpdateDetails2")
public class UpdateDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetails2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		
		int id=Integer.parseInt(sid);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email= request.getParameter("email");
		
		
		String address= request.getParameter("address");
		
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		
		AddEmpDetails e=  new AddEmpDetails();
		
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		
		e.setEmail(email);
		e.setAddress(address);
		e.setCity(city);
		
		e.setCountry(country);
		
		int status=MainDao.update(e);
		
		if(status>0)  {
			
			response.sendRedirect("ShowDetails");
			
		}  
		else  {
			
			out.print("Sorry  ! unable to update record");
			
		}
		
		
		out.close();
		
		
			
		}	
	
	
		
  



		
	}


