package com.logic;

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

import database.DatabaseStatement;

public class Managemodule extends HttpServlet {
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	DatabaseStatement databaseStatement = new DatabaseStatement();
	public Managemodule() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String module =request.getParameter("module");
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		try{
			connection = (Connection) getServletContext().getAttribute(
			"connection");
			if("module3".equalsIgnoreCase(module))
			{
				PreparedStatement preparedStatement = connection.prepareStatement(databaseStatement.checkUserid());
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, userid);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					String fp=(String)resultSet.getString("fingerprint");
					String fpt=(String)resultSet.getString("fingertemplate");
					if(fp!=null && fpt!=null){
						request.setAttribute("username", username);
						request.setAttribute("userid", userid);
						request.setAttribute("fingerprint", fp);
						request.setAttribute("fingertemplate", fpt);
						request.setAttribute("but", "CM");
						RequestDispatcher rd = request.getRequestDispatcher("fingerprint.jsp");
						rd.forward(request, response);
					}else
					{
						request.setAttribute("username", username);
						request.setAttribute("userid", userid);
						request.setAttribute("status", "Phase-I & II Pending..!");
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						rd.forward(request, response);	
					}
				}else
				{
					request.setAttribute("username", username);
					request.setAttribute("userid", userid);
					request.setAttribute("status", "Phase-I & II Pending..!");
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);	
				}
				
			}else
			{
				request.setAttribute("username", username);
				request.setAttribute("userid", userid);
				RequestDispatcher rd = request.getRequestDispatcher("AdminSucess.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
