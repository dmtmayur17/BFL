package com.datamato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


//import com.datamato.ExistingCustomer;

public class PersonalLoan extends Driver
{
	

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




@AfterClass
public void connectionClose(){

 driver.close();
}
}
