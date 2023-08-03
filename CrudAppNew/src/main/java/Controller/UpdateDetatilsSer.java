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
 * Servlet implementation class UpdateDetatilsSer
 */
@WebServlet("/UpdateDetatilsSer")
public class UpdateDetatilsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetatilsSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		out.print("<center>");
		out.println("<h1>Update Employee</h1>");
		
		String sid=request.getParameter("id");
		
		int id=Integer.parseInt(sid);
		
		AddEmpDetails e= MainDao.getEmployeeById(id);
		
		
		out.print("<form action='UpdateDetails2' method='doGet'>");
		
		out.print("<table>");
		
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
		
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
		
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'> </td></tr>");
		
		
	   out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"  +e.getEmail()  +"'> </td></tr>");
		
	   out.print("<tr><td>Address:</td><td><input type='text' name='address' value='" +e.getAddress()+"'></td></tr>");
	 
		
	   
	   
	   out.print("<tr><td>City:</td><td>");
	   
	   out.print("<select name='city' style='width:150px'>");
	  
	   out.print("<option>option</option>");
	   
	   out.print("<option>Mumbai</option>");
	   out.print("<option>Pune</option >");
	   out.print("<option>Nagpur</option>");
	   out.print("<option>Bhopal</option>" ) ;
	   
	   out.print("<option>Other </option> ");
	   out.print("</select>");
	   
	   out.print("</td></tr>");
	   out.print("<tr><td>Country:</td><td>");
	   
	   out.print("<select name='country' style='width:150px'>");
	   
	   
	   out.print("<option>option</option>");
	  
	   
	   out.print("<option>India</option>");
	   out.print("<option>USA</option >");
	   out.print("<option>SA</option>"); 
	   out.print("<br><br>");
	   out.print("</select>");
	  
	   out.print("</td></tr>");
	   
	   out.print("<tr><td><input type='submit' value='Edit & Save'></td></tr>");
	  
	   out.print("</form>");
	   out.print("</center>");

	}
}

	

