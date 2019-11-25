package com.dash2sell.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import org.testng.Assert;

import com.dashManagement.utilities.ReadConfig;




public class DataTest {
	ReadConfig read=new ReadConfig();
	
	
	public void validateProgramPageData(String pid,String rn, String ef, String ex,String gf) throws SQLException {
		
		try {
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		//Connection con = DriverManager.getConnection("jdbc:mysql://10.185.7.220:3306/?serverTimezone=UTC", "phpuser", "Y9gSQaNxhragMe9xvwfDAxmf");
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
	
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
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
	
	
	
	
	public void validateNewEsalationData(String element,String sum, String store,String duration) throws SQLException {
		
		try {
	
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
		
		String query="SELECT * FROM ACTIVITY.ESCALATIONS WHERE DATE(CREATEDAT) = CURDATE() AND STORELIST='"+store+"'AND SUMMARY='"+sum+"' AND PLANNEDDURATION='"+duration+"'AND ELEMENTID='"+element+"'";
		
		//String del="DELETE FROM ACTIVITY.ESCALATIONS WHERE PROJECTID='"+element+"'";
	
		ResultSet rs = smt.executeQuery(query);
	
		if(rs.next()) {	
			
			Assert.assertTrue(true);
			System.out.println("Record found and matches with Database...Test Case Passed");	
			
		}else{
			System.out.println("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);
		}
		
		//smt.executeUpdate(del);
		
		//System.out.println("Record deleted Successfully...");
		con.close();	

	}
	catch(Exception e){
		System.out.println(e);
	}

	}
	
	
	

	public void validateNewStatusData() throws SQLException {
		
		try {
	
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
		
		String query="SELECT * FROM ACTIVITY.ESCALATIONS WHERE ESCALATIONID=117";
		//String query="SELECT * FROM ACTIVITY.ESCALATIONS WHERE DATE(CREATEDAT) = CURDATE() AND STORELIST='"+store+"'AND SUMMARY='"+sum+"' AND PLANNEDDURATION='"+duration+"'AND ELEMENTID='"+element+"'";
		
		//String del="DELETE FROM ACTIVITY.ESCALATIONS WHERE PROJECTID='"+element+"'";
	
		ResultSet rs = smt.executeQuery(query);
	
		if(rs.next()) {	
			
			int eid = rs.getInt("ESCALATIONID"); //when datatype int
			int status = rs.getInt("STATUSID");
			int cid = rs.getInt("CLIENTID");
			Date duedate = rs.getDate("DUEDATE");
			
			System.out.println(eid+"\t"+status+"\t"+cid+"\t"+duedate);
			
			if(eid==117 && status==2961 && cid==120) {
				Assert.assertTrue(true);
				System.out.println("Record found and matches with Database...Test Case Passed");	
			}
			
		//	System.out.println("ESCALATIONID:"+rs.getString(1)+","+"STATUSID:"+rs.getString(2)+","+"CLIENTID:"+rs.getString(3)+","+"DUEDATE:"+rs.getString(11));
			
			//Assert.assertTrue(true);
			
			
		else{
			
			Assert.assertTrue(false);
			System.out.println("Record Not Found in Database...Test Case Failed");
			
		}
		
		//smt.executeUpdate(del);
		
		//System.out.println("Record deleted Successfully...");
		con.close();	

	}
		}
	catch(Exception e){
		System.out.println(e);
	}
	
}
	
	
	

	public void validateApproveStatusData(String escid) throws SQLException {
		
		try {
	
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
		
		String query="SELECT * FROM ACTIVITY.ESCALATIONS as es\r\n" + 
				"JOIN COREAPP.CODES as cp\r\n" + 
				"ON es.STATUSID=cp.CODEID\r\n" + 
				"WHERE es.ESCALATIONID='"+escid+"'";
	
	
		ResultSet rs = smt.executeQuery(query);
	
		if(rs.next()) {	
			
			String statusName=rs.getString("NAME");
				
			System.out.println(statusName);
			
			if(statusName.equalsIgnoreCase("Approved")) {
				Assert.assertTrue(true);
				System.out.println("Current Status of escataion from database: "+statusName+"..."+"Test Case Passed");	
			}
				
		else{
			
			Assert.assertTrue(false);
			System.out.println("...Test Case Failed");
			
		}
		
	
		con.close();	

	}
		}
	catch(Exception e){
		System.out.println(e);
	}

	
	
}



	public void validateCancelledStatusData(String escid) throws SQLException {
	
	try {

		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
	Statement smt = con.createStatement();
	
	String query="SELECT * FROM ACTIVITY.ESCALATIONS as es\r\n" + 
			"JOIN COREAPP.CODES as cp\r\n" + 
			"ON es.STATUSID=cp.CODEID\r\n" + 
			"WHERE es.ESCALATIONID='"+escid+"'";


	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		String statusName=rs.getString("NAME");
			
		System.out.println(statusName);
		
		if(statusName.equalsIgnoreCase("Cancelled")) {
			Assert.assertTrue(true);
			System.out.println("Current Status of escataion from database : "+statusName+"..."+"Test Case Passed");	
		}
			
	else{
		
		Assert.assertTrue(false);
		System.out.println("...Test Case Failed");
		
	}
	

	con.close();	

}
	}
catch(Exception e){
	System.out.println(e);
}



}
}
