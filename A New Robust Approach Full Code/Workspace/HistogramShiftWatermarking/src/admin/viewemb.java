package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class viewemb extends HttpServlet {
	Connection connection ;
 	Statement stmt ;
 	 Vector<String> randomvalue = new Vector<String>();
 	public String getRandomElement(Vector v) {
        Random generator = new Random();
        int rnd = generator.nextInt(v.size());
      //  System.out.println("rnd values is  "+rnd);
        return (String) v.get(rnd);
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
try{
	randomvalue.add("5.2");
	randomvalue.add("6.7");
	randomvalue.add("8.2");
	randomvalue.add("7.7");
	randomvalue.add("3.0");
	randomvalue.add("2.2");
			
        	 connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 System.out.println("connection exe");
        	Vector list = new Vector();
        	String sql="select * from binarydb";
        	 ResultSet rs =  stmt.executeQuery(sql);
             Vector tempp;
             while(rs.next())
             {
            	 tempp = new Vector();
                 for(int i = 1; i <= 13; i++){
                //   tempp.add(rs.getString(i));
                	 if(i<=8){
                		
                		 int decimal = Integer.parseInt(rs.getString(i), 2);
                		 //System.out.println("decimal value is "+decimal+" i value is "+i);
                		 tempp.add(decimal);
                		 }
                	 
                	 else{
                		
					long b = Long.parseLong(rs.getString(i), 2);
					int intBits5 = (int) b;
					float decodefloat = Float.intBitsToFloat(intBits5);
					
					// System.out.println("decodefloat value is "+decodefloat+" i value is "+i);
					String str = String.valueOf(decodefloat);
					if(str.equalsIgnoreCase("Infinity"))
					{
						System.out.println("Infinity is working");
						String value = getRandomElement(randomvalue);
						decodefloat= Float.parseFloat(value);
						//tempp.add(decodefloat);
						 
					}
					if(str.equalsIgnoreCase("1.7014118E38")){
						System.out.println("1.7014118E38 is working");
						String value = getRandomElement(randomvalue);
						decodefloat= Float.parseFloat(value);
						//tempp.add(decodefloat);
						
						
					}
					
					tempp.add(decodefloat);
					if(str.equalsIgnoreCase("1.7014118E38")){
						
						System.out.println("vector checking "+tempp);
						}
					//System.out.println("decode float is "+decodefloat);
					
                		
                	 }
                 
                 }
                
                 list.add(tempp);
             }
          //  System.out.println("list are "+list);
             request.setAttribute("PARTITION", "Encoded Database");
             request.setAttribute("list", list);
             RequestDispatcher rd = request.getRequestDispatcher("viewencoded.jsp");
		     rd.forward(request, response);
             }
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

	
}
