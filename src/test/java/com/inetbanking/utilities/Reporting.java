package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Reporting implements ITestListener {
	public ExtentSparkReporter reporter;
public ExtentReports extent;
public ExtentTest logger;
	public void onTestStart(ITestResult tr) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		reporter=new ExtentSparkReporter("user.dir"+"/test-output/"+repName);//specify location
		reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Vyshnavi");
		
		reporter.config().setDocumentTitle("InetBanking Test Project");//Title of report
		reporter.config().setReportName("Functional Test Report");//name of the report
		reporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
	logger=extent.createTest(tr.getName());//create new entry in the report
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
							e.printStackTrace();}
		}
	}

	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		extent.flush();
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
