package LibraryFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{

	
	public static String data(int rowindex, int colindex) throws EncryptedDocumentException, IOException {
		//FileInputStream file=new FileInputStream("C:\\Users\\VINOD\\Desktop\\Jyoti Testing Folder\\Excel\\DDExcel.xlsx");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestDataFolder\\DDExcel.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("DDF1");
		String value = sh.getRow(rowindex).getCell(colindex).getStringCellValue();
		return value;
		
	}
	
	public static void captureSS(WebDriver driver,int TCID) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File dest=new File("C:\\jyoti\\eclipse-workspace\\TESTNG\\FailedTCScreenShot\\SwagTCID"+TCID+".jpg");
		File dest=new File(System.getProperty("user.dir")+"\\FailedTCScreenShot\\SwagTCID"+TCID+".jpg");
		
		FileHandler.copy(source, dest);
		
	}
	
	public static String getdatafromPF(String key) throws IOException {
		//FileInputStream file=new FileInputStream("C:\\jyoti\\eclipse-workspace\\TESTNG\\Property.properties");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Propertyfile.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
		
		}
}

