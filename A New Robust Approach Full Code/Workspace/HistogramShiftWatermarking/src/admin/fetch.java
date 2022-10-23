package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fetch extends HttpServlet {

	
	Vector<String> rentalexpensesvec = new Vector<String>();
    Vector<String> salaryexpensesvec = new Vector<String>();
    Vector<String> otherexpensesvec = new Vector<String>();
    Vector<String> annualturnovervec = new Vector<String>();
    Random ran = new Random();
    int id=1;
    int year=0,employeecount=0,benchmarkempcount=0,totalempount=0,projectcount=0,tieupclientcount=0,branches=0;
    Double proloss=0.0;
    String rentalexpenses="",salaryamount="",otherexpenses="",status="",annualturn="";
 	Connection connection ;
 	Vector watermarkingbitvec;
     
     public String getRandomElement(Vector v) {
	        Random generator = new Random();
	        int rnd = generator.nextInt(v.size());
	        return (String) v.get(rnd);
	    }


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("text/html");
		//  public void collection() {
		         rentalexpensesvec.add("1.0");
		         rentalexpensesvec.add("1.5");
		         rentalexpensesvec.add("2.0");
		         rentalexpensesvec.add("2.5");
		         salaryexpensesvec.add("1.0");
		         salaryexpensesvec.add("1.5");
		         salaryexpensesvec.add("2.0");
		         salaryexpensesvec.add("2.5");
		         otherexpensesvec.add("0.5");
		         otherexpensesvec.add("1.0");
		         otherexpensesvec.add("1.5");
		         annualturnovervec.add("2.0");
		         annualturnovervec.add("2.5");
		         annualturnovervec.add("3.0");
		         annualturnovervec.add("3.5");
		         annualturnovervec.add("4.0");
		         annualturnovervec.add("4.5");
		         annualturnovervec.add("5.5");
		         annualturnovervec.add("6.5");
		         annualturnovervec.add("7.5");
		         annualturnovervec.add("8.0");
		         annualturnovervec.add("8.5");
		         annualturnovervec.add("9.0");
		         annualturnovervec.add("9.5");



		    // }

		  
		  //  public void insertprocess() {
		        try {


		        	connection = (Connection) getServletContext().getAttribute("connection");
		    		
		          
		            Statement stmt = connection.createStatement();
		                for (year=1600; year<=2000; year++) {
		                    while (true) {
		                        employeecount = ran.nextInt(100);
		                        if (employeecount > 50 && employeecount <=100) {
		                            break;
		                        } else {
		                        }
		                    }
		                    System.out.println("employeecount is------>" + employeecount);


		                      while (true) {
		                        benchmarkempcount = ran.nextInt(50);
		                        if (benchmarkempcount > 10 && benchmarkempcount <40) {
		                            break;
		                        } else {
		                        }
		                    }
		                     System.out.println("benchmarkempcount is------>" + benchmarkempcount);

		                  totalempount=employeecount+benchmarkempcount;

		                   System.out.println("TOTALEMP is------>" + totalempount);


		                      while (true) {
		                        projectcount = ran.nextInt(30);
		                        if (projectcount >10 && projectcount <29) {
		                            break;
		                        } else {
		                        }
		                    }
		                     System.out.println("projectcount is------>" + projectcount);



		                        while (true) {
		                        tieupclientcount = ran.nextInt(20);
		                        if (tieupclientcount >8 && tieupclientcount <15) {
		                            break;
		                        } else {
		                        }
		                    }
		                     System.out.println("tieupclientcount is------>" +tieupclientcount);



		                       while (true) {
		                        branches = ran.nextInt(7);
		                        if (branches >2 && branches <=7) {
		                            break;
		                        } else {
		                        }
		                    }
		                     System.out.println("branches is------>" +branches);


		                     rentalexpenses = getRandomElement(rentalexpensesvec);

		                     System.out.println("rentaexpenses is------>" +rentalexpenses);

		                     salaryamount= getRandomElement(salaryexpensesvec);
		                      
		                     System.out.println("salaryamount is------>" +salaryamount);

		                     otherexpenses=getRandomElement(otherexpensesvec);

		                          System.out.println("otherexpenses is------>" +otherexpenses);



		                          /*  while (true) {
		                        annualturnover = ran.nextInt(10);
		                        if (annualturnover >2 && annualturnover <=10) {
		                            break;
		                        } else {
		                        }
		                    }*/
		                      annualturn=getRandomElement(annualturnovervec);
		                     System.out.println("annualturnover is------>" +annualturn);



		                     proloss=Double.valueOf(annualturn)-(Double.valueOf(rentalexpenses)+Double.valueOf(salaryamount)+Double.valueOf(otherexpenses));//.(rentalexpenses)+Integer.parseInt(salaryamount)+Integer.parseInt(otherexpenses));

		                     
		                     System.out.println("proloss is------>" +proloss);
		                    

		                  String sql = ("insert into infotechdb values('"+id+"','" + year + "','" + employeecount + "','" + benchmarkempcount + "','" + totalempount + "','" + projectcount + "','" + tieupclientcount + "','" + branches + "','"+rentalexpenses+"','" + salaryamount + "','" + otherexpenses + "','" + annualturn + "','" + proloss + "')");
		                  stmt.executeUpdate(sql);
		                  
		                      System.out.println("row completed " + id);
		                      id++;
		                }
		                
		                status="NUMERIC DATABASE HAS BEEN CREATED";
		                request.setAttribute("FETCH", status);
		    			RequestDispatcher rd = request.getRequestDispatcher("AdminSucess.jsp");
		    	         rd.forward(request, response);
		           
		        } catch (Exception e) {

		            System.out.println(e);
		        }
		  //  }

		
	}

	
	

}
