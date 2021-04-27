package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	//Constructor
	public ReadConfig() {
		File src= new File(".\\Configuration\\config.properties");
		
		try {
			FileInputStream fls = new FileInputStream(src);
			pro = new Properties();
			pro.load(fls);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	
	
	//----------------Methods---------//
	
	public String getUrl() {
		String Url = pro.getProperty("baseUrl");
		return Url;
	}
	
	
	public String getUserName() {
		String user = pro.getProperty("userId");
		return user;
	
	}
	 public String getPassword() {
		 String pass =pro.getProperty("password");
		 return pass;
	 }
	
	 public String getChrome() {
		 String chrome = pro.getProperty("Chrome");
		 return chrome;
	 }
	 
	 public String getFirefox() {
		 String fireFox= pro.getProperty("Firefox");
		 return fireFox;
	 }
	 public String getIE() {
		 String ie= pro.getProperty("IE");
		 return ie;
	 }
}
