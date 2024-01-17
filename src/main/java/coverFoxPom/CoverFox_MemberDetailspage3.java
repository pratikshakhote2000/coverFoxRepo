package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFox_MemberDetailspage3 {
	@FindBy(id = "Age-You") private WebElement ageDrpDown;
	@FindBy(className = "next-btn") private WebElement nextButtonOn3page;
	
	
	
	public CoverFox_MemberDetailspage3(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void dropDownHandle(String age)
	{
		ageDrpDown.click();
		
		Select s=new Select(ageDrpDown);
		s.selectByValue(age +"y");
	}
	
	public void clickOnnextButtonPage3()
	{
		nextButtonOn3page.click();
	}


}
