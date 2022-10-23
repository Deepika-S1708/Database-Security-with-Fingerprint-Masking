package com.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseStatement;

public class Updatefingerprint extends HttpServlet {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	DatabaseStatement databaseStatement = new DatabaseStatement();
	public Updatefingerprint() {
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
		PrintWriter out = response.getWriter();
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		String fingerprint=request.getParameter("txttemplate");
		try{
			connection = (Connection) getServletContext().getAttribute(
			"connection");
		String status="";
			if(!"".equals(fingerprint))
			{
				    preparedStatement = connection.prepareStatement(databaseStatement.updatefingerprint());
					preparedStatement.setString(1, fingerprint);
					preparedStatement.setString(2, username);
					preparedStatement.setString(3, userid);
					preparedStatement.executeUpdate();
					status="AUTHORISED USER";
					request.setAttribute("status", status);
					RequestDispatcher rd = request.getRequestDispatcher("AdminSucess.jsp");
					rd.forward(request, response);
	
			}else
			{
				request.setAttribute("username", username);
				request.setAttribute("userid", userid);
			    status = "Finger Print Missing..!";
				request.setAttribute("status", status);
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
