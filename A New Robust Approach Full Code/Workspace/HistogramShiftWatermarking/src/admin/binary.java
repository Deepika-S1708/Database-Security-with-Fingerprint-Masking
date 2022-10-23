package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
import java.sql.ResultSet;

import database.DatabaseStatement;



public class binary extends HttpServlet {
 	Connection connection ;
 	Statement stmt ;
 	String status="";
 	 String binaryprofitloss="";
 	DatabaseStatement db=new DatabaseStatement();
	
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
        	 Vector<Vector> list = new Vector <Vector> ();
        	 
        /*	 String sql1=("SELECT COUNT(*) FROM binaryinfotechstatus");
   	      ResultSet rs1 =  stmt.executeQuery(sql1);
   	      if(rs1.next())
 	   		{
 	   			int a=Integer.parseInt(rs1.getString("count(*)"));
 	   			System.out.println("a value is "+a);
 	   			if(a==0){
 	   				System.out.println("condition working");
 	   		 String sqlquery = ("insert into binaryinfotechstatus values('"+integerbinaryyear+"','" +binaryactiveemp+ "','" +binarybenchmarkemp+ "','"+binarytotemp + "','" +binaryprojectcount + "','" +binarytieupclients + "','" +binarybrances + "','" + binaryrent + "','" + binarysalryamount + "','" + binaryotherexpenses + "','" + binaryannualto + "','" + binaryprofitloss + "')");
 	         stmt.executeUpdate(sqlquery);
 	   			}}*/
   	      
			String sql = "select * from infotechdb";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rm = rs.getMetaData();
			Vector<String> metatemp = new Vector<String>();
			int count = rm.getColumnCount();
			for (int i = 1; i <= count; i++){
                  metatemp.add(rm.getColumnName(i));
                 
              }
              
               list.add(metatemp);
             
              Vector temp ;
            
             while(rs.next())
             {
            	 
            	 temp = new Vector();
            	 
            	 String sno=rs.getString("SNO");
            	 int intsno=Integer.parseInt(sno);
            	 String binarysno=Integer.toBinaryString(intsno);
            	 String intesno=binarysno;
            	 
            	 
            	 
            	 String year=rs.getString("YEAR");
            	// out.println("year is "+year); 
            	 int intyear=Integer.parseInt(year);
                // out.println("year is "+intyear); 
                 String binaryyear=Integer.toBinaryString(intyear);
                 BigInteger bigintegerbinaryyear = new BigInteger(binaryyear, 16);
                 
                  int integerbinaryyear = bigintegerbinaryyear.intValue();
               //  int c=Integer.parseInt(integerbinaryyear);
                 //out.println("year is "+binaryyear);
                 
                 String activeemp=rs.getString("STAFF");
             	// out.println("year is "+year); 
             	 int intactiveemp=Integer.parseInt(activeemp);
                 // out.println("year is "+intyear); 
                 String binaryactiveemp=Integer.toBinaryString(intactiveemp);
                 //out.println("year is "+binaryyear);
                 
                 
                  String benchmarkemp=rs.getString("VECHICLE");
              	   // out.println("year is "+year); 
              	  int intbenchmarkemp=Integer.parseInt(benchmarkemp);
                  // out.println("year is "+intyear); 
                  String binarybenchmarkemp=Integer.toBinaryString(intbenchmarkemp);
                  //out.println("year is "+binaryyear);
                  
				String totemp = rs.getString("MATERIAL");
				// out.println("year is "+year);
				int inttotemp = Integer.parseInt(totemp);
				// out.println("year is "+intyear);
				String binarytotemp = Integer.toBinaryString(inttotemp);
				// out.println("year is "+binaryyear);

				String projectcount = rs.getString("DAMAGE");
				// out.println("year is "+year);
				int intprojectcount = Integer.parseInt(projectcount);
				// out.println("year is "+intyear);
				String binaryprojectcount = Integer
						.toBinaryString(intprojectcount);
				// out.println("year is "+binaryyear);

				String tieupclients = rs.getString("CUSTOMER");
				// out.println("year is "+year);
				int inttieupclients = Integer.parseInt(tieupclients);
				// out.println("year is "+intyear);
				String binarytieupclients = Integer
						.toBinaryString(inttieupclients);
				// out.println("year is "+binaryyear);

				String brances = rs.getString("BRANCHES");
				// out.println("year is "+year);
				int intbrances = Integer.parseInt(brances);
				// out.println("year is "+intyear);
				String binarybrances = Integer.toBinaryString(intbrances);
				// out.println("year is "+binaryyear);

                 
				String rentalexp = rs.getString("RENTALEXPENSES");
				
				
			    // out.println("String rental is "+rentalexp);
				float floatrent = Float.parseFloat(rentalexp);
				// out.println("float rental is "+floatrent);
				int intrent = Float.floatToIntBits(floatrent);
				String binaryrent = Integer.toBinaryString(intrent);
				// out.println("binary rent is "+binaryrent);

				
				
				String salryamount = rs.getString("SALARYAMOUNT_PA");
				// out.println("String rental is "+rentalexp);
				float floatsalryamount = Float.parseFloat(salryamount);
				// out.println("float rental is "+floatrent);
				int intsalryamount = Float.floatToIntBits(floatsalryamount);
				String binarysalryamount = Integer
						.toBinaryString(intsalryamount);
				// out.println("binary rent is "+binaryrent);

				String otherexpenses = rs.getString("OTHER_EXPENSES_PA");
				// out.println("String rental is "+rentalexp);
				float floatotherexpenses = Float.parseFloat(otherexpenses);
				// out.println("float rental is "+floatrent);
				int intotherexpenses = Float.floatToIntBits(floatotherexpenses);
				String binaryotherexpenses = Integer
						.toBinaryString(intotherexpenses);
				// out.println("binary rent is "+binaryrent);

				String annualto = rs.getString("ANNUALTURNOVER");
				// out.println("String rental is "+rentalexp);
				float floatannualto = Float.parseFloat(annualto);
				// out.println("float rental is "+floatrent);
				int intannualto = Float.floatToIntBits(floatannualto);
				String binaryannualto = Integer.toBinaryString(intannualto);
				// out.println("binary rent is "+binaryrent);

				String profitloss = rs.getString("PROFIT/LOSS");
				// out.println("String rental is "+rentalexp);
				/*if (profitloss.contains("-")) {
					float floatprofitloss = Float.parseFloat(profitloss);
					// out.println("float rental is "+floatrent);
					int intprofitloss = Float.floatToIntBits(floatprofitloss);
					binaryprofitloss = "-"+Integer.toBinaryString(intprofitloss);

				} else {*/

					float floatprofitloss = Float.parseFloat(profitloss);
					// out.println("float rental is "+floatrent);
					int intprofitloss = Float.floatToIntBits(floatprofitloss);
					binaryprofitloss = Integer.toBinaryString(intprofitloss);
				//}
        	    
        	      //out.println("binary rent is "+binaryrent);
           	      temp.add(intesno);
        	      temp.add(binaryyear);
        	      temp.add(binaryactiveemp);
        	      temp.add(binarybenchmarkemp);
        	      temp.add(binarytotemp);
        	      temp.add(binaryprojectcount);
        	      temp.add(binarytieupclients);
        	      temp.add(binarybrances);
        	      temp.add(binaryrent);
        	      temp.add(binarysalryamount);
        	      temp.add(binaryotherexpenses);
        	      temp.add(binaryannualto);
        	      temp.add(binaryprofitloss);
        	     // System.out.println("temp vector is "+temp);
        	      list.add(temp);
        	      
             }
           //  System.out.println("list are "+list);
            
            	 
            	 String sql1=("SELECT COUNT(*) FROM binarydb");
          	      ResultSet rs1 =  stmt.executeQuery(sql1);
          	      if(rs1.next())
        	   		{
        	   			int a=Integer.parseInt(rs1.getString("count(*)"));
        	   			System.out.println("a value is "+a);
        	   			if(a==0){
        	   				System.out.println("condition working");
        	   			 for(int i=1;i<list.size();i++){
        	            	 Vector v=(Vector)list.get(i);
        	   		 String sqlquery = ("insert into binarydb values('"+v.get(0)+"','"+v.get(1)+"','"+v.get(2)+"','"+v.get(3)+"','"+v.get(4)+"','"+v.get(5)+"','"+v.get(6)+"','"+v.get(7)+"','"+v.get(8)+"','"+v.get(9)+"','"+v.get(10)+"','"+v.get(11)+"','"+v.get(12)+"')");
        	         stmt.executeUpdate(sqlquery);
        	   			}
        	   			}
        	   			else{
        	   				
        	   				System.out.println("else portion is working");
        	   			}
            	 
                     }
             
             // out.println("process completed");
              //out.println("list are "+list);
             status="BINARY DATABASE HAS BEEN CREATED";
             request.setAttribute("FETCH", status);
             request.setAttribute("list", list);
             RequestDispatcher rd = request.getRequestDispatcher("Embedding.jsp");
		     rd.forward(request, response);
		        
             }
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
