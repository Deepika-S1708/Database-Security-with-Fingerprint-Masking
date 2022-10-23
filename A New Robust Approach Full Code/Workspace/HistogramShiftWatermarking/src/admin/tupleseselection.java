package admin;

import hashfuction.Md5hashfunction;

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




public class tupleseselection extends HttpServlet {
 	Connection connection ;
 	int by=0;
 	int vecount=0;
 	Statement stmt ;
 	String ks="1as";   //secret key
	Md5hashfunction md=new Md5hashfunction();
	Vector partitiongroupPKVEC;//=new Vector();
	Vector Thresoldvaluegroupvec;
	
	Vector <Vector>selectedtupelvectorpartition=new Vector<Vector>();
	Vector <Vector>rejectedtupelvectorpartition=new Vector<Vector>();
	
	
	public static Vector <Vector>selectedtupelwatermarkingvectorpartition=new Vector<Vector>();
	Vector <Vector>rejectedtupelwatermarkingvectorpartition=new Vector<Vector>();
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			 
        	 connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 System.out.println("connection exe");
        	 
        	 partitiongroupPKVEC=datasetwatermark.partitiongroupprimarykeyvector;
        	 Thresoldvaluegroupvec=datasetwatermark.PartitiongroupThresolsve;
        	 //out.println("part size is "+partitiongroupPKVEC.size());
        	 selectedtupelvectorpartition=new Vector<Vector>();
        	 rejectedtupelvectorpartition=new Vector<Vector>();
        	 for(int i=0;i<partitiongroupPKVEC.size();i++)
        	 {
        		
        		 Vector selectedtuplesvector=new Vector();
        		 Vector rejectedtuplesvector=new Vector();
        		 Vector subpartition=new Vector();
        		 subpartition=(Vector)partitiongroupPKVEC.get(i);
        		 
        		 Vector subpartitionThresoldvalue=new Vector();
        		 subpartitionThresoldvalue=(Vector)Thresoldvaluegroupvec.get(i);
        		
        		 
        		 for(int j=0;j<subpartition.size();j++)
        		 {
        			 String sql1="select * from infotechdb where SNO="+subpartition.get(j);
                	 ResultSet rs =  stmt.executeQuery(sql1);	 
                	 
                	 while(rs.next())
                     {
              		     String year=rs.getString("YEAR");
                         String activeemp=rs.getString("STAFF");
                         String benchmarkemp=rs.getString("VECHICLE");
                         String totemp=rs.getString("MATERIAL");
                         String projectcount=rs.getString("DAMAGE");
                         String tieupclients=rs.getString("CUSTOMER");
                         String brances=rs.getString("BRANCHES");
                         String rentalexp=rs.getString("RENTALEXPENSES");
                         String salryamount=rs.getString("SALARYAMOUNT_PA");
                         String otherexpenses=rs.getString("OTHER_EXPENSES_PA");
                         String annualto=rs.getString("ANNUALTURNOVER");
                         String profitloss=rs.getString("PROFIT/LOSS");
                         
                         
                         
                         // out.println("year is "+Double.valueOf(activeemp));
                         //out.println("first elemnt is "+subpartitionThresoldvalue.get(1));
                      
                         
                         if(Double.valueOf(year)>(Double) subpartitionThresoldvalue.get(0)){
                        	 
                        	 //System.out.println("condition true");
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else if(Double.valueOf(activeemp)>(Double) subpartitionThresoldvalue.get(1)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else if(Double.valueOf(benchmarkemp)>(Double) subpartitionThresoldvalue.get(2)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else if(Double.valueOf(totemp)>(Double) subpartitionThresoldvalue.get(3)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else  if(Double.valueOf(projectcount)>(Double) subpartitionThresoldvalue.get(4)){
                        	 selectedtuplesvector.add(subpartition.get(j));
                        	 
                         }
                         
                         else if(Double.valueOf(tieupclients)>(Double) subpartitionThresoldvalue.get(5)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else if(Double.valueOf(brances)>(Double) subpartitionThresoldvalue.get(6)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else  if(Double.valueOf(rentalexp)>(Double) subpartitionThresoldvalue.get(7)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         
                         else  if(Double.valueOf(salryamount)>(Double) subpartitionThresoldvalue.get(8)){
                        	 selectedtuplesvector.add(subpartition.get(j));
                        	 
                         }
                         
                         else if(Double.valueOf(otherexpenses)>(Double) subpartitionThresoldvalue.get(9)){
                        	 selectedtuplesvector.add(subpartition.get(j));
                        	 
                         }
                         else if(Double.valueOf(annualto)>(Double) subpartitionThresoldvalue.get(10)){
                        	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                         }
                         else if(Double.valueOf(profitloss)>(Double) subpartitionThresoldvalue.get(11)){
                      	 
                        	 selectedtuplesvector.add(subpartition.get(j));
                       }
                         else{
                         rejectedtuplesvector.add(subpartition.get(j));
                         }
                     }
        			 
                	 
        		 }
        		 
        		// out.println("group separated at  "+i);
        		 selectedtupelvectorpartition.add(selectedtuplesvector);
        		 rejectedtupelvectorpartition.add(rejectedtuplesvector);
        		
        		
        	 }
        
        //	out.println("selectedtupelvectorpartition vector size   is "+selectedtupelvectorpartition.size());
        	
        	 
        		
        		
        		selectedtupelwatermarkingvectorpartition=new Vector<Vector>();
        	     rejectedtupelwatermarkingvectorpartition=new Vector<Vector>();
        		
        	
        	//select tuple for watermarking
        	for(int a=0;a<selectedtupelvectorpartition.size();a++){
        		Vector selectedtuplewatermarking=new Vector();
        		 Vector Notselectedtuplewatermarking=new Vector();
        			
        		Vector selectedtuple=new Vector();
        		selectedtuple=selectedtupelvectorpartition.get(a);
        		
        		for(int b=0;b<selectedtuple.size();b++){
        			
        		    String pk=(String)selectedtuple.get(b);
        			String hashfun=md.MD5(ks+pk);
                    BigInteger bi = new BigInteger(hashfun, 16);
                    BigInteger Even_Value=bi.mod(new BigInteger("2"));
                    
                  // System.out.println("mod result are "+Even_Value);
                    
                    if(Even_Value.longValue()>0){
                    	selectedtuplewatermarking.add(pk);
                  
                                 }
                    else{
                    
                    	Notselectedtuplewatermarking.add(pk);
                    }
        			
        		}
        		//out.println("group separated at  "+a);
        		//out.println("selectedtuplewatermarking size is   "+selectedtuplewatermarking.size());
        		 selectedtupelwatermarkingvectorpartition.add(selectedtuplewatermarking);
        		 rejectedtupelwatermarkingvectorpartition.add(Notselectedtuplewatermarking);
        	
        	}
        	
        	//out.println("first vector is "+selectedtupelwatermarkingvectorpartition.get(0).size());
        	for(int h=0;h<selectedtupelwatermarkingvectorpartition.size();h++){
        		Vector v=new Vector();
        		v=selectedtupelvectorpartition.get(h);
        		//System.out.println(h+" iteration size is "+v.size());
        		//System.out.println(h+" iteration size is "+v.size()*12);
        		int k=v.size()*12;
        		vecount=vecount+k;
        		
        	}
        	//System.out.println("conditin works-----");
        	if(partitiongroupPKVEC.size()==0){
        		 request.setAttribute("PARTITION", "Thresold Not Yet Calculated");
        		
        		 RequestDispatcher rd = request.getRequestDispatcher("Adminpartitionprocess.jsp");
    		     rd.forward(request, response);
        		
        	}
        	else{
        	// System.out.println("total attribute count is "+vecount);
        	 request.setAttribute("PARTITION", "TUPLE SELECTION PRIMARY KEYS");
        	 request.setAttribute("list", selectedtupelvectorpartition);
        	 request.setAttribute("PARTITIONa", "TUPLE REJECTION PRIMARY KEYS");
        	 request.setAttribute("lista", rejectedtupelvectorpartition);//ggjhgjhgjhg
        	 request.setAttribute("PARTITION1", "TUPLE SELECTION FOR WATERMARKING PRIMARY KEYS");
        	 request.setAttribute("list1", selectedtupelwatermarkingvectorpartition);
        	 request.setAttribute("PARTITION2", "TUPLE REJECTION FOR WATERMARKING PRIMARY KEYS");
        	 request.setAttribute("list2", rejectedtupelwatermarkingvectorpartition);
     	   
        	 RequestDispatcher rd = request.getRequestDispatcher("Adminpartitionprocess.jsp");
		     rd.forward(request, response);
        	}
		
		}
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
