package ExtenetReportDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html"); 
	ExtentReports reports = new ExtentReports();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		reports.attachReporter(htmlReporter);
		System.out.println("On Start method invocked............");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());//.assignAuthor("Mythili").assignDevice("Chrome");
		test.pass("Test successfully executed");
	    reports.flush();
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());//.assignAuthor("Mythili").assignDevice("Chrome");
		test.fail("Test not successfully executed");
	    reports.flush();
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());//.assignAuthor("Mythili").assignDevice("Chrome");		
		test.skip("Test skipped");
	    reports.flush();
		
	}
	
}
