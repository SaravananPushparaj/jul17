package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Searchbtn;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Searchtxtbox;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	
	
	
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_Searchbtn()
	{
		Searchbtn.click();
	}

	public void Enter_Searchtxtbox(String Value)
	{
		Searchtxtbox.sendKeys(Value +"\n");
	}
	
	public String get_Invalidmsg()
	{
		return Invalid_msg.getText();
	}
	
	public String get_Validmsg()
	{
		return Valid_msg.getText();
	}
	
}
