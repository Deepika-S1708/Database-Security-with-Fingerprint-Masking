package user;

import java.io.IOException;
import database.DatabaseStatement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class complaint extends HttpServlet {
	Connection connection = null;
	String username,emailid,address,hometownadmin,imagename;
	PreparedStatement preparedStatement = null;
	DatabaseStatement databaseStatement = new DatabaseStatement();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		
		String userName = request.getParameter("username");
		String hometown = request.getParameter("hometown");
		System.out.println("username is -----------> "+userName);
		System.out.println("hometown is -----------> "+hometown);
		
		
		
		
		try{
		connection = (Connection) getServletContext().getAttribute(
		"connection");
		 
            
		   preparedStatement = connection.prepareStatement(databaseStatement.checkUserName());
		     System.out.println("check username working");
		     preparedStatement.setString(1, userName);
		      ResultSet resultSet = preparedStatement.executeQuery();
		boolean b = resultSet.next();
		if (b) {
			String result="ACCOUNT IS ALREADY ACTIVE NO NEED FOR RECOVERY";
			System.out.println("result is--------->"+result);
			request.setAttribute("status",result);
			RequestDispatcher rd1 = request
			.getRequestDispatcher("complaint.jsp");
	        rd1.forward(request, response);
			
		
		}
		
		else{
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM admingraphicalpassword  where USERNAME='"+userName+"'");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		 username=rs.getString(1);
		 emailid=rs.getString(2);
		 address=rs.getString(3);
		 hometownadmin=rs.getString(4);
		 imagename=rs.getString(5);
		
		}
		System.out.println("hometown--------"+hometownadmin);
		if(hometown.equalsIgnoreCase(hometownadmin))
		{
			System.out.println("security question correct");
			PreparedStatement ps1=connection.prepareStatement("insert into registration values('" + username + "','" + emailid + "','" + address + "','"+hometownadmin+"','"+imagename+"')");
			ps1.executeUpdate();
			System.out.println("your account has been unblocked");
			String result="ACCOUNT HAS BEEN RECOVRED";
			//ServletContext con1=getServletContext();
			request.setAttribute("status",result);
			RequestDispatcher rd1 = request
			.getRequestDispatcher("complaint.jsp");
	        rd1.forward(request, response);
		}
		else{
			
		System.out.println("your security question is mismath pls check");
		String result="SECURITY QUESTION IS MISMATCHING";
		//ServletContext con1=getServletContext();
		request.setAttribute("status",result);
		RequestDispatcher rd1 = request.getRequestDispatcher("complaint.jsp");
        rd1.forward(request, response);
		}
		}
		}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
