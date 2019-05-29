package com.datamato;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class PocketInsurance extends Driver
{
	int i = 1;
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


	public List<MobileElement> getItemWebView() throws InterruptedException
	{
		//return (List<MobileElement>) driver.findElements(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
		return (List<MobileElement>) driver.findElements(By.xpath("((((//*[@id='tabpanel-t0-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]"));
	}

	public void scrollTillWebView() throws InterruptedException
	{	
			while(getItemWebView().size() == 1)
			{
				if(i<8)
				scrollDownDown();
				else break;
			}
		
		if(i >=8)//getItemWebView().size() > 1
		{
			getItemWebView().get(0).click();
		}
		Thread.sleep(4000);
		
	}
	@Test(priority = 1)
	public void PocketInsurance1() throws InterruptedException
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

	@Test(priority = 2)
	public void PocketInsuranceClickTravel() throws InterruptedException
	{
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 20);
			
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View' and ./*[@class='android.widget.Image'] and ./*[@text='Travel']]")));	
		element.click();														
		
		String verifyWeCameInTravel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Travel' and @class='android.view.View']"))).getText();
		Assert.assertEquals(verifyWeCameInTravel, "Travel");
		
		

	}
	@Test(priority = 3)
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
	@Test(priority = 4)
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

	@Test(priority = 5)
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
	
	
	
	
}	




