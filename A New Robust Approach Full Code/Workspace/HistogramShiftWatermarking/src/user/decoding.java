package user;

import hashfuction.Hmac;
import hashfuction.binaryconverstion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import admin.*;


import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import database.DatabaseStatement;

import admin.embedding;

public class decoding extends HttpServlet {
Connection connection;
Statement stmt;
Vector watermarkingbitvec;
String testingstring;
String binary;
String str1;
String str2;
int intialstage=0;
String usertestingstring;
int binarycount=0;
int checkingcount=0;
int checkingcount1=0;
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
String profitlossstring="";
String binaryprimarykey="";
String upprofitglob="";
boolean sucess=false;
boolean pageredirect=false;
boolean sucesscontinue=false;
boolean failure=false;
boolean compare=false;
boolean extract=false;
boolean extract1=false;

float decimal12;
Vector <Vector>checkingvec = new Vector<Vector>();
Vector selectedtuplewatermarking;////////////////
int count=0;
int decodeint=0; 
float decodefloat=0;
int k=0;
Vector <Vector> list = new Vector<Vector>();
String decodestring="";
BigInteger bigInt;
StringBuffer buf1;
StringBuffer buf2;
StringBuffer buf3;
StringBuffer buf4;
StringBuffer buf5;
StringBuffer buf6;
StringBuffer buf7;
StringBuffer buf8;
StringBuffer buf9;
StringBuffer buf10;
StringBuffer buf11;
StringBuffer buf12;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userid=request.getParameter("userid");
		String username=request.getParameter("username");
		DatabaseStatement databaseStatement = new DatabaseStatement();
		try{
			  checkingcount=0;
			  checkingcount1=0;
			 count=0;
			 k=0;
			 binaryconverstion bc1=new binaryconverstion();
			 connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 //str1=request.getParameter("ownership").trim();
		        PreparedStatement preparedStatement = connection.prepareStatement(databaseStatement.checkUserid());
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, userid);
				ResultSet resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
				    str1=(String)resultSet.getString("fingerprint");
				    str1=Hmac.decrypt(resultSet.getString("fingertemplate"));
				    embedding.usertesingstring=new String((String)resultSet.getString("secretkey"));
				    embedding.str=str1;
				    System.out.println("ownership is "+str1);
				     str2=embedding.str.trim();
					 compare=true;
			    	 extract=true;
			    	 extract1=true;
				}else if(str1.equalsIgnoreCase("")){
			    	 System.out.println("null is working");
			    	 extract=false;
			    	 extract1=false;
			    	 sucess=false;
			    	 failure=true;
			     }
			     else{
			    	 System.out.println("not equals-----------------");
			    	 System.out.println("string first"+str1);
			    	 System.out.println("string secon"+str2);
			    	 compare=false;
			    	 extract=true;
			    	 extract1=true;
			    	 
			     }
        	
        	System.out.println("time value in decoding process is "+str1);
		    binary=bc1.toBinary(str1.getBytes());
		    System.out.println("time binary value in decoding process is "+binary);
		    System.out.println("time binary value length in decoding process is "+binary.length());
		    usertestingstring=embedding.usertesingstring;
		    System.out.println("usertesting string is "+usertestingstring);
	        String splittedstring[]=usertestingstring.split("####");
	        binarycount=0;
	        
	        if(usertestingstring.equals("")){
	        	System.out.println("Encoding process not done");
	        	failure=true;
	        	compare=false;
	                 }
	        if(str1.length()>str2.length()){
	        	 extract=false;
		    	 extract1=false;
		    	 sucess=false;
		    	 compare=false;
		    	 failure=true;
		    	 
	        }
	      
	        //////////////////////////////////////////////////////////////////////
	        
	        
	        if(extract){
	        for(int k=0;k<splittedstring.length;k++)
	         {
		if (binarycount < binary.length()) {
		String element=splittedstring[k];
		StringTokenizer st = new StringTokenizer(element, "*");
        while (st.hasMoreElements()) {
        	
        	Vector checkingsubvec = new Vector();
        	
        	 if (binarycount < binary.length()) {	
        		     String so=st.nextToken();
                     String year=st.nextToken();
                	 int intyear = Integer.parseInt(year);
    		         String binaryyear = Integer.toBinaryString(intyear);
                     String temp=binary.substring(binarycount,binarycount+1);
          		   if(temp.equals("1"))
   	                {
          			   float row=1.5f;
        			   float yearint =Integer.parseInt(year)%row;
        			   if(yearint==0.5||yearint==-0.5){
          				   //System.out.println("condition works in year");
          				   yearint=1;
          			   }
        			   upbinaryyear=(int)yearint+binaryyear;
          			   checkingsubvec.add(upbinaryyear);
   	                        }
          		   else{
          			 float row=-0.5f;
      			     float yearint =Integer.parseInt(year)%row;
      			   if(yearint==0.5||yearint==-0.5){
      				   //System.out.println("condition works in year");
      				   yearint=1;
      			   }
      			     upbinaryyear=(int)yearint+binaryyear;
        			 checkingsubvec.add(upbinaryyear);
          		   }
        	 
        	 }
          
        	 
        	 if (binarycount+1 < binary.length()) {	
					String activeemp = st.nextToken();
					int intactiveemp = Integer.parseInt(activeemp);
				    String binaryactiveemp = Integer.toBinaryString(intactiveemp);
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
	          			  checkingsubvec.add(upactiveemp);
	          			  }
	          		   else{
	          			 float row=-0.5f;
	          			 float activeempint =Integer.parseInt(activeemp)%row;
	          			 if(activeempint==0.5||activeempint==-0.5){
	          				   //System.out.println("condition works in if activeemployess");
	          				 activeempint=1;
	          			   }
	          			 upactiveemp=(int)activeempint+binaryactiveemp;
	          			 checkingsubvec.add(upactiveemp);
	          		   }
       		     
         		 }
       		     
        	   
    		 if (binarycount+2 < binary.length()) {
             String benchmarkemp=st.nextToken();
             int intbenchmarkemp=Integer.parseInt(benchmarkemp);
             String binarybenchmarkemp=Integer.toBinaryString(intbenchmarkemp);
             String temp2=binary.substring(binarycount+2,binarycount+3);
      		   if(temp2.equals("1"))
	                {
      			  float row=1.5f;
     			  float benchint =Integer.parseInt(benchmarkemp)%row;
     			 if(benchint==0.5||benchint==-0.5){
     				  // System.out.println("condition works in if VECHICLE");
     				    benchint=1;
     			   }
     			  upbenchmark=(int)benchint+binarybenchmarkemp;
      			  checkingsubvec.add(upbenchmark);
	                        }
      		   else{
        			   float row=-0.5f;
        			   float benchint =Integer.parseInt(benchmarkemp)%row;
        			   if(benchint==0.5||benchint==-0.5){
	          				  // System.out.println("condition works in if VECHICLE");
	          				    benchint=1;
	          			   }
        			   upbenchmark=(int)benchint+binarybenchmarkemp;
      			       checkingsubvec.add(upbenchmark);
      		   }
             
    		 }
             
          
    		 if (binarycount+3 < binary.length()) {
                 String totemp=st.nextToken();
                 int inttotemp = Integer.parseInt(totemp);
 				 String binarytotemp = Integer.toBinaryString(inttotemp);
 				 String temp3=binary.substring(binarycount+3,binarycount+4);
          		   if(temp3.equals("1"))
   	                {
          			   float row=1.5f;
        			   float totint =Integer.parseInt(totemp)%row;
        			   if(totint==0.5||totint==-0.5){
	          				  // System.out.println("condition works in if totint");
	          				 totint=1;
	          			   }
        			   uptotemp=(int)totint+binarytotemp;
          			   checkingsubvec.add(uptotemp);
   	                        }
          		   else{
          			  float row=-0.5f;
         			  float totint =Integer.parseInt(totemp)%row;
         			 if(totint==0.5||totint==-0.5){
         				  // System.out.println("condition works in if totint");
         				 totint=1;
         			   }
         			  uptotemp=(int)totint+binarytotemp;
					  checkingsubvec.add(uptotemp);
          		   }
        		 }
          
        
         
    		 if (binarycount+4 < binary.length()) { 
	          		String projectcount=st.nextToken();
	          		int intprojectcount = Integer.parseInt(projectcount);
					String binaryprojectcount = Integer.toBinaryString(intprojectcount);
					String temp4=binary.substring(binarycount+4,binarycount+5);
	          		   
					if(temp4.equals("1"))
	   	                {
						    float row=1.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				  // System.out.println("condition works in if projcountint");
	          				 projcountint=1;
	          			   }
	          			    upprocount=(int)projcountint+binaryprojectcount;
	          			    checkingsubvec.add(upprocount);
	   	                        }
	          		   else{
	          			  float row=-0.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				  // System.out.println("condition works in if projcountint");
	          				 projcountint=1;
	          			   }
	          			    upprocount=(int)projcountint+binaryprojectcount;
			          	    checkingsubvec.add(upprocount);
	          		   }
         		 }
         
    		 
    		 
    		 if (binarycount+5 < binary.length()) { 
             String tieupclients=st.nextToken();
             int inttieupclients = Integer.parseInt(tieupclients);
				 String binarytieupclients = Integer.toBinaryString(inttieupclients);
				
				 String temp5=binary.substring(binarycount+5,binarycount+6);
      		   
			 if(temp5.equals("1"))
	                {
				  float row=1.5f;
     			   float tieupclientsint =Integer.parseInt(tieupclients)%row;
     			  if(tieupclientsint==0.5||tieupclientsint==-0.5){
      				  // System.out.println("condition works in if tieupclientsint");
      				 tieupclientsint=1;
      			   }
     			   uptieupcients=(int)tieupclientsint+binarytieupclients;
      			  checkingsubvec.add(uptieupcients);
	                        }
      		    else{
      		    	float row=-0.5f;
        			  float tieupclientsint =Integer.parseInt(tieupclients)%row;
        			  if(tieupclientsint==0.5||tieupclientsint==-0.5){
          				  // System.out.println("condition works in if tieupclientsint");
          				 tieupclientsint=1;
          			   }
        			  uptieupcients=(int)tieupclientsint+binarytieupclients;
	          			  checkingsubvec.add(uptieupcients);
      		           }
             
    		 }
    		 
    		 
    		 if (binarycount+6 < binary.length()) { 
                 String brances=st.nextToken();
                 int intbrances = Integer.parseInt(brances);
 				 String binarybrances = Integer.toBinaryString(intbrances);
 				
 			 	 String temp6=binary.substring(binarycount+6,binarycount+7);
          		   
				 if(temp6.equals("1"))
   	                {

					 float row=1.5f;
          			   float brancesint =Integer.parseInt(brances)%row;
          			 if(brancesint==0.5||brancesint==-0.5){
        				   //System.out.println("condition works in if brancesint");
        				 brancesint=1;
        			   }
          			   upbranches=(int)brancesint+binarybrances;
          			  checkingsubvec.add(upbranches);
   	                }
          	      else{
          	    	 float row=-0.5f;
        			 float brancesint =Integer.parseInt(brances)%row;
        			 if(brancesint==0.5||brancesint==-0.5){
        				   //System.out.println("condition works in if brancesint");
        				 brancesint=1;
        			   }
        			 upbranches=(int)brancesint+binarybrances;
					 checkingsubvec.add(upbranches);
          		       }
        		 }
				 
    		 
    		 if (binarycount+7 < binary.length()) { 
				 String rentalexp=st.nextToken();
				 float floatrent = Float.parseFloat(rentalexp);
			 int intrent = Float.floatToIntBits(floatrent);
			 String binaryrent = Integer.toBinaryString(intrent);
		
			 String temp7=binary.substring(binarycount+7,binarycount+8);
			 if(temp7.equals("1"))
	                {
				    float row=1.5f;
       			   float rentalint =floatrent%row;
       			 if(rentalint==0.5||rentalint==-0.5){
    				   //System.out.println("condition works in if rentalint");
    				 rentalint=1;
    			   }
    			   
       			   uprentalexp=(int)rentalint+binaryrent;
    			// System.out.println("\n rental if "+rentalint);
      			   checkingsubvec.add(uprentalexp);
	                }
      	      else{

	    	        float row=-0.5f;
			        float rentalint =floatrent%row;
			        if(rentalint==0.5||rentalint==-0.5){
       				   //System.out.println("condition works in if rentalint");
       				 rentalint=1;
       			   }
       			   
        			uprentalexp=(int)rentalint+binaryrent;
   			             //System.out.println("\n rental if "+rentalint);
	          			checkingsubvec.add(uprentalexp);
	          			
      		       }
    		 }
        
    		 if (binarycount+8 < binary.length()) { 
                 String salryamount=st.nextToken();
 				 float floatsalryamount = Float.parseFloat(salryamount);
 				 int intsalryamount = Float.floatToIntBits(floatsalryamount);
 				 String binarysalryamount = Integer.toBinaryString(intsalryamount);
 				 
 				 String temp8=binary.substring(binarycount+8,binarycount+9);
				 if(temp8.equals("1"))
   	                {

					   float row=1.5f;
        			   float salaryint =floatsalryamount%row;
        			  // out.println("salaryint is "+salaryint);
        			   if(salaryint==0.5||salaryint==-0.5){
	          				  // System.out.println("condition works in if salaryint");
	          				 salaryint=1;
	          			   }
        			   upsalaryamount=(int)salaryint+binarysalryamount;
          			 checkingsubvec.add(upsalaryamount);
   	                }
          	      else{
          	    	 float row=-0.5f;
        			   float salaryint =floatsalryamount%row;
        			  // out.println("salaryint is "+salaryint);
        			   if(salaryint==0.5||salaryint==-0.5){
	          				  // System.out.println("condition works in if salaryint");
	          				 salaryint=1;
	          			   }
        			   upsalaryamount=(int)salaryint+binarysalryamount;
		          		  checkingsubvec.add(upsalaryamount);
          		       }
        		 }
    		 if (binarycount+9 < binary.length()) { 
				 String otherexpenses=st.nextToken();
				 float floatotherexpenses = Float.parseFloat(otherexpenses);
				 int intotherexpenses = Float.floatToIntBits(floatotherexpenses);
		         String binaryotherexpenses = Integer.toBinaryString(intotherexpenses);
		      
		         String temp9=binary.substring(binarycount+9,binarycount+10);
				 if(temp9.equals("1"))
   	                {

					 float row=1.5f;
          			  float otherexpensesint =floatotherexpenses%row;
          			 if(otherexpensesint==0.5||otherexpensesint==-0.5){
          				 //  System.out.println("condition works in if otherexpensesint");
          				 otherexpensesint=1;
          			   }
          			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
          			 checkingsubvec.add(upotherexpenses);
   	                }
          	      else{
          	    	 float row=-0.5f;
         			  float otherexpensesint =floatotherexpenses%row;
         			 if(otherexpensesint==0.5||otherexpensesint==-0.5){
          				 //  System.out.println("condition works in if otherexpensesint");
          				 otherexpensesint=1;
          			   }
         			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
		          			 checkingsubvec.add(upotherexpenses);
          		       }
        		 }
				 
    		 if (binarycount+10 < binary.length()) { 
                 String annualto=st.nextToken();
                 float floatannualto = Float.parseFloat(annualto);
 			  	 int intannualto = Float.floatToIntBits(floatannualto);
 				 String binaryannualto = Integer.toBinaryString(intannualto);
 				
 				 String temp10=binary.substring(binarycount+10,binarycount+11);
				 if(temp10.equals("1"))
   	                {

					 float row=1.5f;
          			   float annualturnint =floatannualto%row;
          			 if(annualturnint==0.5||annualturnint==-0.5){
         				  // System.out.println("condition works in if annualturnint");
         				 annualturnint=1;
         			   }
          			   upannualturn=(int)annualturnint+binaryannualto;
          			 checkingsubvec.add(upannualturn);
   	                }
          	      else{
          	    	float row=-0.5f;
       			   float annualturnint =floatannualto%row;
       			if(annualturnint==0.5||annualturnint==-0.5){
    				  // System.out.println("condition works in if annualturnint");
    				 annualturnint=1;
    			   }
       			   upannualturn=(int)annualturnint+binaryannualto;
		          		  checkingsubvec.add(upannualturn);
          		       }
        		 }
                 
    		 if (binarycount+11 < binary.length()) { 
                 String profitloss=st.nextToken();
 					float floatprofitloss = Float.parseFloat(profitloss);
 					// out.println("float rental is "+floatrent);
 					int intprofitloss = Float.floatToIntBits(floatprofitloss);
 					binaryprofitloss = Integer.toBinaryString(intprofitloss);
 					
 				
 					String temp11=binary.substring(binarycount+11,binarycount+12);
					 if(temp11.equals("1"))
	   	                {
						 float row=1.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in if profitlossint");
	          				 profitlossint=1;
	          			   }
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
	          			 if(upprofitloss.contains("-")){
	   						 // System.out.println("upprofit before is "+upprofitloss);
	   						upprofitglob=upprofitloss.replace("-","").trim();
	   						 //System.out.println("upprofit after is "+upprofitglob);
	   					      }
	   					  else{
	   						upprofitglob=upprofitloss;
	   					  }
	          			 checkingsubvec.add(upprofitglob);
	   	                }
	          	      else{
	          	    	float row=-0.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in if profitlossint");
	          				 profitlossint=1;
	          			   }
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
	          			 if(upprofitloss.contains("-")){
	   						 // System.out.println("upprofit before is "+upprofitloss);
	   						upprofitglob=upprofitloss.replace("-","").trim();
	   						 //System.out.println("upprofit after is "+upprofitglob);
	   					      }
	   					  else{
	   						upprofitglob=upprofitloss;
	   					  }
	    	          			checkingsubvec.add(upprofitglob);
	          		       }
    		 }
    		  
    		 if(binarycount< binary.length()){
    		 checkingvec.add(checkingsubvec);
    		 binarycount=binarycount+12;
    		 }
    		 else{
    			// binarycount=0;
    			 //System.out.println("break broken");
    			 break;
    		 }
        }
        if(binarycount< binary.length()){
        
       //System.out.println("\n condition works satisfied binary count "+binarycount+"string length"+binary.length());
        }
        else{
        	binarycount=0;
        	//System.out.println("binary count value is "+binarycount);
        	break;
        }
		  }
		else{
			binarycount=0;
			break;
		}
	}
	 ///////////////////////////// ///////////////////
	        }
	        if(extract1){

	 try{
		                      
				System.out.println(" SECOND connection checking condition exe");
				System.out.println("count value is "+count);
				selectedtuplewatermarking=tupleseselection.selectedtupelwatermarkingvectorpartition;
					 for(int k1=0;k1<selectedtuplewatermarking.size();k1++){
						// System.out.println("for loop works"+checkingcount);
						 if (checkingcount < binary.length()) {
							 //System.out.println("if condition satis count value is "+count);
						 if(count==20){        			
        					 break;        					 
        				 }        				  
					 Vector selectedtupevec=(Vector)selectedtuplewatermarking.get(k1);
					 for(int l=0;l<selectedtupevec.size();l++){		
						 if (checkingcount < binary.length()) {
						 if(count==20){        			
        					 break;
        				 }        				  
						 count=0;
						 String pri=(String)selectedtupevec.get(l);
						 int primarykey=Integer.parseInt(pri);
						 String binaryprimarykey=Integer.toBinaryString(primarykey);					
				        String sql1="select * from binarydb where SNO="+binaryprimarykey;
				        ResultSet rs = stmt.executeQuery(sql1);
        		  while(rs.next())
    	          {
        			  
        			  if(count==12){
    				break;
    			}
    	     	 if(count==20){
				    
					 break;
				 }
				  
        			  if (checkingcount < binary.length()) {
        			  for(k=k+0;k<checkingvec.size();k++){
        				 // System.out.println("second for2 loop works");
        				  if(checkingcount < binary.length()){
        				 if(count==20){
        					 break;
        				       }        				  
        				  if(count==12){        	
        					  k=k;
              				  break;
              			         }        				 
                		  Vector userattrubutevec=checkingvec.get(k); 
        		    for(int j=0;j<userattrubutevec.size();j++){ 
        		    	//System.out.println("checking for loop work");
        			 if (checkingcount+j < binary.length()) {
        			  String userattribut=(String)userattrubutevec.get(j);
        			  String adminattrubut=rs.getString(j+2);
        			  if(userattribut.trim().equals(adminattrubut.trim())){
        			//  System.out.println(" condition true " +j+" value of userattribute is "+userattribut+"admin attrbure"+adminattrubut+"<br/>");
        			  }
        			  else{
        			  System.out.println("condition false " +j+" value of userattribute is "+userattribut+"admin attrbure"+adminattrubut+"<br/>");
        				count=20;
        				checkingcount=0;
        				failure=true;
        				sucesscontinue=false;
        				 break;
        			  }
        			  }
        			  else{
        				  break;
        			  }
        			count++;
        			if(count>12){
        				
        				break;
        			}
        			 
        		         } //fourth for loop
        		    checkingcount=checkingcount+12;
        				  }
        				  else{
        					  break;
        				    }
                			  
        		  }//third for loop close
        			 
				
    	          }//////////////
        			  else{
        				  break;
        			  }
					 }///////////while loop close
				 
						  }//////////////
	        			  else{
	        				 // System.out.println("second for loop break ");
	        				break;
	        			  } 
						 
						 
						 }//second for loop close
						 }
						 else{
							 System.out.println("\n sucess is working");
	        				  sucess=true;
	        				  break;
						 }
				 
	   }//first for loop close
        
          }
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		/////////////////////////////////////////////////////////////////////////////////
		
	        }
	       
	       
    if(str1.equals("")){
    	sucess=false;
    	failure=true;
    }
		
		
		if(sucess){
			try{
				sucess=false;
				sucesscontinue=true;
				checkingcount=0;
				checkingcount1=0;
			 System.out.println("\n SUCESS flow works");
			
			   Vector temp=new Vector();
			 for(int k1=0;k1<selectedtuplewatermarking.size();k1++){
				 Vector selectedtupevec=(Vector)selectedtuplewatermarking.get(k1);
				 for(int l=0;l<selectedtupevec.size();l++){
			 String pri=(String)selectedtupevec.get(l);
			 int primarykey=Integer.parseInt(pri);
			 String binaryprimarykey=Integer.toBinaryString(primarykey);
			 String sql1="select * from binarydb where SNO="+binaryprimarykey;
			 ResultSet rs = stmt.executeQuery(sql1);
			   while(rs.next()){
				 if(checkingcount1<binary.length()){
					 if(checkingcount1<binary.length()){
				    String year = rs.getString("YEAR");
				    buf1 = new StringBuffer(year);
				    buf1.replace(0, 1, "").trimToSize();
				    int decimal1 = Integer.parseInt(buf1.toString(), 2);
					Statement stmtt = connection.createStatement();
	 	            String sqlquery="UPDATE binarydb SET YEAR='"+buf1+"' where SNO='"+binaryprimarykey+"'";
	                stmtt.executeUpdate(sqlquery);
					 }
					 if(checkingcount1+1<binary.length()){
				   String activeemp = rs.getString("STAFF");
				   buf2 = new StringBuffer(activeemp);
				   buf2.replace(0, 1, "").trimToSize();
				   int decimal2 = Integer.parseInt(buf2.toString(), 2);
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET STAFF='"+buf2+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery); 
					 }
					 if(checkingcount1+2<binary.length()){
				   String benchmarkemp=rs.getString("VECHICLE");
				   buf3 = new StringBuffer(benchmarkemp);
				   buf3.replace(0, 1, "").trimToSize();
				   int decimal3 = Integer.parseInt(buf3.toString(), 2);
				   Statement stmtt = connection.createStatement();
    	           String sqlquery="UPDATE binarydb SET VECHICLE='"+buf3+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
					 }
					 if(checkingcount1+3<binary.length()){
				    String totemp=rs.getString("MATERIAL");
				    buf4 = new StringBuffer(totemp);
				    buf4.replace(0, 1, "").trimToSize();
				    int decimal4 = Integer.parseInt(buf4.toString(), 2);
				    Statement stmtt = connection.createStatement();
   	                String sqlquery="UPDATE binarydb SET MATERIAL='"+buf4+"' where SNO='"+binaryprimarykey+"'";
                    stmtt.executeUpdate(sqlquery);
					 }                 
					 
					 if(checkingcount1+4<binary.length()){
				   String projectcount=rs.getString("DAMAGE");
				   buf5 = new StringBuffer(projectcount);
				   buf5.replace(0, 1, "").trimToSize();
				   int decimal5 = Integer.parseInt(buf5.toString(), 2);
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET DAMAGE='"+buf5+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
					 }
					 if(checkingcount1+5<binary.length()){
				   String tieupclients=rs.getString("CUSTOMER");
				   buf6 = new StringBuffer(tieupclients);
				   buf6.replace(0, 1, "").trimToSize();
				   int decimal6 = Integer.parseInt(buf6.toString(), 2);
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET CUSTOMER='"+buf6+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
					 }
					 if(checkingcount1+6<binary.length()){
				   String brances=rs.getString("BRANCHES");
				   buf7 = new StringBuffer(brances);
				   buf7.replace(0, 1, "").trimToSize();
				   int decimal7 = Integer.parseInt(buf7.toString(), 2);
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET  BRANCHES='"+buf7+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
				   //brances=brances.replace(brances.substring(0,1),"").trim();
					 }
					 if(checkingcount1+7<binary.length()){
				   String rentalexp=rs.getString("RENTALEXPENSES");
				    buf8 = new StringBuffer(rentalexp);
				   buf8.replace(0, 1, "").trimToSize();
				   int intBits1 = Integer.parseInt(buf8.toString(), 2);
				   float decimal8 = Float.intBitsToFloat(intBits1);
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET RENTALEXPENSES='"+buf8+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
					 }
				
					 if(checkingcount1+8<binary.length()){
				   String salryamount=rs.getString("SALARYAMOUNT_PA");
				    buf9 = new StringBuffer(salryamount);
				   buf9.replace(0, 1, "").trimToSize();
				   int intBits2 = Integer.parseInt(buf9.toString(), 2);
				   float decimal9 = Float.intBitsToFloat(intBits2);				   
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET SALARYAMOUNT_PA='"+buf9+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);				  
					 }
				   
					 if(checkingcount1+9<binary.length()){
				   String otherexpenses=rs.getString("OTHER_EXPENSES_PA");	
				   buf10 = new StringBuffer(otherexpenses);
				   buf10.replace(0, 1, "").trimToSize();
				   int intBits3 = Integer.parseInt(buf10.toString(), 2);
				   float decimall0 = Float.intBitsToFloat(intBits3);				   
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET OTHER_EXPENSES_PA='"+buf10+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);				  
					 }
					 
					 if(checkingcount1+10<binary.length()){
				   String annualto=rs.getString("ANNUALTURNOVER");
				   buf11 = new StringBuffer(annualto);
				   buf11.replace(0, 1, "").trimToSize();
				   int intBits4 = Integer.parseInt(buf11.toString(), 2);
				   float decimal11 = Float.intBitsToFloat(intBits4);				   
				   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET ANNUALTURNOVER='"+buf11+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
					 }
					 
					 if(checkingcount1+11<binary.length()){
				   String profitloss=rs.getString("PROFITLOSS");			
				   //System.out.println("profit loss before is "+profitloss);
				    buf12 = new StringBuffer(profitloss);
				   buf12.replace(0, 1, "").trimToSize();
				 //  System.out.println("profit loss after is "+buf12);
				   Statement stmtt = connection.createStatement();
   	              String sqlquery="UPDATE binarydb SET PROFITLOSS='"+buf12+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);					 
					 }
					 checkingcount1=checkingcount1+12;
				
			   }	   
			   }//while loop close
			 
				 }
			 
			 }
			 
			   
			}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		}
		////////////////////////////////////////////////////////////
		if(sucesscontinue){
			sucesscontinue=false;
			pageredirect=true;
		 try{
        	 System.out.println(" third connection succesfully exe");
        	
        	String sql="select * from binarydb";
        	 ResultSet rs =  stmt.executeQuery(sql);
             Vector tempp;
             while(rs.next())
             {
            	 tempp = new Vector();
                 for(int i = 1; i <= 13; i++){
                    //   tempp.add(rs.getString(i));
                	if(i<=8){
                		 //System.out.println("i value is if "+i);
                		 int decimal = Integer.parseInt(rs.getString(i), 2);
                		 tempp.add(decimal);
                	 }
                	 else{
                		// System.out.println("i value is else "+i);
					long b = Long.parseLong(rs.getString(i), 2);
					int intBits5 = (int) b;
					decodefloat = Float.intBitsToFloat(intBits5);
					tempp.add(decodefloat);
                	 }
                 	
                     }
                 list.add(tempp);
             }
             
             }
	  
		catch(Exception e){
			e.printStackTrace();
			
		}}
		
		if(pageredirect){
    pageredirect=false;
    compare=true;
   String splittedstring1[]=usertestingstring.split("####");
	  //	System.out.println("=========> "+splittedstring.length);
	
	//System.out.println("condition enter to pageredirect binarycount is "+binarycount);
	for(int k=0;k<splittedstring.length;k++)
	{
		
		
		if (binarycount < binary.length()) {
		String element=splittedstring[k];
		//out.println("Element in "+k+" position is "+element+"<br/>");
		StringTokenizer st = new StringTokenizer(element, "*");
      while (st.hasMoreElements()) {
      	       if (binarycount < binary.length()) {	
      	    	  String sno1=st.nextToken();
      	    	  int intsno = Integer.parseInt(sno1);
      	    	binaryprimarykey = Integer.toBinaryString(intsno);
      	    	
      	    	
      	    	String year=st.nextToken();
              	int intyear = Integer.parseInt(year);
  		         String binaryyear = Integer.toBinaryString(intyear);
                 
                 String temp=binary.substring(binarycount,binarycount+1);
        		   if(temp.equals("1"))
 	                {
        		   float row=1.5f;
      			   float yearint =Integer.parseInt(year)%row;
      			 if(yearint==0.5||yearint==-0.5){
    				   //System.out.println("condition works in year");
    				   yearint=1;
    			   }
      			   upbinaryyear=(int)yearint+binaryyear;
 	                        }
        		   else{
        		   float row=-0.5f;
    			   float yearint =Integer.parseInt(year)%row;
    			   if(yearint==0.5||yearint==-0.5){
      				   //System.out.println("condition works in year");
      				   yearint=1;
      			   }
    			   upbinaryyear=(int)yearint+binaryyear;
        		   }
      	 
        		   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET YEAR='"+upbinaryyear+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery); 
      	       
      	       
      	       }
        
      	 
      	 if (binarycount+1 < binary.length()) {	
					String activeemp = st.nextToken();
					int intactiveemp = Integer.parseInt(activeemp);
				    String binaryactiveemp = Integer.toBinaryString(intactiveemp);
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
	          			 //checkingsubvec.add(upactiveemp);
	          			  //out.println("upactiveemp if "+upactiveemp);
	   	                        }
	          		   else{
	          			 float row=-0.5f;
	          			 float activeempint =Integer.parseInt(activeemp)%row;
	          			if(activeempint==0.5||activeempint==-0.5){
	          				   //System.out.println("condition works in if activeemployess");
	          				 activeempint=1;
	          			   }
	          			 upactiveemp=(int)activeempint+binaryactiveemp;
	          			  //out.println("upactiveemp else "+upactiveemp);
	          			 //checkingsubvec.add(upactiveemp);
	          		   }
	          		  Statement stmtt = connection.createStatement();
     	              String sqlquery="UPDATE binarydb SET STAFF='"+upactiveemp+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
       		 }
     		     
      	   
  		 if (binarycount+2 < binary.length()) {
  			 
           String benchmarkemp=st.nextToken();
           int intbenchmarkemp=Integer.parseInt(benchmarkemp);
           String binarybenchmarkemp=Integer.toBinaryString(intbenchmarkemp);
          
           String temp2=binary.substring(binarycount+2,binarycount+3);
    		   if(temp2.equals("1"))
	                {
    			  float row=1.5f;
   			   float benchint =Integer.parseInt(benchmarkemp)%row;
   			 if(benchint==0.5||benchint==-0.5){
 				  // System.out.println("condition works in if VECHICLE");
 				    benchint=1;
 			   }
   			   upbenchmark=(int)benchint+binarybenchmarkemp;
    			// checkingsubvec.add(upbenchmark);
	                        }
    		   else{

      			 float row=-0.5f;
      			   float benchint =Integer.parseInt(benchmarkemp)%row;
      			 if(benchint==0.5||benchint==-0.5){
     				  // System.out.println("condition works in if VECHICLE");
     				    benchint=1;
     			   }
      			   upbenchmark=(int)benchint+binarybenchmarkemp;
    			 //checkingsubvec.add(upbenchmark);
    		   }
    		   Statement stmtt = connection.createStatement();
	             String sqlquery="UPDATE binarydb SET VECHICLE='"+upbenchmark+"' where SNO='"+binaryprimarykey+"'";
                stmtt.executeUpdate(sqlquery);
           
  		 }
           
        
  		 if (binarycount+3 < binary.length()) {
               String totemp=st.nextToken();
               int inttotemp = Integer.parseInt(totemp);
				 String binarytotemp = Integer.toBinaryString(inttotemp);
				
                
				 String temp3=binary.substring(binarycount+3,binarycount+4);
        		   if(temp3.equals("1"))
 	                {
        			 float row=1.5f;
      			   float totint =Integer.parseInt(totemp)%row;
      			 if(totint==0.5||totint==-0.5){
     				  // System.out.println("condition works in if totint");
     				 totint=1;
     			   }
      			   uptotemp=(int)totint+binarytotemp;
        			 //checkingsubvec.add(uptotemp);
 	                        }
        		   else{
        			  float row=-0.5f;
       			   float totint =Integer.parseInt(totemp)%row;
       			 if(totint==0.5||totint==-0.5){
     				  // System.out.println("condition works in if totint");
     				 totint=1;
     			   }
       			   uptotemp=(int)totint+binarytotemp;
					// checkingsubvec.add(uptotemp);
        		   }
        		   Statement stmtt = connection.createStatement();
   	               String sqlquery="UPDATE binarydb SET MATERIAL='"+uptotemp+"' where SNO='"+binaryprimarykey+"'";
                   stmtt.executeUpdate(sqlquery);
      		 }
        
      
       
  		 if (binarycount+4 < binary.length()) { 
	          		String projectcount=st.nextToken();
	          		int intprojectcount = Integer.parseInt(projectcount);
					String binaryprojectcount = Integer.toBinaryString(intprojectcount);
					
                    
                
					String temp4=binary.substring(binarycount+4,binarycount+5);
	          		   
					if(temp4.equals("1"))
	   	                {
						   float row=1.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				  // System.out.println("condition works in if projcountint");
	          				 projcountint=1;
	          			   }
	          			    upprocount=(int)projcountint+binaryprojectcount;
	          			  //checkingsubvec.add(upprocount);
	   	                        }
	          		   else{
	          			  float row=-0.5f;
	          			    float projcountint =Integer.parseInt(projectcount)%row;
	          			  if(projcountint==0.5||projcountint==-0.5){
	          				  // System.out.println("condition works in if projcountint");
	          				 projcountint=1;
	          			   }
	          			    upprocount=(int)projcountint+binaryprojectcount;
			          			 // checkingsubvec.add(upprocount);
	          		   }
					  Statement stmtt = connection.createStatement();
      	              String sqlquery="UPDATE binarydb SET DAMAGE='"+upprocount+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
       		 }
       
  		 
  		 
  		 if (binarycount+5 < binary.length()) { 
           String tieupclients=st.nextToken();
           int inttieupclients = Integer.parseInt(tieupclients);
				 String binarytieupclients = Integer.toBinaryString(inttieupclients);
				
				 String temp5=binary.substring(binarycount+5,binarycount+6);
    		   
			 if(temp5.equals("1"))
	                {
				  float row=1.5f;
   			   float tieupclientsint =Integer.parseInt(tieupclients)%row;
   			 if(tieupclientsint==0.5||tieupclientsint==-0.5){
 				  // System.out.println("condition works in if tieupclientsint");
 				 tieupclientsint=1;
 			   }
 			   
   			   uptieupcients=(int)tieupclientsint+binarytieupclients;
    			  //checkingsubvec.add(uptieupcients);
	                        }
    		    else{
    		    	float row=-0.5f;
      			  float tieupclientsint =Integer.parseInt(tieupclients)%row;
      			 if(tieupclientsint==0.5||tieupclientsint==-0.5){
     				  // System.out.println("condition works in if tieupclientsint");
     				 tieupclientsint=1;
     			   }
     			   
      			  uptieupcients=(int)tieupclientsint+binarytieupclients;
	          			  //checkingsubvec.add(uptieupcients);
    		           }
			     Statement stmtt = connection.createStatement();
	              String sqlquery="UPDATE binarydb SET CUSTOMER='"+uptieupcients+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery);
  		 }
  		 
  		 
  		 if (binarycount+6 < binary.length()) { 
               String brances=st.nextToken();
               int intbrances = Integer.parseInt(brances);
				 String binarybrances = Integer.toBinaryString(intbrances);
				
			 	 String temp6=binary.substring(binarycount+6,binarycount+7);
        		   
				 if(temp6.equals("1"))
 	                {

					 float row=1.5f;
        			   float brancesint =Integer.parseInt(brances)%row;
        			   if(brancesint==0.5||brancesint==-0.5){
          				   //System.out.println("condition works in if brancesint");
          				 brancesint=1;
          			   }
        			   upbranches=(int)brancesint+binarybrances;
        			  //checkingsubvec.add(upbranches);
 	                }
        	      else{
        	    	 float row=-0.5f;
      			   float brancesint =Integer.parseInt(brances)%row;
      			 if(brancesint==0.5||brancesint==-0.5){
    				   //System.out.println("condition works in if brancesint");
    				 brancesint=1;
    			   }
      			   upbranches=(int)brancesint+binarybrances;
							 //checkingsubvec.add(upbranches);
        		       }
				 
				 Statement stmtt = connection.createStatement();
 	              String sqlquery="UPDATE binarydb SET  BRANCHES='"+upbranches+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery);
      		 }
				 
  		 
  		 if (binarycount+7 < binary.length()) { 
				 String rentalexp=st.nextToken();
				 float floatrent = Float.parseFloat(rentalexp);
			 int intrent = Float.floatToIntBits(floatrent);
			 String binaryrent = Integer.toBinaryString(intrent);
		
			 String temp7=binary.substring(binarycount+7,binarycount+8);
			 if(temp7.equals("1"))
	                {
				    float row=1.5f;
     			   float rentalint =floatrent%row;
     			  if(rentalint==0.5||rentalint==-0.5){
     				   //System.out.println("condition works in if rentalint");
     				 rentalint=1;
     			   }
     			   uprentalexp=(int)rentalint+binaryrent;
  			// System.out.println("\n rental if "+rentalint);
    			   //checkingsubvec.add(uprentalexp);
	                }
    	      else{

	    	        float row=-0.5f;
			        float rentalint =floatrent%row;
			        if(rentalint==0.5||rentalint==-0.5){
       				   //System.out.println("condition works in if rentalint");
       				 rentalint=1;
       			   }
      			     uprentalexp=(int)rentalint+binaryrent;
 			             //System.out.println("\n rental if "+rentalint);
	          			//checkingsubvec.add(uprentalexp);
	          			
    		       }
			 
			     Statement stmtt = connection.createStatement();
	              String sqlquery="UPDATE binarydb SET RENTALEXPENSES='"+uprentalexp+"' where SNO='"+binaryprimarykey+"'";
                  stmtt.executeUpdate(sqlquery);
  		 }
      
  		 if (binarycount+8 < binary.length()) { 
               String salryamount=st.nextToken();
				 float floatsalryamount = Float.parseFloat(salryamount);
				 int intsalryamount = Float.floatToIntBits(floatsalryamount);
				 String binarysalryamount = Integer.toBinaryString(intsalryamount);
				 
				 String temp8=binary.substring(binarycount+8,binarycount+9);
				 if(temp8.equals("1"))
 	                {

					   float row=1.5f;
      			   float salaryint =floatsalryamount%row;
      			 if(salaryint==0.5||salaryint==-0.5){
     				  // System.out.println("condition works in if salaryint");
     				 salaryint=1;
     			   }
      			  // out.println("salaryint is "+salaryint);
      			   upsalaryamount=(int)salaryint+binarysalryamount;
        			 //checkingsubvec.add(upsalaryamount);
 	                }
        	      else{
        	    	 float row=-0.5f;
      			   float salaryint =floatsalryamount%row;
      			 if(salaryint==0.5||salaryint==-0.5){
     				  // System.out.println("condition works in if salaryint");
     				 salaryint=1;
     			   }
      			   upsalaryamount=(int)salaryint+binarysalryamount;
        		       }
				 
				 Statement stmtt = connection.createStatement();
 	              String sqlquery="UPDATE binarydb SET SALARYAMOUNT_PA='"+upsalaryamount+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery);
      		 }
  		 if (binarycount+9 < binary.length()) { 
				 String otherexpenses=st.nextToken();
				 float floatotherexpenses = Float.parseFloat(otherexpenses);
				 int intotherexpenses = Float.floatToIntBits(floatotherexpenses);
		         String binaryotherexpenses = Integer.toBinaryString(intotherexpenses);
		      
		         String temp9=binary.substring(binarycount+9,binarycount+10);
				 if(temp9.equals("1"))
 	                {

					 float row=1.5f;
        			  float otherexpensesint =floatotherexpenses%row;
        			  if(otherexpensesint==0.5||otherexpensesint==-0.5){
	          				 //  System.out.println("condition works in if otherexpensesint");
	          				 otherexpensesint=1;
	          			   }
        			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
        			// checkingsubvec.add(upotherexpenses);
 	                }
        	      else{
        	    	 float row=-0.5f;
       			  float otherexpensesint =floatotherexpenses%row;
       			 if(otherexpensesint==0.5||otherexpensesint==-0.5){
      				 //  System.out.println("condition works in if otherexpensesint");
      				 otherexpensesint=1;
      			   }
       			  upotherexpenses=(int)otherexpensesint+binaryotherexpenses;
		          			 //checkingsubvec.add(upotherexpenses);
        		       }
				 
				 Statement stmtt = connection.createStatement();
 	              String sqlquery="UPDATE binarydb SET OTHER_EXPENSES_PA='"+upotherexpenses+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery);
      		 }
				 
  		 if (binarycount+10 < binary.length()) { 
               String annualto=st.nextToken();
               float floatannualto = Float.parseFloat(annualto);
			  	 int intannualto = Float.floatToIntBits(floatannualto);
				 String binaryannualto = Integer.toBinaryString(intannualto);
				
				 String temp10=binary.substring(binarycount+10,binarycount+11);
				 if(temp10.equals("1"))
 	                {

					 float row=1.5f;
        			   float annualturnint =floatannualto%row;
        			   if(annualturnint==0.5||annualturnint==-0.5){
	          				  // System.out.println("condition works in if annualturnint");
	          				 annualturnint=1;
	          			   }
        			   upannualturn=(int)annualturnint+binaryannualto;
        			// checkingsubvec.add(upannualturn);
 	                }
        	      else{
        	    	float row=-0.5f;
     			   float annualturnint =floatannualto%row;
     			  if(annualturnint==0.5||annualturnint==-0.5){
      				  // System.out.println("condition works in if annualturnint");
      				 annualturnint=1;
      			   }
     			   upannualturn=(int)annualturnint+binaryannualto;
		          		  //checkingsubvec.add(upannualturn);
        		       }
				 Statement stmtt = connection.createStatement();
 	              String sqlquery="UPDATE binarydb SET ANNUALTURNOVER='"+upannualturn+"' where SNO='"+binaryprimarykey+"'";
                 stmtt.executeUpdate(sqlquery);
      		 }
               
  		 if (binarycount+11 < binary.length()) { 
               String profitloss=st.nextToken();
            
               

					float floatprofitloss = Float.parseFloat(profitloss);
					// out.println("float rental is "+floatrent);
					int intprofitloss = Float.floatToIntBits(floatprofitloss);
					binaryprofitloss = Integer.toBinaryString(intprofitloss);
					
				
					String temp11=binary.substring(binarycount+11,binarycount+12);
					 if(temp11.equals("1"))
	   	                {
						 float row=1.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in if profitlossint");
	          				 profitlossint=1;
	          			   }
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
	          			// checkingsubvec.add(upprofitloss);
	   	                }
	          	      else{
	          	    	float row=-0.5f;
	          			   float profitlossint =floatprofitloss%row;
	          			 if(profitlossint==0.5||profitlossint==-0.5){
	          				  // System.out.println("condition works in if profitlossint");
	          				 profitlossint=1;
	          			   }
	          			   upprofitloss=(int)profitlossint+binaryprofitloss;
	    	          			//checkingsubvec.add(upprofitloss);
	          		       }
					 
					 if(upprofitloss.contains("-")){
   						 // System.out.println("upprofit before is "+upprofitloss);
   						upprofitglob=upprofitloss.replace("-","").trim();
   						 //System.out.println("upprofit after is "+upprofitglob);
   					      }
   					  else{
   						upprofitglob=upprofitloss;
   					  }
					 
					 
					  Statement stmtt = connection.createStatement();
     	              String sqlquery="UPDATE binarydb SET PROFITLOSS='"+upprofitglob+"' where SNO='"+binaryprimarykey+"'";
                      stmtt.executeUpdate(sqlquery);
				//}
  		 }
  		  
  		 if(binarycount< binary.length()){
  			  binarycount=binarycount+12;
  		 }
  		 else{
  			 
  			 //System.out.println("break broken");
  			 break;
  		 }
  		
          
           
      }
      //System.out.println("\n condition works satisfied binary count "+binarycount+"string length"+binary.length());
		  }
		else{
			//System.out.println("loop break binarycount  "+binarycount);
			break;
		}
	}
    
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	     checkingvec.removeAllElements();
		 //System.out.println("condition workds");
	    if(compare){
	    	compare=false;
		 request.setAttribute("PARTITION", "Content has been Decoded");
		 request.setAttribute("list", list);
		 list=new Vector<Vector>();
		 RequestDispatcher rd = request.getRequestDispatcher("registersuccess.jsp");
		   rd.forward(request, response);
	    }
	    else{
	    	failure=true;
	    }
		}
		if(failure){
			
			list=new Vector<Vector>();
			failure=false;
			checkingcount=0;
			count=0;
			checkingvec.removeAllElements();
			String as="UNAUTHORISED USER OWNERSHIP NOT VALID";
			String as1="ENCODED NOT DONE BY ADMIN";
			if(usertestingstring.equals("")){
			request.setAttribute("PARTITION",as1);
		            }
			else{
				request.setAttribute("PARTITION",as);
			}
			RequestDispatcher rd = request.getRequestDispatcher("registersuccess.jsp");
			rd.forward(request, response);
		}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		
	  
	}
	
}
