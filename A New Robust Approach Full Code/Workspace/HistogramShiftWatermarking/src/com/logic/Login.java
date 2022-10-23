package com.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import database.DatabaseStatement;

public class Login extends HttpServlet
{
	String checkingstatus="";
	int count=0;
	Connection connection ;
	private static final long serialVersionUID = 1L;
	DatabaseStatement databaseStatement = new DatabaseStatement();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			connection = (Connection) getServletContext().getAttribute("connection");
		
			PreparedStatement preparedStatement = connection.prepareStatement(databaseStatement.checkUserName());
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
						request.setAttribute("status", username);
						RequestDispatcher rd = request.getRequestDispatcher("registersuccess.jsp");
				        rd.forward(request, response);
			}
			else{
				request.setAttribute("status", "USENAME NOT IN DATABASE");
				RequestDispatcher rd = request
				.getRequestDispatcher("userlogin.jsp");
		        rd.forward(request, response);
				//System.out.println("---Invalid Username and Password---");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
