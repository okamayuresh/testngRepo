package root;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener{
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		if(method.isTestMethod()){
			String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
			String baseUrl = method.getTestMethod().getXmlTest().getLocalParameters().get("baseUrl");
			
			WebDriver driver = LocalDriverFactory.createInstance(browserName, baseUrl);
			
			LocalDriverManager.setWebDriver(driver);
		}
	}


	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		if(method.isTestMethod()){
			WebDriver driver = LocalDriverManager.getWebDriver();
			LocalDriverFactory.closeBrowser(driver);
		}	
	}
}
