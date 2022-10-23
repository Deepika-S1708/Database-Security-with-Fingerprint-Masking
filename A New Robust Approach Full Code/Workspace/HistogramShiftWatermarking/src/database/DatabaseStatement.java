package database;

import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

public class DatabaseStatement extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static DatabaseStatement databaseStatement = new DatabaseStatement();

	Statement statement = null;

	Connection connection = null;

	String sql = "";

	public static synchronized DatabaseStatement getDatabaseStatement() {
		return databaseStatement;
	}

	public String checkUserName() {
		sql = "Select username,userid from registration where userName=? and password=?";
		return sql;
	}

	public String insertUser() {
		sql = "insert into registration(userName,userEmail,userAddress,userBirth,password,userid) values(?,?,?,?,?,?)";
		return sql;
	}
	
	public String checknull(){
		sql = "SELECT YEAR  FROM binaryinfotechstatus";
		return sql;
		
	
	}
	public String updatefingerprint() {
		sql = "update registration set fingerprint=? where userName=? and userid=?";
		return sql;
	}
	public String updatefingertemplate() {
		sql = "update registration set secretkey=?,fingertemplate=? where userName=? and userid=?";
		return sql;
	}
	public String checkUserid() {
		sql = "Select username,userid,fingerprint,fingertemplate,secretkey from registration where userName=? and userid=?";
		return sql;
	}
}
