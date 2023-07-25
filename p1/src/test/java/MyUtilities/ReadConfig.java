package MyUtilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig {
	Properties pro ;
	
	public ReadConfig() {
		File src =  new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String un = pro.getProperty("username");
		return un;
	}
	public String getLastName() {
		String pw = pro.getProperty("lastname");
		return pw;
	}
	public String getTelephone() {
		String tel = pro.getProperty("telephone");
		return tel;
	}
	public String getEmail() {
		String em = pro.getProperty("email");
		return em;
	}
	public String getDetails() {
		String de = pro.getProperty("details");
		return de;
	}

}
