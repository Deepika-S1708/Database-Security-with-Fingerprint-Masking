package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class viewrecords extends HttpServlet {
	
	Connection connection ;
 	Statement stmt ;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

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
				for(int i = 1; i <= count; i++){
					if("RENTALEXPENSES".equals(rm.getColumnName(i)))
				     metatemp.add("RENTAL EXPENSES");
					else if("SALARYAMOUNT_PA".equals(rm.getColumnName(i)))
						metatemp.add("SALARY AMOUNT");
					else if("OTHER_EXPENSES_PA".equals(rm.getColumnName(i)))
						metatemp.add("OTHER EXPENSES");
					else if("ANNUALTURNOVER".equals(rm.getColumnName(i)))
						metatemp.add("ANNUAL TURNOVER");
					else
						metatemp.add(rm.getColumnName(i));
    
             }
             
             list.add(metatemp);
            
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
             request.setAttribute("PARTITION", "TUPLE HAS BEEN SEPARATED");
             request.setAttribute("list", list);
             RequestDispatcher rd = request.getRequestDispatcher("AdminSucess.jsp");
		        rd.forward(request, response);
             }
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
