package au.com.objectconsulting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class ReportGenerationService {
	
	public void generateReport() throws IOException {
		
		final ReadConfig config = new ReadConfig();
		int toatlPath= Integer.parseInt(config.totalJSONFile() );
		File reportOutputDirectory = new File(config.getReportURL());
		List<String> jsonFiles = new ArrayList<String>();
		
		for(int i = 1; i<=toatlPath; i++ ) {
			jsonFiles.add(config.getCucumberJSONPath());
		}
		
		String buildNumber = config.getBuildNumber();
		String projectName = config.getProjectName();
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", config.getPlatform());
		configuration.addClassifications("Browser", config.getBrowser());
		configuration.addClassifications("Branch", config.getrelease());
		File file = new File(config.getReportURL());
		FileUtils.deleteDirectory(file);
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		if(result== null) {
			System.out.println("!!!!!!!!!!!!!!!!!UNABLE to generate Report!!!!!!!!!!!!!!!!!");
			System.out.println("Please make sure JSON paths and number are defined properly in CONFIG File.");
		} else {
			System.out.println("Report generated successfully!!");
			System.out.println("Please check report in the following path: "+file);
		}
	}
}
