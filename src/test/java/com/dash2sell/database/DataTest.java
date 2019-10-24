package com.dash2sell.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {

	public static void main(String args[] ) throws SQLException {
		
		//Create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://10.185.7.220:3306/SOLICITATION?serverTimezone=UTC", "qauser", "jTryZMVq");
		
		//Create Statement/Query
		Statement stmt = con.createStatement();
		
		String s = "Select * from SOLICITATION.SOLICITATIONS";  //Write your query here
		
		//Execute Statement/Query and store data in a resultset
		ResultSet rs = stmt.executeQuery(s);
		
		while(rs.next()) {
			
			int sid = rs.getInt("SOLICITATIONID"); //when datatype int
			String desc = rs.getString("DESCRIPTION"); //when datatype string or character
			int status = rs.getInt("STATUSID");
			Date startdate = rs.getDate("STARTDATETIME");
			
			System.out.println(sid+"  "+desc+"  "+status+"  "+startdate);

			
		}
		
		//Close Connection
		con.close();
		
		System.out.println("Query Executed...");

	}
	//ddd

}
