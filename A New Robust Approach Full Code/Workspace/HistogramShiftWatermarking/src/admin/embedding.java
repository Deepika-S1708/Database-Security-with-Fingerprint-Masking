package admin;

import hashfuction.Hmac;
import hashfuction.binaryconverstion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseStatement;

public class embedding extends HttpServlet {
	Connection connection;
	Statement stmt;
	static Vector utcvec = new Vector();
	Vector selectedtuplewatermarking;
	public static String usertesingstring="";
	int binarycount=0;
	///Global declaration
	String upbinaryyear="";
	String upactiveemp="";
	String upbenchmark="";
	String uptotemp="";
	String upprocount="";
	String uptieupcients="";
	String upbranches="";
	String uprentalexp="";
	String upsalaryamount="";
	String upotherexpenses="";
	String upannualturn="";                                    
	String binaryprofitloss="";
	String upprofitloss="";
	int yearinteger=0;
	String upprofitglob="";
    public	static  String binary="";
    public static String   str="";
	Vector<Vector> embededvector =new Vector<Vector>();
	Vector<String> onevector =new Vector<String>();
	Vector<String> zerovector =new Vector<String>();
	Vector<String> anothervector =new Vector<String>();
	
	String globbinaryactiveemp="",globstrng="";
	//Global declaration
	PreparedStatement preparedStatement = null;

	DatabaseStatement databaseStatement = new DatabaseStatement();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	       out.println("embedding working");
        binaryconverstion bc=new binaryconverstion();
        String username=request.getParameter("username");
		String userid=request.getParameter("userid");
		try{
			utcvec=new Vector();
			
			 connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 
		 String UNIX_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
		 Date now = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat(UNIX_DATE_FORMAT);
		 str=formatter.format(now);//
		 System.out.println("time utc value in encoding process is "+str);		
		 binary=bc.toBinary(str.getBytes());		
		 
		 request.setAttribute("utc",str);
		  System.out.println("binary length is "+binary.length());
		 utcvec.add(str);
		 utcvec.add(binary);		 
		 selectedtuplewatermarking=tupleseselection.selectedtupelwatermarkingvectorpartition;
		 if (binarycount < binary.length()) {
		  for(int k=0;k<selectedtuplewatermarking.size();k++){			  
			 Vector selectedtupevec=new Vector();
			 selectedtupevec=(Vector)selectedtuplewatermarking.get(k);			
			 for(int l=0;l<selectedtupevec.size();l++){
				 String pri=(String)selectedtupevec.get(l);
				 int primarykey=Integer.parseInt(pri);
				 String binaryprimarykey=Integer.toBinaryString(primarykey);				
				 String sql1="select * from infotechdb where SNO="+primarykey;				
            	 ResultSet rs =  stmt.executeQuery(sql1);           	 
            	 while(rs.next())
                 {
            		 if (binarycount < binary.length()) {	
            			// System.out.println("binarycount no is "+binarycount);
            			
				String sno=rs.getString("SNO");			
			String year = rs.getString("YEAR");
			//System.out.println("year in "+primarykey+" is "+year);
			
			int intyear = Integer.parseInt(year);
		    String binaryyear = Integer.toBinaryString(intyear);
						///////////////////////
					    usertesingstring=usertesingstring+sno+"*"+year;
					    /////////////////////////////////////////
			      String temp=binary.substring(binarycount,binarycount+1);
          		   if(temp.equals("1"))
   	                {
          			   float row=1.5f;
          			   float yearint =Integer.parseInt(year)%row;
          			  // yearinteger=(int)yearint;\
          			   if(yearint==0.5||yearint==-0.5){
          				 //  System.out.println("condition works in year");
          				   yearint=1;
          			   }
          			   //System.out.println("\n year if "+yearint);
          			   upbinaryyear=(int)yearint+binaryyear;
          			// System.out.println("\n year if up "+upbinaryyear);
          			// System.out.println("\n year if "+yearint);
   	                        }
          		   else{
          			  float row=-0.5f;
        			   float yearint =Integer.parseInt(year)%row;
        			   if(yearint==0.5||yearint==-0.5){
          				  // System.out.println("condition works in year");
          				   yearint=1;
          			   }
        			  // yearinteger=(int)yearint;
        			   upbinaryyear=(int)yearint+binaryyear;
        			 // System.out.println("\n year else "+yearint);
        			 //  System.out.println("\n year if else "+upbinaryyear);
          			   
          		   }
          		   
          		   
          		 Statement stmtt = connection.createStatement();
 	             String sqlquery="UPDATE binarydb SET YEAR='"+upbinaryyear+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery); 
            		 }
          		   
            		 if (binarycount+1 < binary.length()) {	
					String activeemp = rs.getString("STAFF");
					int intactiveemp = Integer.parseInt(activeemp);
				    String binaryactiveemp = Integer.toBinaryString(intactiveemp);
				  
                     ///////////////////////
				    usertesingstring=usertesingstring+"*"+activeemp;
				    /////////////////////////////////////////
				   
				    String temp1=binary.substring(binarycount+1,binarycount+2);
	          		   if(temp1.equals("1"))
	   	                {

	          			   float row=1.5f;
	          			   float activeempint =Integer.parseInt(activeemp)%row;
	          			 if(activeempint==0.5||activeempint==-0.5){
	          				   //System.out.println("condition works in if activeemployess");
	          				 activeempint=1;
	          			   }
	          			   upactiveemp=(int)activeempint+binaryactiveemp;
	          			// System.out.println("\n activeempint if "+activeempint);
	          			  //out.println("upactiveemp if "+upactiveemp);
	   	                        }
	          		   else{

	          			 float row=-0.5f;
	          			 float activeempint =Integer.parseInt(activeemp)%row;
	          			 if(activeempint==0.5||activeempint==-0.5){
	          				   //System.out.println("condition works in else activeemployess");
	          				    activeempint=1;
	          			   }
	          			 upactiveemp=(int)activeempint+binaryactiveemp;
	          			// System.out.println("\n activeempint else "+activeempint);
	          			  //out.println("upactiveemp else "+upactiveemp);
	          			   
	          		   }
	          		  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET STAFF='"+upactiveemp+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
          		     
	          		   
	          		   
            		 if (binarycount+2 < binary.length()) {
            			 
                     String benchmarkemp=rs.getString("VECHICLE");
                     int intbenchmarkemp=Integer.parseInt(benchmarkemp);
                     String binarybenchmarkemp=Integer.toBinaryString(intbenchmarkemp);
                     ///////////////////////
 				    usertesingstring=usertesingstring+"*"+benchmarkemp;
 				    /////////////////////////////////////////
                     
                     String temp2=binary.substring(binarycount+2,binarycount+3);
	          		   if(temp2.equals("1"))
	   	                {
	          			   float row=1.5f;
	          			   float benchint =Integer.parseInt(benchmarkemp)%row;
	          			 if(benchint==0.5||benchint==-0.5){
	          				  // System.out.println("condition works in if BENCHMARKEMPLOYEES");
	          				    benchint=1;
	          			   }
	          			   upbenchmark=(int)benchint+binarybenchmarkemp;
	          			// System.out.println("\n bench if "+benchint);
	   	                        }
	          		   else{
	          			 float row=-0.5f;
	          			   float benchint =Integer.parseInt(benchmarkemp)%row;
	          			 if(benchint==0.5||benchint==-0.5){
	          				 //  System.out.println("condition works in else BENCHMARKEMPLOYEES");
	          				 benchint=1;
	          			   }
	          			   upbenchmark=(int)benchint+binarybenchmarkemp;
	          			//System.out.println("\n bench else "+benchint);
	          			   
	          		   }
	          		  Statement stmtt = connection.createStatement();
      	             String sqlquery="UPDATE binarydb SET VECHICLE='"+upbenchmark+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
                     
	          		   
            		 if (binarycount+3 < binary.length()) {
                     String totemp=rs.getString("MATERIAL");
                     int inttotemp = Integer.parseInt(totemp);
     				 String binarytotemp = Integer.toBinaryString(inttotemp);
     				 
     				 ///////////////////////
   				    usertesingstring=usertesingstring+"*"+totemp;
   				    /////////////////////////////////////////
                      
     				 String temp3=binary.substring(binarycount+3,binarycount+4);
	          		   if(temp3.equals("1"))
	   	                {
	          			   float row=1.5f;
	          			   float totint =Integer.parseInt(totemp)%row;
	          			 if(totint==0.5||totint==-0.5){
	          				  // System.out.println("condition works in if totint");
	          				 totint=1;
	          			   }
	          			   //System.out.println("total int if is "+totint);
	          			   uptotemp=(int)totint+binarytotemp;
	   	                        }
	          		   else{
	          			  float row=-0.5f;
	          			   float totint =Integer.parseInt(totemp)%row;
	          			 if(totint==0.5||totint==-0.5){
	          				 //  System.out.println("condition works in else totint");
	          				 totint=1;
	          			   }
	          			  // System.out.println("total int else is "+totint);
	          			   uptotemp=(int)totint+binarytotemp;
	          			   
	          		   }
	          		   
	          		  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET MATERIAL='"+uptotemp+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
     				
                    
            		 if (binarycount+4 < binary.length()) { 
	          		String projectcount=rs.getString("DAMAGE");
	          		int intprojectcount = Integer.parseInt(projectcount);
					String binaryprojectcount = Integer.toBinaryString(intprojectcount);
					
                              /////////////////////// 
  				    usertesingstring=usertesingstring+"*"+projectcount;
  				    /////////////////////////////////////////
                     
					String temp4=binary.substring(binarycount+4,binarycount+5);
	          		   
					if(temp4.equals("1"))
	   	                {
	          			    float row=1.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				  // System.out.println("condition works in if projcountint");
	          				 projcountint=1;
	          			   }
	          			 // System.out.println("project coutn if "+projcountint);
	          			    upprocount=(int)projcountint+binaryprojectcount;
	   	                        }
	          		   else{
	          			  float row=-0.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				 //  System.out.println("condition works in else projcountint");
	          				 projcountint=1;
	          			   }
	          			  //System.out.println("project coutn else "+projcountint);
	          			    upprocount=(int)projcountint+binaryprojectcount;
	          			   
	          		   }
					
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET DAMAGE='"+upprocount+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
	          		 
	          		 
            		 if (binarycount+5 < binary.length()) { 
                     String tieupclients=rs.getString("CUSTOMER");
                     int inttieupclients = Integer.parseInt(tieupclients);
     				 String binarytieupclients = Integer.toBinaryString(inttieupclients);
     				  /////////////////////// 
   				    usertesingstring=usertesingstring+"*"+tieupclients;
   				    /////////////////////////////////////////
     				 String temp5=binary.substring(binarycount+5,binarycount+6);
	          		   
					 if(temp5.equals("1"))
	   	                {
	          			   float row=1.5f;
	          			   float tieupclientsint =Integer.parseInt(tieupclients)%row;
	          			 if(tieupclientsint==0.5||tieupclientsint==-0.5){
	          				  // System.out.println("condition works in if tieupclientsint");
	          				 tieupclientsint=1;
	          			   }
	          			   
	          			 //  System.out.println("tieupclients if "+tieupclientsint);
	          			   uptieupcients=(int)tieupclientsint+binarytieupclients;
	   	                        }
	          		    else{
	          		      float row=-0.5f;
	          			  float tieupclientsint =Integer.parseInt(tieupclients)%row;
	          			  
	          			 if(tieupclientsint==0.5||tieupclientsint==-0.5){
	          				 //  System.out.println("condition works in else tieupclientsint");
	          				 tieupclientsint=1;
	          			   }
	          			//System.out.println("tieupclients else "+tieupclientsint);
	          			  uptieupcients=(int)tieupclientsint+binarytieupclients;
	          		           }
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET CUSTOMER='"+uptieupcients+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
                     
            		 }
            		  
            		 if (binarycount+6 < binary.length()) { 
                     String brances=rs.getString("BRANCHES");
                     int intbrances = Integer.parseInt(brances);
     				 String binarybrances = Integer.toBinaryString(intbrances);
     				             /////////////////////// 
    				    usertesingstring=usertesingstring+"*"+brances;
    				    /////////////////////////////////////////
     				 
     				 
     			 	 String temp6=binary.substring(binarycount+6,binarycount+7);
	          		   
					 if(temp6.equals("1"))
	   	                {
						 float row=1.5f;
	          			   float brancesint =Integer.parseInt(brances)%row;
	          			 if(brancesint==0.5||brancesint==-0.5){
	          				   //System.out.println("condition works in if brancesint");
	          				 brancesint=1;
	          			   }
	          			 //System.out.println("brancesint if "+brancesint);
	          			   upbranches=(int)brancesint+binarybrances;
	   	                }
	          	      else{
	          	    	   float row=-0.5f;
	          			   float brancesint =Integer.parseInt(brances)%row;
	          			 if(brancesint==0.5||brancesint==-0.5){
	          				   //System.out.println("condition works in else brancesint");
	          				 brancesint=1;
	          			   }
	          			   //System.out.println("brancesint else "+brancesint);
	          			   upbranches=(int)brancesint+binarybrances;
	          		       }
					 
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET  BRANCHES='"+upbranches+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
					 
     				 
     				 
            		 if (binarycount+7 < binary.length()) { 
     				 String rentalexp=rs.getString("RENTALEXPENSES");
     				 float floatrent = Float.parseFloat(rentalexp);
    				 int intrent = Float.floatToIntBits(floatrent);
    				 String binaryrent = Integer.toBinaryString(intrent);
    				 
    				  /////////////////////// 
 				    usertesingstring=usertesingstring+"*"+rentalexp;
 				    /////////////////////////////////////////
    				 
    				 
    				 
     				 
    				 String temp7=binary.substring(binarycount+7,binarycount+8);
					 if(temp7.equals("1"))
	   	                {
	          			  // int row=2;
						    float row=1.5f;
	          			   float rentalint =floatrent%row;
	          			 if(rentalint==0.5||rentalint==-0.5){
	          				   //System.out.println("condition works in if rentalint");
	          				 rentalint=1;
	          			   }
	          			   
	          			 //System.out.println("rentalint if "+rentalint);
	          			   uprentalexp=(int)rentalint+binaryrent;
	          			// System.out.println("\n rental if "+rentalint);
	   	                }
	          	      else{
	          	    	        float row=-0.5f;
	          			        float rentalint =floatrent%row;
	          			      if(rentalint==0.5||rentalint==-0.5){
		          				 //  System.out.println("condition works in else rentalint");
		          				 rentalint=1;
		          			   }
	          			     // System.out.println("rentalint else "+rentalint);
			          			uprentalexp=(int)rentalint+binaryrent;
			          			//System.out.println("\n rental if "+rentalint);
	          		       }
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET RENTALEXPENSES='"+uprentalexp+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
     				 
            		
            		 
            		 if (binarycount+8 < binary.length()) { 
                     String salryamount=rs.getString("SALARYAMOUNT_PA");
     				 float floatsalryamount = Float.parseFloat(salryamount);
     				 int intsalryamount = Float.floatToIntBits(floatsalryamount);
     				 String binarysalryamount = Integer.toBinaryString(intsalryamount);
     				  /////////////////////// 
  				    usertesingstring=usertesingstring+"*"+salryamount;
  				    /////////////////////////////////////////
     				 
     				 
     				 String temp8=binary.substring(binarycount+8,binarycount+9);
					 if(temp8.equals("1"))
	   	                {
						   float row=1.5f;
	          			   float salaryint =floatsalryamount%row;
	          			 if(salaryint==0.5||salaryint==-0.5){
	          				  // System.out.println("condition works in if salaryint");
	          				 salaryint=1;
	          			   }
	          			//  System.out.println("salaryint if "+salaryint);
	          			   upsalaryamount=(int)salaryint+binarysalryamount;
	   	                }
	          	      else{
	          	    	 float row=-0.5f;
	          			   float salaryint =floatsalryamount%row;
	          			 if(salaryint==0.5||salaryint==-0.5){
	          				  // System.out.println("condition works in else salaryint");
	          				 salaryint=1;
	          			   }
	          			 // System.out.println("salaryint else "+salaryint);
	          			   upsalaryamount=(int)salaryint+binarysalryamount;
	          		       }
					 
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET SALARYAMOUNT_PA='"+upsalaryamount+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
     				 
            		 
            		 
            		 if (binarycount+9 < binary.length()) { 
					 String otherexpenses=rs.getString("OTHER_EXPENSES_PA");
					 float floatotherexpenses = Float.parseFloat(otherexpenses);
					 int intotherexpenses = Float.floatToIntBits(floatotherexpenses);
			         String binaryotherexpenses = Integer.toBinaryString(intotherexpenses);
			         /////////////////////// 
	  				    usertesingstring=usertesingstring+"*"+otherexpenses;
	  				    /////////////////////////////////////////
	     				 
			         String temp9=binary.substring(binarycount+9,binarycount+10);
					 if(temp9.equals("1"))
	   	                {
						 float row=1.5f;
	          			  float otherexpensesint =floatotherexpenses%row;
	          			 if(otherexpensesint==0.5||otherexpensesint==-0.5){
	          				 //  System.out.println("condition works in if otherexpensesint");
	          				 otherexpensesint=1;
	          			   }
	          			  //System.out.println("otherexpensesint if "+otherexpensesint);
	          			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
	   	                }
	          	      else{
	          	    	 float row=-0.5f;
	          			  float otherexpensesint =floatotherexpenses%row;
	          			 if(otherexpensesint==0.5||otherexpensesint==-0.5){
	          				   //System.out.println("condition works in else otherexpensesint");
	          				 otherexpensesint=1;
	          			   }
	          			 // System.out.println("otherexpensesint else "+otherexpensesint);
	          			
	          			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
	          		       }
					 
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET OTHER_EXPENSES_PA='"+upotherexpenses+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
					 
					 
            		 if (binarycount+10 < binary.length()) { 
                     String annualto=rs.getString("ANNUALTURNOVER");
                     float floatannualto = Float.parseFloat(annualto);
     			  	 int intannualto = Float.floatToIntBits(floatannualto);
     				 String binaryannualto = Integer.toBinaryString(intannualto);
     				  /////////////////////// 
	  				    usertesingstring=usertesingstring+"*"+annualto;
	  				    /////////////////////////////////////////
     				 String temp10=binary.substring(binarycount+10,binarycount+11);
					 if(temp10.equals("1"))
	   	                {
						 float row=1.5f;
	          			   float annualturnint =floatannualto%row;
	          			 if(annualturnint==0.5||annualturnint==-0.5){
	          				  // System.out.println("condition works in if annualturnint");
	          				 annualturnint=1;
	          			   }
		          			 // System.out.println("annualturnint if "+annualturnint);
		          			
	          			   upannualturn=(int)annualturnint+binaryannualto;
	   	                }
	          	      else{
	          	    	float row=-0.5f;
	          			   float annualturnint =floatannualto%row;
	          			 if(annualturnint==0.5||annualturnint==-0.5){
	          				  // System.out.println("condition works in else annualturnint");
	          				 annualturnint=1;
	          			   }
	          			// System.out.println("annualturnint else "+annualturnint);
	          			   upannualturn=(int)annualturnint+binaryannualto;
	          		       }
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET ANNUALTURNOVER='"+upannualturn+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
            		 }
                     
            		 if (binarycount+11 < binary.length()) { 
                     String profitloss=rs.getString("PROFIT/LOSS");
                     float floatprofitloss = Float.parseFloat(profitloss);
     					// out.println("float rental is "+floatrent);
     					int intprofitloss = Float.floatToIntBits(floatprofitloss);
     					binaryprofitloss = Integer.toBinaryString(intprofitloss);
     					  /////////////////////// 
	  				    usertesingstring=usertesingstring+"*"+profitloss+"####";
	  				    ////////////////////////////////////////
     				
     					String temp11=binary.substring(binarycount+11,binarycount+12);
   					  if(temp11.equals("1"))
   	   	                {
   						float row=1.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in if profitlossint");
	          				 profitlossint=1;
	          			   }
	          			// System.out.println("profitlossint if "+profitlossint);
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
	          			   if(upprofitloss.equals("")){
	          				   System.out.println("null is exeuted");
	          			   }
   	   	                }
   	          	       else{
   	          	    	float row=-0.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in else profitlossint");
	          				 profitlossint=1;
	          			   }
	          			// System.out.println("profitlossint else "+profitlossint);
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
   	          		       }
   					  if(upprofitloss.contains("-")){
   						 // System.out.println("upprofit before is "+upprofitloss);
   						upprofitglob=upprofitloss.replace("-","").trim();
   						 //System.out.println("upprofit after is "+upprofitglob);
   					      }
   					  else{
   						upprofitglob=upprofitloss;
   					  }
   					if(upprofitglob.equals("")){
       				   System.out.println("null is exeuted");
       			   }
   				                     
   					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET PROFITLOSS='"+upprofitglob+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
                   
     				//}
            		        }
            		if(binarycount < binary.length()){
            			 
            			 	                  
            			 binarycount=binarycount+12;
            			            		 
            			            		 }
            		
                 }
          
			 
			 }//SECOND FOR LOOP CLOSE
			
			 
		 }//FIRST FOR LOOP CLOSE
		   //System.out.println("final string is "+usertesingstring);
		 }
			else{
				
				//out.println("process completed");
			}
		   try{
				System.out.println(" SECOND connection exe");
				Vector list = new Vector();
				String sql = "select * from binarydb";
				ResultSet rs = stmt.executeQuery(sql);
				Vector temp;
				while (rs.next()) {
					temp = new Vector();
					for (int i = 1; i <= 13; i++) {
						if(i==1){
							int decimal = Integer.parseInt(rs.getString(i), 2);
							temp.add(decimal);
							}
						else{
						temp.add(rs.getString(i));
						}
					}
					list.add(temp);
				}
					preparedStatement = connection.prepareStatement(databaseStatement.updatefingertemplate());
					preparedStatement.setBytes(1, usertesingstring.toString().getBytes());
					preparedStatement.setString(2, Hmac.encrypt(str));
					preparedStatement.setString(3, username);
					preparedStatement.setString(4, userid);
					preparedStatement.executeUpdate();
	             request.setAttribute("PARTITION", "EMBEDDING PROCESS HAS BEEN DONE");
	             request.setAttribute("list", list);
	             RequestDispatcher rd = request.getRequestDispatcher("Embedding.jsp");
			        rd.forward(request, response);
	             }
			
			catch(Exception e){
				e.printStackTrace();
				
			}
		
		}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
	}
	
}
