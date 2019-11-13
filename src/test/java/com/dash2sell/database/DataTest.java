package com.dash2sell.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;

public class DataTest {
	
	public void validateProgramPageData(String pid,String rn, String ef, String ex,String gf) throws SQLException {
		
		try {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://10.185.7.220:3306/SOLICITATION?serverTimezone=UTC", "phpuser", "Y9gSQaNxhragMe9xvwfDAxmf");
		Statement smt = con.createStatement();
			
		String query="SELECT * FROM PROGRAM.PROGRAMPRIORITY WHERE DATE(CREATEDAT) = CURDATE() AND RANK='"+rn+"'AND EFFECTIVEDATE='"+ef+"' AND EXPIRATIONDATE='"+ex+"' AND GENERATEFOLLOWUPS='"+gf+"'AND PROGRAMID='"+pid+"'";
		
		String del="DELETE FROM PROGRAM.PROGRAMPRIORITY WHERE DATE(CREATEDAT) = CURDATE() AND PROGRAMID='"+pid+"'";
		
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			System.out.println("PROGRAMPRIORITYID:"+rs.getString(1)+","+"PROGRAMID:"+rs.getString(2)+","+"RANK:"+rs.getString(3)+","+rs.getString(7)+","+"EFFECTIVEDATE:"+rs.getString(8)+","+"EXPIRATIONDATE:"+rs.getString(9)+","+"GENERATEFOLLOWUPS:"+rs.getString(10));
			Assert.assertTrue(true);
			System.out.println("Record found and matches with Database...Test Case Passed");	
				}else	{
			System.out.println("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);
		}
		smt.executeUpdate(del);
		
		System.out.println("Record deleted Successfully...");
		con.close();	
	}
	catch(Exception e){
		System.out.println(e);
	}

	}
	
	
	public void validateProjectPageData(String pid,String rn, String ef, String ex,String gf) throws SQLException {
		
		try {
	
		Connection con = DriverManager.getConnection("jdbc:mysql://10.185.7.220:3306/SOLICITATION?serverTimezone=UTC", "phpuser", "Y9gSQaNxhragMe9xvwfDAxmf");
		Statement smt = con.createStatement();
		
		String query="SELECT * FROM PROGRAM.PROJECTPRIORITY WHERE DATE(CREATEDAT) = CURDATE() AND RANK='"+rn+"'AND EFFECTIVEDATE='"+ef+"' AND EXPIRATIONDATE='"+ex+"' AND GENERATEFOLLOWUPS='"+gf+"'AND PROJECTID='"+pid+"'";
		
		String del="DELETE FROM PROGRAM.PROJECTPRIORITY WHERE PROJECTID='"+pid+"'";
	
		ResultSet rs = smt.executeQuery(query);
	
		if(rs.next()) {	
			System.out.println("PROJECTPRIORITYID:"+rs.getString(1)+","+"PROJECTID:"+rs.getString(2)+","+"RANK:"+rs.getString(3)+","+"EFFECTIVEDATE:"+rs.getString(8)+","+"EXPIRATIONDATE:"+rs.getString(9)+","+"GENERATEFOLLOWUPS:"+rs.getString(10));
			Assert.assertTrue(true);
			System.out.println("Record found and matches with Database...Test Case Passed");	
			
		}else{
			System.out.println("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);
		}
		
		smt.executeUpdate(del);
		
		System.out.println("Record deleted Successfully...");
		con.close();	

	}
	catch(Exception e){
		System.out.println(e);
	}

	}
	

}
