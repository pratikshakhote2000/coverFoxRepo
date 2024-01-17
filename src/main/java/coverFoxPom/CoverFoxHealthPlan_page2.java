package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealthPlan_page2 {
	
	@FindBy(className = "next-btn") private WebElement nextButton;

	
	
	
	public CoverFoxHealthPlan_page2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public void  clickOnNextButton()
	{
		nextButton.click();
	}


}
