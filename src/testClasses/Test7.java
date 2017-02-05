package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import root.LocalDriverManager;

public class Test7 {
	
	private static WebDriver driver = null; 
  @Test
  public void f() {
	  driver = LocalDriverManager.getWebDriver();
  }
}
