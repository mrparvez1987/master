package com.dashManagement.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			fis.close();
		} catch (Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
		
	

	}
	
	
	
	
	public String getApplicationURL(){
		
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername(){
		
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword(){
		
	String password=pro.getProperty("password");
	return password;

	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	public String getDbConnection() {
		String sqlConnection=pro.getProperty("sqlConnection");
		return sqlConnection;
	}
	
	public String getDbUserName() {
		String sqlUserName=pro.getProperty("sqlUserName");
		return sqlUserName;
	}
	
	public String getDbPassword() {
		String sqlPassword=pro.getProperty("sqlPassword");
		return sqlPassword;
	}
	
	

}
