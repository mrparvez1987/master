package com.dashManagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.testng.Assert;
import com.dashManagement.utilities.ReadConfig;
import com.dashManagement.utilities.TestLogger;




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
			TestLogger.log("PROGRAMPRIORITYID:"+rs.getString(1)+","+"PROGRAMID:"+rs.getString(2)+","+"RANK:"+rs.getString(3)+","+rs.getString(7)+","+"EFFECTIVEDATE:"+rs.getString(8)+","+"EXPIRATIONDATE:"+rs.getString(9)+","+"GENERATEFOLLOWUPS:"+rs.getString(10));
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");	
				}else	{
					TestLogger.log("Record Not Found in Database...Test Case Failed");
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
			
	else {
		
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
	
	

public void validateTemplateScanTypeData2(String desc,String caption,String optional,String instr,String fieldType,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT temp.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.INSTRUCTIONS,cc.DESCRIPTION "
				+ "FROM NINJA.TEMPLATES temp "
				+ "JOIN NINJA.FIELDS fie "
				+ "on temp.TEMPLATEID=fie.TEMPLATEID "
				+ "join NINJA.FIELDCRITERIA fcri "
				+ "on fcri.FIELDID=fie.TEMPLATEID "
				+"LEFT join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		
	
		ResultSet rs = smt.executeQuery(query);
	
		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				
		if(rs.getString(1).equalsIgnoreCase(desc) && rs.getString(2).equalsIgnoreCase(caption) && rs.getString(3).equalsIgnoreCase(optional) && rs.getString(4).contains(""+instr)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}

	
}
	


	public void validateInLineAttachmentTypeData(String fieldType,String caption,String optional,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL "
			+ "FROM NINJA.TEMPLATES temp "
			+ "JOIN NINJA.FIELDS fie "
			+ "on temp.TEMPLATEID=fie.TEMPLATEID "
			+"LEFT join COREAPP.CODES cc "
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='In-Line Attachment' "
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}
	
	
	public void validateInstructionTypeData(String fieldType,String caption,String optional,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL "
				+ "FROM NINJA.TEMPLATES temp "
				+ "JOIN NINJA.FIELDS fie "
				+ "on temp.TEMPLATEID=fie.TEMPLATEID "
				+"LEFT join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Instructions' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}


	}
	
public void validatePictureTypeData(String fieldType,String caption,String optional,String loose,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,ia.NAME  "
				+ "FROM NINJA.TEMPLATES temp "
				+ "JOIN NINJA.FIELDS fie "
				+ "on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join ACTIVITY.ITEMATTACHMENTNAMES ia "
				+"on ia.ITEMATTACHMENTNAMEID = fie.ITEMATTACHMENTNAMEID "
				+"LEFT join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Picture' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).equalsIgnoreCase(loose)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}


	}


public void validateListTypeData(String fieldType,String caption,String optional,String loose,String resText,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,ia.NAME,r.RESPONSETEXT "
			+ "FROM NINJA.TEMPLATES temp "
			+ "JOIN NINJA.FIELDS fie "
			+ "on temp.TEMPLATEID=fie.TEMPLATEID "
			+"join ACTIVITY.ITEMATTACHMENTNAMES ia "
			+ "on ia.ITEMATTACHMENTNAMEID = fie.ITEMATTACHMENTNAMEID "
			+"join NINJA.FIELDRESPONSES fr "
			+ "on fr.FIELDID = fie.FIELDID "
			+"join NINJA.RESPONSES r "
			+ "on r.RESPONSEID = fr.RESPONSEID "
			+"LEFT join COREAPP.CODES cc "
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption) && rs.getString(3).equalsIgnoreCase(optional)  && rs.getString(4).equalsIgnoreCase(loose) && rs.getString(5).contains(resText)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}

public void validateTextTypeData(String fieldType,String caption,String optional,String maxValue,String loose,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="Select cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.MAXIMUM,ia.NAME "
			+"FROM NINJA.TEMPLATES temp "
			+"JOIN NINJA.FIELDS fie "
			+"on temp.TEMPLATEID=fie.TEMPLATEID "
			+"join ACTIVITY.ITEMATTACHMENTNAMES ia " 
			+"on ia.ITEMATTACHMENTNAMEID = fie.ITEMATTACHMENTNAMEID "
			+"join COREAPP.CODES cc on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='Text' " 
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional) && rs.getString(4).equalsIgnoreCase(maxValue)&& rs.getString(5).contains(loose)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}


public void validateSignatureTypeData(String fieldType,String caption,String optional,String aApprove,String internal,String loose,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.AUTOAPPROVE,fie.INTERNALONLY,ia.NAME "
			+"FROM NINJA.TEMPLATES temp "
			+"JOIN NINJA.FIELDS fie "
			+"on temp.TEMPLATEID=fie.TEMPLATEID "
			+"join ACTIVITY.ITEMATTACHMENTNAMES ia on ia.ITEMATTACHMENTNAMEID = fie.ITEMATTACHMENTNAMEID "
			+"join COREAPP.CODES cc "
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='Signature' "
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional) && rs.getString(4).equalsIgnoreCase(aApprove) && rs.getString(5).equalsIgnoreCase(internal)&& rs.getString(6).equalsIgnoreCase(loose)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}


public void validateTemplateDateData(String fieldType,String caption,String optional,String edate,String ldate,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.DATEMIN,fie.DATEMAX "  
			+"FROM NINJA.TEMPLATES temp " 
			+"JOIN NINJA.FIELDS fie "  
			+"on temp.TEMPLATEID=fie.TEMPLATEID "
			+"LEFT join COREAPP.CODES cc " 
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='Date' "
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional) && rs.getString(4).equalsIgnoreCase(edate) && rs.getString(5).equalsIgnoreCase(ldate)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}



public void validateFeatureLinkTypeData(String fieldType,String caption,String optional,String featurelink,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.FEATUREID "
			+"FROM NINJA.TEMPLATES temp "
			+"JOIN NINJA.FIELDS fie "
			+"on temp.TEMPLATEID=fie.TEMPLATEID "
			+"join COREAPP.CODES cc "
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='Feature Link' "
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).equalsIgnoreCase(featurelink)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}


}

public void validateExceptionTypeData(String fieldType,String caption,String optional,String exceptionType,String filename,String tempNumber) throws SQLException {
	
	try {
		
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
	
	String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.EXCEPTIONTYPEID,aa.NAME "
			+"FROM NINJA.TEMPLATES temp "
			+"JOIN NINJA.FIELDS fie "
			+"on temp.TEMPLATEID=fie.TEMPLATEID "
			+"JOIN ATTACHMENT.ATTACHMENTS  aa "
			+"on aa.ATTACHMENTID=fie.ATTACHMENTID "
			+"join COREAPP.CODES cc "
			+"on fie.TYPEID=cc.CODEID "
			+"WHERE cc.DESCRIPTION='Exception' "
			+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
	

	ResultSet rs = smt.executeQuery(query);

	if(rs.next()) {	
		
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			
	if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).equalsIgnoreCase(exceptionType)&& rs.getString(5).equalsIgnoreCase(filename)) {
			Assert.assertTrue(true);
			TestLogger.log("Record found and matches with Database...Test Case Passed");
			
		} else{
			TestLogger.log("Record Not Found in Database...Test Case Failed");
			Assert.assertTrue(false);			
		}		
	
	}
	con.close();
}
catch(Exception e){
	System.out.println(e);
}
}
	public void validateTemplateScanTypeData(String fieldType,String caption,String optional,String scanType,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.SCANTYPEID "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Scan Type' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).equalsIgnoreCase(scanType)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
}

	
 public void validateCurrencyTypeData(String fieldType,String caption,String optional,String minamount,String maxamount,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.FLOATMIN,fie.FLOATMAX "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Currency' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).contains(minamount)&& rs.getString(5).contains(maxamount)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
}
 
 
 
/* shopcom*/
 
 public void validateShomcomTypeData(String desc,String fieldType,String caption,String optional,String comp,String value,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT temp.DESCRIPTION,cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fcri.COMPARISONTYPEID,fcri.VALUE "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join NINJA.FIELDCRITERIA fcri "
				+"on fcri.FIELDID=fie.FIELDID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
				
		if(rs.getString(1).equalsIgnoreCase(desc) && rs.getString(2).equalsIgnoreCase(fieldType) && rs.getString(3).equalsIgnoreCase(caption)  && rs.getString(4).equalsIgnoreCase(optional)&& rs.getString(5).equalsIgnoreCase(comp)&& rs.getString(6).equalsIgnoreCase(value)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
 
 
 public void validateHyperlinkTypeData(String fieldType,String caption,String optional,String hyperadd,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.HYPERLINK "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Hyperlink (URL, web address)' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)&& rs.getString(4).equalsIgnoreCase(hyperadd)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	}

 public void validateSingleWrapperTypeData(String fieldType,String caption,String optional,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Single Screen Wrapper' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
 
 

 
 
 public void validateTemplateNumericData(String desc,String fieldType,String caption,String optional,String minvalue,String maxvalue,String comp,String value,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT temp.DESCRIPTION,cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,fie.MINIMUM,fie.MAXIMUM,c.DESCRIPTION,fcri.VALUE "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"join NINJA.FIELDCRITERIA fcri "
				+"on fcri.FIELDID=fie.FIELDID "
				+"join ACTIVITY.ITEMATTACHMENTNAMES ia " 
				+"on ia.ITEMATTACHMENTNAMEID = fie.ITEMATTACHMENTNAMEID "
				+"join COREAPP.CODES cc on fie.TYPEID=cc.CODEID "
				+"join COREAPP.CODES c on fcri.COMPARISONTYPEID=c.CODEID "
				+"WHERE temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
				
		if(rs.getString(1).equalsIgnoreCase(desc) && rs.getString(2).equalsIgnoreCase(fieldType) && rs.getString(3).equalsIgnoreCase(caption)  && rs.getString(4).equalsIgnoreCase(optional)&& rs.getString(5).equalsIgnoreCase(minvalue)  && rs.getString(6).equalsIgnoreCase(maxvalue)&& rs.getString(7).equalsIgnoreCase(comp)  && rs.getString(8).equalsIgnoreCase(value)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
 
 
 public void validateLooseAttachmentTypeData(String fieldType,String caption,String optional,String loose,String tempNumber) throws SQLException {
		
		try {
			
			Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
			Statement smt = con.createStatement();
		
		String query="SELECT cc.DESCRIPTION,fie.LABEL,fie.OPTIONAL,iname.NAME "
				+"FROM NINJA.TEMPLATES temp "
				+"JOIN NINJA.FIELDS fie "
				+"on temp.TEMPLATEID=fie.TEMPLATEID "
				+"JOIN ACTIVITY.ITEMATTACHMENTNAMES iname "
				+"on fie.ITEMATTACHMENTNAMEID=iname.ITEMATTACHMENTNAMEID "
				+"join COREAPP.CODES cc "
				+"on fie.TYPEID=cc.CODEID "
				+"WHERE cc.DESCRIPTION='Loose Attachment' "
				+"AND temp.TEMPLATENUMBER='"+tempNumber+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
		if(rs.getString(1).equalsIgnoreCase(fieldType) && rs.getString(2).equalsIgnoreCase(caption)  && rs.getString(3).equalsIgnoreCase(optional) && rs.getString(4).equalsIgnoreCase(loose)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
		
	}
 
 
 
 
 	public void validateElementData(String dept,String retake,String task,String sdate,String edate,String duration,String participant,String elementid,String elestatus,String itemTempNum,String storeTempNum,String concludingTempNum) {
 		
try {
			
		Connection con = DriverManager.getConnection(read.getDbConnection(), read.getDbUserName(), read.getDbPassword());
		Statement smt = con.createStatement();
		
		String query="SELECT d.DESCRIPTION AS DEPARTMENTID,cc.DESCRIPTION AS DEFAULTRETAKETYPEID,tt.DESCRIPTION AS TASKTYPEID ,date(ac.STARTDATETIME)STARTDATE,date(ac.ENDDATETIME) AS ENDDATE, " 
			+"ac.DEFAULTDURATION, ac.PARTICIPANTLIST,cd.DESCRIPTION,ct.TEMPLATENUMBER as STORETEMPLATE, ct1.TEMPLATENUMBER AS ITEMTEMPLATE, ct2.TEMPLATENUMBER AS GLOBALTEMPLATE " 
			+"FROM ACTIVITY.CAMPAIGNELEMENTS ac "  
			+"JOIN COREAPP.CODES cc ON cc.CODEID=ac.DEFAULTRETAKETYPEID "  
			+"JOIN ACTIVITY.DEPARTMENTS d ON d.DEPARTMENTID = ac.DEPARTMENTID "  
			+"JOIN ACTIVITY.TASKTYPES tt ON tt.TASKTYPEID = ac.TASKTYPEID "
			+"JOIN COREAPP.CODES cd on cd.CODEID=ac.STATUSID "
			+"join ACTIVITY.CAMPAIGNELEMENTTEMPLATES ct on ct.CAMPAIGNELEMENTID=ac.CAMPAIGNELEMENTID "
			+"join ACTIVITY.CAMPAIGNELEMENTTEMPLATES ct1 on ct1.CAMPAIGNELEMENTID = ct.CAMPAIGNELEMENTID and ct1.LOCATION = 943 "
			+"join ACTIVITY.CAMPAIGNELEMENTTEMPLATES ct2 on ct2.CAMPAIGNELEMENTID =ct.CAMPAIGNELEMENTID and ct2.LOCATION = 944 "
			+"WHERE ct.LOCATION = 942 AND ac.CAMPAIGNELEMENTID='"+elementid+"' ";	
		

		ResultSet rs = smt.executeQuery(query);

		if(rs.next()) {	
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11));
				
		if(rs.getString(1).equalsIgnoreCase(dept)&&rs.getString(2).equalsIgnoreCase(retake)&&rs.getString(3).equalsIgnoreCase(task)&&rs.getString(4).equalsIgnoreCase(sdate)&&rs.getString(5).equalsIgnoreCase(edate)&&rs.getString(6).equalsIgnoreCase(duration)&&rs.getString(7).equalsIgnoreCase(participant)&&rs.getString(8).equalsIgnoreCase(elestatus)&&rs.getString(9).equalsIgnoreCase(storeTempNum)&&rs.getString(10).equalsIgnoreCase(itemTempNum)&&rs.getString(11).equalsIgnoreCase(concludingTempNum)) {
				Assert.assertTrue(true);
				TestLogger.log("Record found and matches with Database...Test Case Passed");
				
			} else{
				TestLogger.log("Record Not Found in Database...Test Case Failed");
				Assert.assertTrue(false);			
			}		
		
		}
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
		
	 
	 
 }
 
 
 
 
 
 
}
