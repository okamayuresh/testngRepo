package root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;

public class CreateSuite {

	public static void main(String args[]){
		
		TestNG tng = new TestNG();
		TestListenerAdapter tla = new TestListenerAdapter();
		ArrayList<XmlSuite> suites = new ArrayList<XmlSuite>();
		ArrayList<XmlClass> classes = new ArrayList<XmlClass>();
		
		XmlSuite suite = new XmlSuite();
		int verbose=1;
		String listener = "root.WebDriverListener";
		suite.setName("Test");
		suite.setVerbose(verbose);
		suite.setParallel(ParallelMode.CLASSES);
		suite.setThreadCount(6);
		suite.addListener(listener);
		
		
		XmlTest test = new XmlTest(suite);
		test.addParameter("browserName", "chrome");
		test.addParameter("baseUrl", "http://google.com");
		test.setName("Test");
		test.setPreserveOrder(true);
		
//		Map<String,String> params = new HashMap<String,String>();
//		params.put("temp1", "1");
		
		for(int i=0;i<10;i++){
			XmlClass xmlClass = new XmlClass("testClasses.Test"+i);
			classes.add(xmlClass);
		}
		
		test.setXmlClasses(classes);
		suites.add(suite);
		
		tng.setXmlSuites(suites);
		tng.addListener(listener);
		tng.run();
	}
}
