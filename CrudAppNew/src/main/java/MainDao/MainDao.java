package MainDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import CrudBo.AddEmpDetails;


public class MainDao {

	
public static Connection getConnection1()  {
		
		Connection con=null;
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudapp", "root", "1234");
			
		} catch (Exception e) {

			
			System.out.println(e);
			
		}
		return con;
		
		
	}
	
	
	public static AddEmpDetails getEmployeeById(int id)  {
		
		
		
		
		
		AddEmpDetails e=new AddEmpDetails();
		
		try {
			
			Connection con=MainDao.getConnection1();
			PreparedStatement ps= con.prepareStatement("select *from  EmpDetailsTable where id=?");
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
			
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCity(rs.getString(6));
				e.setCountry(rs.getString(7));
				
				
			}
			
			
			con.close();
			
		}
		  catch(Exception ex) {ex.printStackTrace();}
		
		
		return e;
		
		
		
		}
			
	  public static List<AddEmpDetails> getAllEmployees(){
			
		  
		  List<AddEmpDetails> list = new  ArrayList<AddEmpDetails>();
			
		try {
			
			Connection con=MainDao.getConnection1();
			PreparedStatement ps= con.prepareStatement("select *from EmpDetailsTable");
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())  {
				
				AddEmpDetails e=new AddEmpDetails();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCity(rs.getString(6));
				
				e.setCountry(rs.getString(7));
				
				list.add(e);
				
			}
			
			
			con.close();
			
		} catch (Exception e) {e.printStackTrace();}
			
		
		return list;
		
			  
			  
		  }

	
public static int save(AddEmpDetails e)  {
	
	int status=0;
	
	try {
		
		Connection con=MainDao.getConnection1();
		
		PreparedStatement ps=con.prepareStatement("insert into EmpDetailsTable(name,password,email,address,city,country) values (?,?,?,?,?,?)");
		
		ps.setString(1, e.getName());
		ps.setNString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		
		ps.setString(4, e.getAddress());
		ps.setString(5, e.getCity());
		ps.setString(6, e.getCountry());
		
		status=ps.executeUpdate();
		
		con.close();
		
	}
	    catch(Exception ex)  { ex.printStackTrace();}			
			
	
	return status;
	
	
	
	
}


public static int update(AddEmpDetails e)  {
	
	
	
	int status=0;

try {
	Connection con= MainDao.getConnection1();
	
	PreparedStatement ps= con.prepareStatement("update EmpDetailsTable set name=?, password=?, email=?, address=?,city=?,country=? where  id=?");
	
	ps.setString(1, e.getName());
	ps.setString(2, e.getPassword());
	ps.setString(3, e.getEmail());
	
	
	
	ps.setString(4, e.getAddress());
	ps.setString(5, e.getCity());
	ps.setString(6, e.getCountry());
	
	ps.setInt(7, e.getId());
	
	status=ps.executeUpdate();
	
	con.close();
	


}  
 
  catch(Exception ex) { ex.printStackTrace();}

return status;

    }


public static int delete(int id)  {
	
	
	
	int status=0;
	
	try {
		
		Connection con=MainDao.getConnection1();
		
		PreparedStatement ps=con.prepareStatement("delete from EmpDetailsTable where id=?");
		
        
		ps.setInt(1, id);
		
		status=ps.executeUpdate();
		
		con.close();
		
	} catch (Exception e) {e.printStackTrace();}
		
	
	
	
	
	return status;
	
	
		
	}

}
	

