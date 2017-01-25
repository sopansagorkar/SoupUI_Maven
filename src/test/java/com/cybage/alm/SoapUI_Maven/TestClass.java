package com.cybage.alm.SoapUI_Maven;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;

public class TestClass {

	WsdlProject project;
	TestSuite suite;
	TestCase testCase;
	TestCaseRunner run;

	@BeforeSuite
	public void setup() {
		try {
			project = new WsdlProject("src/main/resources/WeatherService-soapui-project.xml");
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SoapUIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void webSericeTest(){
		suite = project.getTestSuiteByName("WeatherTestSuite");
		testCase = suite.getTestCaseByName("TestCase1");
		run = testCase.run(null, false);
		System.out.println(run.getStatus());
	}


}
