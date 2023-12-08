package ADTTest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ADTAdmissionFormTest_Convert_Chrges_OP_TO_IP
{
	public WebDriver driver;
	ATUTestRecorder recorder;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	Date date = new Date();
	
	@Test(priority=1)
	@Parameters({"Uesrid"})
	public void TC_01_verify_That_User_Is_Able_To_Login_ADT_Admission_Form_MedcareApplication(String Uesrid) throws InterruptedException, IOException
	{
		ADTpages.Login Loginapp=new ADTpages.Login(driver);
		Loginapp.login_Medcare(Uesrid);
	}
	@Test(priority=2)
	@Parameters({"MRNPar","LengthOfStayPar","AdmittingDiagPar","AddNotesPar","PatientNotesPar","AdmissionRemarksPar","ReferralRemarksPar","NamePar","IdentificationNOPar","PhoneNumberPar","AddressPar"})
	public void TC_02_Verify_User_Can_Fill_ADT_Admission_Form_Convert_Charges_For_OP_To_IP(String MRNPar,String LengthOfStayPar,String AdmittingDiagPar,String AddNotesPar,String PatientNotesPar,String AdmissionRemarksPar,String ReferralRemarksPar,String NamePar,String IdentificationNOPar,String PhoneNumberPar,String AddressPar) throws InterruptedException, IOException
	{
		ADTpages.ADTAdmissionFormwith_Convert_Charges_OP_To_IP ADT=new ADTpages.ADTAdmissionFormwith_Convert_Charges_OP_To_IP(driver);
		ADT.ADT_Admission_Form_Convert_Charges(MRNPar,LengthOfStayPar,AdmittingDiagPar,AddNotesPar,PatientNotesPar,AdmissionRemarksPar,ReferralRemarksPar,NamePar,IdentificationNOPar,PhoneNumberPar,AddressPar);
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException, ATUTestRecorderException 
	{
		
		recorder = new ATUTestRecorder(".//Videos//","ADTAdmissionFormTest_Convert_Chrges_OP_TO_IP-"+dateFormat.format(date),false);
		recorder.start();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://medcare-productqa.hatiintl.com/");
		Thread.sleep(8000);
		driver.manage().window().maximize(); 
	}
	@AfterMethod(alwaysRun=true)
	public void FailedScreenShot(ITestResult Result) throws IOException
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot1, new File(".//ScreenShotFailedTestCase//Failure_ADTAdmissionFormTest_Convert_Chrges_OP_TO_IP"+ dateFormat.format(date)));
		}
	}
	@AfterSuite
	public void quitBrowser() throws ATUTestRecorderException
	{
		driver.quit();
		recorder.stop();
	}
}
