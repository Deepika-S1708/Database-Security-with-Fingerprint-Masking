package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class viewrecords1 extends HttpServlet {
 	Connection connection ;
 	Statement stmt ;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String userid=request.getParameter("userid");
		try{
			

        	connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 System.out.println("connection exe");
        	Vector list = new Vector();
        	String sql="select * from infotechdb";
        	 ResultSet rs =  stmt.executeQuery(sql);
        	 ResultSetMetaData rm = rs.getMetaData();
        	 Vector metatemp = new Vector();
             int count = rm.getColumnCount();
           
            
             Vector temp;
             while(rs.next())
             {
            	 temp = new Vector();
                 for(int i = 1; i <= count; i++){
                     temp.add(rs.getString(i));
                 }
                 list.add(temp);
             }
            // out.println("metatemp count is "+metatemp);
             //out.println("list count is "+list.get(0));
             request.setAttribute("PARTITION", "ORIGINAL RECORDS");
             request.setAttribute("list", list);
             RequestDispatcher rd = request.getRequestDispatcher("viewencoded.jsp");
		        rd.forward(request, response);
             }
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
