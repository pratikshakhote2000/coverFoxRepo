package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	public static String readDataFRomExcelSheet(int row,int cell) throws EncryptedDocumentException, IOException {
        Reporter.log("Reading data from Excel sheet", true);
		FileInputStream myfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\coverFoxData.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}
	
	public static void takesScreenshot( WebDriver  driver,String TCID) throws IOException
	{
		Reporter.log("Taking Screenshot", true);

		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Software_T\\SeleniumScreenshot\\coverFox"+TCID+timestamp+".png");
		Reporter.log("Saved Screenshot at"+dest, true);

		FileHandler.copy(src, dest);
		
		
	}
	public static void ScrollintoView(WebDriver driver,WebElement element )
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		 js.executeScript("argument[0].scrollIntoView();",element);

	}
	public static void ImplicitWait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}



}
