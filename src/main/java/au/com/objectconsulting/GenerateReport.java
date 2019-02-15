package au.com.objectconsulting;

import java.io.IOException;

public class GenerateReport {
	
	public static void main(String [] args) throws IOException {
		
		if( !args[0].isEmpty() ) {
			ReadConfig.userDefinedConfigPath = args[0];
		}
		
		ReportGenerationService report = new ReportGenerationService();
		report.generateReport();
		
	}

}
