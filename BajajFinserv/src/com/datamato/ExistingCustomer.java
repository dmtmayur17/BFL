package com.datamato;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class ExistingCustomer 
{
	//ExistingCustomer exe_Cust = new ExistingCustomer();

	//String workingDevice = "emulator-5554";
	
	
	
	public static void main(String[] args) throws InterruptedException {
		String workingDevice = "a315e67c";
		AppiumDriver<WebElement> driver = null;
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("deviceName", "OnePlus5T");
		 caps.setCapability("udid", workingDevice);
		 caps.setCapability("platformName", "Android");
		 caps.setCapability("platformVersion", "9.0");
		 caps.setCapability("appPackage", "com.BajajServiceApp.VikramUAT");
		 //caps.setCapability("appPackage", "org.altruist.BajajExperia");
		 caps.setCapability("appActivity", "com.BajajServiceApp.VikramUAT.MainActivity");
		 //caps.setCapability("appActivity", "org.altruist.BajajExperia.MainActivity");
		 
		 caps.setCapability("noReset", "true");
		 try {
		  driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		 } 
		 catch (MalformedURLException e)
		 {
			 System.out.println(e.getMessage());
		 }
		 System.out.println("Clicking");
		/*WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View' and ./*[./*[@class='android.widget.Image']] and ./*[@text='Existing Customer']]")));
		element.click();*/
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//android.view.View[@index='4']")).click();
		 System.out.println("Clicked");

	
	
	}
}	




