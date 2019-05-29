package com.datamato;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver
{
	
	public WebElement pocketinsurance;

	 //String workingDevice = "192.168.30.146:5555";
	String workingDevice = "d6f08719";// a315e67c d6f08719
	AppiumDriver<MobileElement> driver = null;
	DesiredCapabilities caps = new DesiredCapabilities();


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
}
