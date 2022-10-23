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




public class datasetwatermark extends HttpServlet {
 	Connection connection ;
 	int by=0;
 	Statement stmt ;
 	String ks="1as";   //secret key
	Md5hashfunction md=new Md5hashfunction();
	Vector s0copy;//=new Vector();
	Vector s1copy;//=new Vector();
	Vector s2copy;//=new Vector();
	Vector s3copy;//=new Vector();
	static Vector<Vector> partitiongroupprimarykeyvector=new Vector();
	static Vector<Vector> PartitiongroupThresolsve=new Vector<Vector>();
	
	Double totalcount;
	Double summazion=0.0;
	
	Double yearcount;
	Double yearinti=0.0;
	Double activeempcount;
	Double activeempinti=0.0;
	Double benchmarkempcount;
	Double benchmarkempinti=0.0;
	Double totempcount;
	Double totempinti=0.0;
	Double projectcountcount;
	Double projectcountinti=0.0;
	Double tieupclientscount;
	Double tieupclientsinti=0.0;
	Double brancescount;
	Double brancesinti=0.0;
	Double rentalexpcount;
	Double rentalexpinti=0.0;
	
	Double salryamountcount;
	Double salryamountinti=0.0;
	Double otherexpensescount;
	Double otherexpensesexpinti=0.0;
	Double annualtocount;
	Double annualtoexpinti=0.0;
	Double profitlosscount;
	Double profitlossinti=0.0;
	
	
	datapartition dp=new datapartition();
	float yearconfidentalfactor=0.54f;
	float activeempconfidentalfactor=0.2f;
	float benchmarkempconfidentalfactor=0.3f;
	float totempconfidentalfactor=0.5f;
	float projectcountconfidentalfactor=0.21f;
	float tieupclientsconfidentalfactor=0.14f;
	float brancesconfidentalfactor=0.56f;
	float rentalexpconfidentalfactor=0.78f;
	float salryamountconfidentalfactor=0.84f;
	float otherexpensesconfidentalfactor=0.93f;
	float annualtoconfidentalfactor=0.65f;
	float profitlossconfidentalfactor=0.47f;
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			
               
        	connection = (Connection) getServletContext().getAttribute("connection");
        	 stmt = connection.createStatement();
        	 System.out.println("connection exe");
        	 Vector<Vector> list = new Vector <Vector> ();
        	 Vector watermarkingbitvec;
        	
        	 s0copy=datapartition.s0;
        	 s1copy=datapartition.s1;
        	 s2copy=datapartition.s2;
        	 s3copy=datapartition.s3;
        	 partitiongroupprimarykeyvector=new Vector();
        	
        	 partitiongroupprimarykeyvector.add(s0copy);
        	 partitiongroupprimarykeyvector.add(s1copy);
        	 partitiongroupprimarykeyvector.add(s2copy);
        	 partitiongroupprimarykeyvector.add(s3copy);
        	 System.out.println("vector adding process completed");
        	 PartitiongroupThresolsve=new Vector<Vector>();
        	
        	 for(int i=0;i<partitiongroupprimarykeyvector.size();i++){
        		 System.out.println("for loop entered ");
        		 Vector temp=new Vector();
        		 Vector <Double>Thresolsve=new Vector<Double>();
        		
        		 temp=partitiongroupprimarykeyvector.get(i);
        		 for(int j=0;j<temp.size();j++){
        			 
        			 String sql1="select * from infotechdb where SNO="+temp.get(j);
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
                           
                           
                           yearcount=Double.valueOf(year);
                           yearinti=yearinti+yearcount;
                           
                           activeempcount=Double.valueOf(activeemp);
                           activeempinti=activeempinti+activeempcount;
                           
                           benchmarkempcount=Double.valueOf(benchmarkemp);
                           benchmarkempinti=benchmarkempinti+benchmarkempcount;
                           
                           totempcount=Double.valueOf(totemp);
                           totempinti=totempinti+totempcount;
                           
                           projectcountcount=Double.valueOf(projectcount);
                           projectcountinti=projectcountinti+projectcountcount;
                           
                           
                           tieupclientscount=Double.valueOf(tieupclients);
                           tieupclientsinti=tieupclientsinti+tieupclientscount;
                           
                           
                           brancescount=Double.valueOf(brances);
                           brancesinti=brancesinti+brancescount;
                           
                           rentalexpcount=Double.valueOf(rentalexp);
                           rentalexpinti=rentalexpinti+rentalexpcount;
                           
                           salryamountcount=Double.valueOf(salryamount);
                           salryamountinti= salryamountinti+salryamountcount;
                           
                           
                           otherexpensescount=Double.valueOf(otherexpenses);
                           otherexpensesexpinti=otherexpensesexpinti+otherexpensescount;
                           
                           annualtocount=Double.valueOf(annualto);
                           annualtoexpinti=annualtoexpinti+annualtocount;
                           
                           
                           
                           profitlosscount=Double.valueOf(annualto);
                           profitlossinti=profitlossinti+profitlosscount;
                          
                       }
        			 
        		 }
        		 
        		// out.println(i+" GROUP COMPLETED");
        		/* out.println("total completed "+profitlossinti);
        		System.out.println(i+" GROUP COMPLETED");
        		System.out.println("\n total count is "+summazion);
        		System.out.println("\n mean is "+summazion/temp.size());
        		System.out.println("\n standard deviation is "+Math.sqrt(summazion/temp.size()));*/
        		 
        		 
        		 Double yearmean=yearinti/temp.size();
        		 Double yearsd=Math.sqrt(yearinti/temp.size());
        		 
        		 Double activempmean=activeempinti/temp.size();
        		 Double activeempsd=Math.sqrt(activeempinti/temp.size());
        		 
        		 
        		 Double benchmarkmean=benchmarkempinti/temp.size();
        		 Double benchmarksd=Math.sqrt(benchmarkempinti/temp.size());
        		 
        		 Double totempcountmean=totempinti/temp.size();
        		 Double totempsd=Math.sqrt(totempinti/temp.size());
        		 
        		 Double projectcountmean=projectcountinti/temp.size();
        		 Double projectcountsd=Math.sqrt(projectcountinti/temp.size());
        		 
        		 Double tiecupclinetsmean=tieupclientsinti/temp.size();
        		 Double tiecupclinetsd=Math.sqrt(tieupclientsinti/temp.size());
        		 
        		 Double branchesmean=brancesinti/temp.size();
        		 Double branchessd=Math.sqrt(brancesinti/temp.size());
        		 
        		 Double rentalexpmean=rentalexpinti/temp.size();
        		 Double rententalexpsd=Math.sqrt(rentalexpinti/temp.size());
        		 
        		 
        		 Double salarymean=salryamountinti/temp.size();
        		 Double salarysd=Math.sqrt(salryamountinti/temp.size());
        		 
        		 
        		 Double otherexpensesmean=otherexpensesexpinti/temp.size();
        		 Double otherexpensessd=Math.sqrt(otherexpensesexpinti/temp.size());
        		 
        		 Double annualexpensesmean=annualtoexpinti/temp.size();
        		 Double annualexpensessd=Math.sqrt(annualtoexpinti/temp.size());
        		 
        		 Double profitlossmean=profitlossinti/temp.size();
        		 Double profitlosssd=Math.sqrt(profitlossinti/temp.size());
        		 
        		
        		
        		Double Thresoldyear=(yearconfidentalfactor*(yearmean))+(yearsd);
        		Double Thresoldactiveemp=(activeempconfidentalfactor*(activempmean))+(activeempsd);
        		Double Thresoldbenchmarkemp=(benchmarkempconfidentalfactor*(benchmarkmean))+(benchmarksd);
        		Double Thresoldtotemp=(totempconfidentalfactor*totempcountmean)+(totempsd);
        		Double Thresoldprojectcount=(projectcountconfidentalfactor*(projectcountmean))+(projectcountsd);
        		Double Thresoldtieupclients=(tieupclientsconfidentalfactor*(tiecupclinetsmean))+(tiecupclinetsd);
        		Double Thresoldbrances=(brancesconfidentalfactor*(branchesmean))+(branchessd);
        		Double Thresoldrentalexp=(rentalexpconfidentalfactor*(rentalexpmean))+(rententalexpsd);
        		Double Thresoldsalryamount=(salryamountconfidentalfactor*(salarymean))+(salarysd);
        		Double Thresoldotherexpenses=(otherexpensesconfidentalfactor*(otherexpensesmean))+(otherexpensessd);
        		Double Thresoldannualto=(annualtoconfidentalfactor*(annualexpensesmean))+(annualexpensessd);
        		Double Thresoldprofitloss=(profitlossconfidentalfactor*(profitlossmean))+(profitlosssd);
        		
        		
        		
        		Thresolsve.add(Thresoldyear);
        		Thresolsve.add(Thresoldactiveemp);
        		Thresolsve.add(Thresoldbenchmarkemp);
        		Thresolsve.add(Thresoldtotemp);
        		Thresolsve.add(Thresoldprojectcount);
        		Thresolsve.add(Thresoldtieupclients);
        		Thresolsve.add(Thresoldbrances);
        		Thresolsve.add(Thresoldrentalexp);
        		Thresolsve.add(Thresoldsalryamount);
        		Thresolsve.add(Thresoldotherexpenses);
        		Thresolsve.add(Thresoldannualto);
        		Thresolsve.add(Thresoldprofitloss);
        	  
        		PartitiongroupThresolsve.add(Thresolsve);
        		//System.out.println("partition vector size is "+PartitiongroupThresolsve.size());
        		
        		 
        	 }
        	 
        	 
			yearinti = 0.0;
			activeempinti = 0.0;
			benchmarkempinti = 0.0;
			totempinti = 0.0;
			projectcountinti = 0.0;
			tieupclientsinti = 0.0;
			brancesinti = 0.0;
			rentalexpinti = 0.0;
			salryamountinti = 0.0;
			otherexpensesexpinti = 0.0;
			annualtoexpinti = 0.0;
			profitlossinti = 0.0;
        	 if(s0copy.size()==0){
        		  request.setAttribute("PARTITION", "TUPLE GROUPING NOT YET PROCESSED");
        		  RequestDispatcher rd = request.getRequestDispatcher("Adminpartitionprocess.jsp");
     		      rd.forward(request, response);
         
        	 }
        	 else{
        		
        		    request.setAttribute("PARTITION", "SECURE HASH HAS BEEN ALLOCATED");
                    request.setAttribute("list", PartitiongroupThresolsve);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("Adminpartitionprocess.jsp");
       		     rd.forward(request, response);
        		 
        	 }
		
		}
            
		
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	

}
