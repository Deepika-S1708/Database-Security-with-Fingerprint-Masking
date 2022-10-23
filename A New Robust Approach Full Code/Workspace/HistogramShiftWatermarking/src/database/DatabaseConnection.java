package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseConnection implements ServletContextListener {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			System.out.println("Connection Closed Success----for--HistogramShiftWatermarking-------");
			deleterecords();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {

		ServletContext servletContext = arg0.getServletContext();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hsw","root","root");
			servletContext.setAttribute("connection", connection);
			System.out.println("Connection Create Success----for--HistogramShiftWatermarking-------------------");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleterecords()
	{
		try
		{
			System.out.println("================Records deleted for HistogramShift Watermarking===========");
			preparedStatement=connection.prepareStatement("delete from infotechdb");	
			preparedStatement.execute();
			
			preparedStatement=connection.prepareStatement("delete from binarydb");	
			preparedStatement.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
