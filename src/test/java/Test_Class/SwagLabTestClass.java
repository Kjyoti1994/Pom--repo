package Test_Class;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFile.BaseClass;
import LibraryFile.UtilityClass;
import POMClass.SwagLabHomePage;
import POMClass.SwagLabLoginPage;
import POMClass.SwagLabMenuPage;

public class SwagLabTestClass extends BaseClass
{
	SwagLabLoginPage login;    //declare globally all pom class
	SwagLabHomePage  home;
	SwagLabMenuPage menu;
	int TCID;
	@BeforeClass         //Browser open karnai tak ka procedure
public void openBrowser() throws EncryptedDocumentException, IOException 
	{
		initializeBrowser();

	login=new SwagLabLoginPage(driver);
	home=new SwagLabHomePage(driver);
	menu =new SwagLabMenuPage(driver);
}
	@BeforeMethod
public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException 
{
	login.inpSwagLabLoginPageUN(UtilityClass.getdatafromPF("UN"));
	Thread.sleep(2000);
	login.inpSwagLabLoginPagePWD(UtilityClass.getdatafromPF("PWD"));
	Thread.sleep(2000);
	login.clickSwagLabLoginPageLoginBtn();
	Thread.sleep(2000);
}	
	@Test
	public void verifyTitle() throws EncryptedDocumentException, IOException 
	{
		TCID=101;
	String expected =UtilityClass.data(0, 2);	
	String actual=home.SwagLabHomePageTitle();
	Assert.assertEquals(actual, expected,"TC1 failed");
	}
	
	@Test
	public void addToCart() 
	{
		TCID=102;
	home.clickSwagLabHomePageAddToCartBtn();
	home.clickSwagLabHomePageCartLogo();
	}
	@AfterMethod
	public void logoutFromApp(ITestResult SSID) throws InterruptedException, IOException 
	{
		if(SSID.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver,TCID );	
		}
		home.clickSwagLabHomePageMenuBtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPageLogoutBtn();
		//UtilityClass.captureSS(driver,101 );
	}
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
	
}
