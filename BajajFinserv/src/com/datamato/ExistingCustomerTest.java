package com.datamato;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


//import com.datamato.ExistingCustomer;



public class ExistingCustomerTest
{
	int i = 1;
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"POCKET INSURANCE\"))")
	public WebElement pocketinsurance;

	 //String workingDevice = "192.168.30.146:5555";
	String workingDevice = "d6f08719";// a315e67c d6f08719
	AppiumDriver<MobileElement> driver = null;
	DesiredCapabilities caps = new DesiredCapabilities();

public void scrollDownDown()
{
	i++;
	//System.out.println("Size of Mobile: " +driver.manage().window().getSize());
	Dimension dimention = driver.manage().window().getSize();
	
	Double scrollHeightStart = dimention.getHeight() * 0.5;
	int scrollStart = scrollHeightStart.intValue();
	
	Double scrollHeightEnd = dimention.getHeight() * 0.2;
	int scrollEnd = scrollHeightEnd.intValue();
	
	new TouchAction<>(driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
}

/*public List<MobileElement> getItemViews()
{
	return (List<MobileElement>) driver.findElements(By.xpath("//*[@text='rec offers-outline Recommended']"));
}*/
public List<MobileElement> getItemWebView() throws InterruptedException
{
	//Thread.sleep(3000);
	//System.out.println("In List:");
	//System.out.println("Size of List First time: "+getItemWebView().size());
	
	//return (List<MobileElement>) driver.findElements(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
	return (List<MobileElement>) driver.findElements(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]")));
}

public void scrollTillWebView() throws InterruptedException
{	
	// driver.findElement(By.xpath("//*[@text='rec offers-outline Recommended']")).click();
		while(getItemWebView().size() == 1)
		{
			//System.out.println("Calling scroll");
			if(i<8)
			scrollDownDown();
			else break;
		}
	
	if(i >=8)//getItemWebView().size() > 1
	{
		//System.out.println("Clicking scroll");
		//System.out.println("Clicking scroll: " +getItemWebView().get(0));
		getItemWebView().get(0).click();
		//driver.findElements(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
	}
	Thread.sleep(4000);
	
}

public void scrollTillText(String exactText)
{
	
	//((AndroidDriver<MobileElement>)driver).findElementByAndroidUIAutomator(
		//	"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+exactText+"\").instance(0))").click();
	
			//WebElement el = driver.findElement(MobileBy
			//                    .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
			//                            + "new UiSelector().text(\""+exactText+"\"));"));
			
	
	
	//Identify an element using Resource ID Matches (Regular Expression)
	//searchBox = ((AndroidDriver<MobileElement>)driver).findElementByAndroidUIAutomator("new UiSelector().resourceIdMatches(\".*:id/search_box_idle_text\")");
	//System.out.println("Search Box Name [RegEx] - " + searchBox.getAttribute("name"));
	
}

@BeforeClass
public void connectionInit() {

 caps.setCapability("deviceName", "OnePlus5T");
 caps.setCapability("udid", workingDevice);
 caps.setCapability("platformName", "Android");
 caps.setCapability("platformVersion", "9.0");
 caps.setCapability("appPackage", "com.BajajServiceApp.VikramUAT");
 //caps.setCapability("appPackage", "org.altruist.BajajExperia");
 caps.setCapability("appActivity", "com.BajajServiceApp.VikramUAT.MainActivity");
 //caps.setCapability("appActivity", "org.altruist.BajajExperia.MainActivity");
 caps.setCapability("noReset", "true");
 
 try
 {
	 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 } catch (MalformedURLException e) {
  System.out.println(e.getMessage());
 }
}

@Test(priority= 0)
public void existingUserORNewUser() throws InterruptedException
{

	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
 
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View' and ./*[./*[@class='android.widget.Image']] and ./*[@text='Existing Customer']]"))); ////driver.findElement(By.xpath("//android.view.View[@index='4']")).click();*/
	element.click();
	
	Thread.sleep(3000);
	String typeOfUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN TO ACCESS CUSTOMER SERVICE']"))).getText();	
	Assert.assertEquals(typeOfUserLogin, "LOG IN TO ACCESS CUSTOMER SERVICE");	
}

@Test(dependsOnMethods = "existingUserORNewUser")
public void existingUserLoginPage() throws InterruptedException
{

	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]")));	
	element.sendKeys("163961");  //163961 64542461
	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]]")));	
	element.sendKeys("Bajaj@123"); //Bajaj@123 77982270 
	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOGIN']")));
	element.click();
	
	Thread.sleep(3000);
	String LoggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Active Relations' and @class='android.view.View']"))).getText();
	Assert.assertEquals(LoggedIn, "Active Relations");
}

@Test(dependsOnMethods = "existingUserLoginPage")
public void recommendedOffersPage() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='rec offers-outline Recommended']")));
	element.click();
	
	Thread.sleep(3000);
	String recommendedOffers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Recommended Offers' and @class='android.view.View']"))).getText();
	Assert.assertEquals(recommendedOffers, "Recommended Offers");
	
}

@Test(dependsOnMethods = "recommendedOffersPage")
public void PersonalLoanCalculator() throws InterruptedException
{
	
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	//Calculator
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='CALCULATOR'])[1]")));	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='CALCULATORS'])[1]")));
	
	element.click();
	String calculatorDisplayedStringOnApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Flexi Interest-only Loan EMI Calculator' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View' and ./*[@text='Home']]]"))).getText();
																											   
	Assert.assertEquals(calculatorDisplayedStringOnApp, "Flexi Interest-only Loan EMI Calculator");	
	Thread.sleep(7000);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='close button']")));	
	element.click();
}

@Test(dependsOnMethods = "PersonalLoanCalculator")
public void PersonalLoanApplyNow() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	//Apply now
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='APPLY NOW'])[1]")));	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='APPLY NOW'])[1]")));
	
	element.click();
	String applyNowDisplayedStringOnApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Getting Personal Loans couldn’t be quicker!']"))).getText();
	Assert.assertEquals(applyNowDisplayedStringOnApp, "Getting Personal Loans couldn’t be quicker!"); 
	Thread.sleep(2000);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='close button']")));	
	element.click();
																				
}

@Test(dependsOnMethods = "PersonalLoanApplyNow")
public void PersonalLoanSeeDetails() throws InterruptedException
{

	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	//See Details
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[1]")));
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[1]")));
	
	element.click();
	String seeDetailsDisplayedStringOnApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Personal Loan' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Home']]]"))).getText();
	Assert.assertEquals(seeDetailsDisplayedStringOnApp, "Personal Loan");
	Thread.sleep(2000);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='close button']")));	
	element.click();

}

@Test(dependsOnMethods = "PersonalLoanSeeDetails")
public void PocketInsurance() throws InterruptedException
{
	//WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	scrollTillWebView();
	
	String seeDetailsTypeOfInsuranceOnApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='TYPES OF INSURANCE']"))).getText();
	Assert.assertEquals(seeDetailsTypeOfInsuranceOnApp, "TYPES OF INSURANCE");
		
	//*[@class='android.view.View' and ./*[@class='android.widget.Image'] and ./*[@text='Lifestyle']]
	//*[@class='android.view.View' and ./*[@class='android.view.View' and ./*[@text='Assistance'] and ./*[@class='android.widget.Image']]]
	//*[@class='android.view.View' and ./*[@class='android.widget.Image'] and ./*[@text='Health']]
}

@Test(dependsOnMethods = "PocketInsurance")
public void PocketInsuranceClickTravel() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
		
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View' and ./*[@class='android.widget.Image'] and ./*[@text='Travel']]")));	
	element.click();														
	
	String verifyWeCameInTravel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Travel' and @class='android.view.View']"))).getText();
	Assert.assertEquals(verifyWeCameInTravel, "Travel");
	
	

}

@Test(dependsOnMethods = "PocketInsuranceClickTravel")
public void PocketInsuranceTravelBrochure() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BROCHURE' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='PILGRIMAGE COVER']]]]")));	
	element.click();															
	
	//String verifyWeCameBrochure = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Pilgrimage.pdf']"))).getText();
	String verifyWeCameBrochure = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='atm-assault-robbery.pdf']"))).getText();
	
	//Assert.assertEquals(verifyWeCameBrochure, "Pilgrimage.pdf");
	Assert.assertEquals(verifyWeCameBrochure, "atm-assault-robbery.pdf");
	
	Thread.sleep(2000);
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='Navigate up']")));	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='Navigate up']")));
	element.click();

}
@Test(dependsOnMethods = "PocketInsuranceTravelBrochure")
public void PocketInsuranceTravelKnowMore() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
		
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='KNOW MORE' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='PILGRIMAGE COVER']]]]")));	
	element.click();														
	
	String verifyWeCameBrochure = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Prompt services for a worry-free pilgrimage']"))).getText();
	Assert.assertEquals(verifyWeCameBrochure, "Prompt services for a worry-free pilgrimage");
	
	Thread.sleep(2000);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='arrow back']")));	
	
	element.click();	
	

}

@Test(dependsOnMethods = "PocketInsuranceTravelKnowMore")
public void PocketInsuranceTravelApplyNow() throws InterruptedException
{
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 20);	
		
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[2]/*/*[@text='APPLY NOW'])[1]")));	
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[2]/*/*[@text='APPLY NOW'])[1]")));
	
	element.click();
	
	String verifyWeCameApplyNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Pilgrimage Holiday Insurance- Application Form']"))).getText();
	Assert.assertEquals(verifyWeCameApplyNow, "Pilgrimage Holiday Insurance- Application Form");
	
	Thread.sleep(2000);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@contentDescription='close button']")));	
	element.click();	
}


@AfterClass
public void connectionClose(){

 driver.close();
}
}
