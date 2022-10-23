package com.logic;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseStatement;

import java.io.FileOutputStream;

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName = "";
	String userImage = "";
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	DatabaseStatement databaseStatement = new DatabaseStatement();
    BufferedImage  writeimage;
	public register() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("unused")
		String status = "";
		userName = request.getParameter("username");
		String userEmail = request.getParameter("mailid");
		String userAddress = request.getParameter("address");
		String userBirth = request.getParameter("hometown");
		String password = request.getParameter("password");
		Random ran=new Random();
		String userid=""+ran.nextInt(999999);
		try {
			connection = (Connection) getServletContext().getAttribute(
			"connection");
	     System.out.println("this is connection--" + connection);
	     preparedStatement = connection.prepareStatement(databaseStatement.checkUserName());
	     System.out.println("check username working");
	     preparedStatement.setString(1, userName);
	     preparedStatement.setString(2, password);
	      ResultSet resultSet = preparedStatement.executeQuery();
	      boolean b = resultSet.next();
			if (!b) {
				 Statement stmt = connection.createStatement();
				   String sql =("insert into ADMINGRAPHICALPASSWORD values('" + userName + "','" + userEmail + "','" + userAddress + "','"+userBirth+"','"+userImage+"')");
				   stmt.executeUpdate(sql);
	                  
				preparedStatement = connection
						.prepareStatement(databaseStatement.insertUser());
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userEmail);
				preparedStatement.setString(3, userAddress);
		
				preparedStatement.setString(4, userBirth);
				preparedStatement.setString(5, password);
				preparedStatement.setString(6, userid);
				preparedStatement.execute();

				request.setAttribute("status", status);
				
				request.setAttribute("username", userName);
				request.setAttribute("userid", userid);
				RequestDispatcher rd = request.getRequestDispatcher("fingerprint.jsp");
				/*RequestDispatcher rd = request.getRequestDispatcher("userlogin.jsp");*/
				rd.forward(request, response);

			} else {
				status = "UserName or Email Already Exits";
				request.setAttribute("status", status);
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void imagewriting() throws IOException {
		CannyEdgeDetector detector = new CannyEdgeDetector();
		System.out.println("image path is " + userImage);
		String imagepath = userImage.replace("/", "\\");
		File ff = new File("webapps\\ReversibleWatermarking\\" + imagepath);
		BufferedImage stegnobuf = ImageIO.read(ff);
		System.out.println("reading process completed");
		detector.setSourceImage(stegnobuf);
        detector.process();
		BufferedImage edges = detector.getEdgesImage();
		
		
		File ff1 = new File("webapps/ReversibleWatermarking/" + userName);
		if (!ff1.exists()) {
			ff1.mkdir();
		}
		File ff2=new File("webapps/ReversibleWatermarking/" + userName+"/edgeimage.jpg");
	//	File ff3=new File("webapps/GraphicalPassword/" + userName+"/edgeimage1.jpg");
	    FileOutputStream ff3 = new FileOutputStream("webapps/ReversibleWatermarking/" + userName+"/edgeimage1.jpg");
		ImageIO.write(edges, "JPG", ff2);
		BufferedImage edgebuf = ImageIO.read((ff2));
		writeimage = new BufferedImage(edgebuf.getWidth(), edgebuf.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		  for (int i = 0; i < edgebuf.getWidth(); i++) {
              for (int j = 0; j < edgebuf.getHeight(); j++) {
                    int pixel = edgebuf.getRGB(i, j);
                    writeimage.setRGB(i, j, pixel);
              }}
		  ByteArrayOutputStream bas = new ByteArrayOutputStream();
		  ImageIO.write(writeimage, "JPG", ff3);
		  ff3.write(bas.toByteArray());
          bas.close();
          ff3.close();
		  System.out.println("image write successfully");

	}
}
