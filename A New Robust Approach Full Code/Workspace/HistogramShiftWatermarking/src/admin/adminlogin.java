package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseStatement;

public class adminlogin extends HttpServlet {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	DatabaseStatement databaseStatement = new DatabaseStatement();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String status = "";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try{
			connection = (Connection) getServletContext().getAttribute(
			"connection");
			if(!"".equalsIgnoreCase(username)&&!"".equalsIgnoreCase(password))
			{
				preparedStatement = connection.prepareStatement(databaseStatement.checkUserName());
			    System.out.println("check username working");
			    preparedStatement.setString(1, username);
			    preparedStatement.setString(2, password);
			    ResultSet resultSet = preparedStatement.executeQuery();
			    boolean b = resultSet.next();
			      if(b){
			    	  	HttpSession hs=request.getSession(true);
						hs.setAttribute("username", resultSet.getString("username"));
						hs.setAttribute("userid", resultSet.getString("userid"));
			    	    status="AUTHORISED USER";
						request.setAttribute("status", status);
						request.setAttribute("username", resultSet.getString("username"));
						request.setAttribute("userid", resultSet.getString("userid"));
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
/*						RequestDispatcher rd = request.getRequestDispatcher("AdminSucess.jsp");
*/						rd.forward(request, response); 
			      }else
			      {
			    	    status="Invalid User";
						request.setAttribute("status", status);
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
						
			      }
				
			}
			
			else
			{
				status="Invalid User";
				request.setAttribute("status", status);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
