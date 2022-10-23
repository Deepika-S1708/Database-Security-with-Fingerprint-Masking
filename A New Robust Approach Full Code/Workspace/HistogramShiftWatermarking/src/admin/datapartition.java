package admin;

import hashfuction.Md5hashfunction;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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

public class datapartition extends HttpServlet {

	Connection connection ;
 	int by=0;
 	Statement stmt ;
 	String ks="1as";   //secret key
	Md5hashfunction md=new Md5hashfunction();
	Vector heading=new Vector();
	
	static Vector s0=new Vector();
	static Vector s1=new Vector();
	static Vector s2=new Vector();
	static Vector s3=new Vector();
	static Vector primaykeypartitionvec=new Vector();
	BigInteger ZERO = new BigInteger ("0");
	BigInteger ONE = new BigInteger ("1");
	BigInteger  TWO= new BigInteger ("2");
	BigInteger THREE = new BigInteger ("3");
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			s0=new Vector();
			s1=new Vector();
			s2=new Vector();
			s3=new Vector();
			primaykeypartitionvec=new Vector();
		

	        	connection = (Connection) getServletContext().getAttribute("connection");
	        	stmt = connection.createStatement();
	        	System.out.println("connection exe");
	        	Vector<Vector> list = new Vector <Vector> ();
	         	String sql="select * from infotechdb";
	         	ResultSet rs =  stmt.executeQuery(sql);
	         	ResultSetMetaData rm = rs.getMetaData();
	         	Vector<String>  metatemp = new Vector<String> ();
	            int count = rm.getColumnCount();
	            for(int i = 1; i <= count; i++){
                  metatemp.add(rm.getColumnName(i));
                 
              }
              
               list.add(metatemp);
             
              Vector temp ;
            
             while(rs.next())
             {
            	 
            	 temp = new Vector();
            	 String sno=rs.getString("SNO");
            	
                 
                 
                 String hashfun1=md.MD5(ks+sno);
                 String concathash=ks+hashfun1;
                 String hashfun2=md.MD5(concathash);
                 
                 BigInteger bi = new BigInteger(hashfun2, 16);
                 BigInteger Even_Value=bi.mod(new BigInteger("4"));
                 
              
                 
                 if(Even_Value.equals(ZERO)){
                	 s0.add(sno);
                 }
                 else if(Even_Value.equals(ONE)){
                	 s1.add(sno);
                 }
                 else if(Even_Value.equals(TWO)){
                	 s2.add(sno);
                 }
                 else if(Even_Value.equals(THREE)){
                	 s3.add(sno);
                 }
             }
           
            
             primaykeypartitionvec.add(s0);
             primaykeypartitionvec.add(s1);
             primaykeypartitionvec.add(s2);
             primaykeypartitionvec.add(s3);
             
             
             request.setAttribute("PARTITION", "TUPLE GROUPING HAS BEEN ALLOCATED");
             
             request.setAttribute("list", primaykeypartitionvec);
        	   
             RequestDispatcher rd = request.getRequestDispatcher("Adminpartitionprocess.jsp");
		     rd.forward(request, response);
		
		}
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
