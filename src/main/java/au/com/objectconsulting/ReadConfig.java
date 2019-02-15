package au.com.objectconsulting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	public static int count=1;
	private Properties properties;
	public static String userDefinedConfigPath="C:\\Products\\reportgeneration\\config\\Configuration.properties";
	
	public ReadConfig() throws IOException{

		properties = new Properties();

		try {
			if (userDefinedConfigPath == null) {
				
				InputStream inputStream = new FileInputStream(new File(".").getAbsolutePath()+"\\config\\Configuration.properties");
				properties.load(inputStream);
			}
			else {
				
				InputStream inputStream = new FileInputStream(userDefinedConfigPath);
				properties.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}							
	}
	
	public String totalJSONFile () {
		String driverPath = properties.getProperty("TotalJSONPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Cucumber.json file path  is not specified in the Configuration.properties file.");	
		
	}
	
	public String getCucumberJSONPath() {
		if(count <= Integer.parseInt(totalJSONFile())) {
			String driverPath = properties.getProperty("CucumberJSONPath"+count);
			count++;
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("CucumberJSONPath"+count+".json file path  is not specified in the Configuration.properties file.");		
		}
		else throw new RuntimeException("Filename mismatched");
	}
	
	public String getBuildNumber() {
		String driverPath = properties.getProperty("buildNumber");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Build Number is not specified in the Configuration.properties file.");	
		
	}
	
	public String getProjectName () {
		String driverPath = properties.getProperty("projectName");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Project name  is not specified in the Configuration.properties file.");	
		
	}
	
	public String getBrowser() {
		String driverPath = properties.getProperty("browser");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Browser is not specified in the Configuration.properties file.");	
		
	}
	
	public String getPlatform() {
		String driverPath = properties.getProperty("platform");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Platform is not specified in the Configuration.properties file.");	
	}
	
	public String getrelease() {
		String driverPath = properties.getProperty("release");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Release is not specified in the Configuration.properties file.");	
	}
	
	public String getReportURL() {
		String driverPath = properties.getProperty("reportDirectory");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("reportDirectory is not specified in the Configuration.properties file.");	
	}

}
