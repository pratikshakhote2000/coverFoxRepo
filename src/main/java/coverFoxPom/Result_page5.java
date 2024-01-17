package coverFoxPom;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Result_page5 {
	
	
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement gettingText;
	@FindBy(id = "plans-list") private List<WebElement> allPlaneList;
	
	public Result_page5(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public int  availablePlanNumberFromText()
	{
		String test = gettingText.getText();   //49 matching health insurance plan
		
	 	 String ar[]=test.split(" ");
	 	 
	 	 String numberOfResultInString = ar[0];    //convert string into integer
	 	 
	 	 int numberOfResultInInt = Integer.parseInt(numberOfResultInString);    //49 string covert into integer
		return numberOfResultInInt;
	 	 
	}
	
	public int availablePlanNumberFromBanner()
	{
	int totalNumOfElement = allPlaneList.size();
	return  totalNumOfElement;
	
	 	 
	}

}
