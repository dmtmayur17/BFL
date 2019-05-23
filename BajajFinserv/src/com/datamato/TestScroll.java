package com.datamato;


//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class TestScroll {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeMethod
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "a315e67c");
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }

  @SuppressWarnings("rawtypes")
@Test
  public void testUntitled() {
      driver.findElement(By.xpath("//*[@text='Bajaj Finserv']")).click();
      driver.findElement(By.xpath("//*[@id='scrim_view']")).click();
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='scrim_view']")));
      driver.findElement(By.xpath("//*[@id='scrim_view']")).click();
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='scrim_view']")));
      driver.findElement(By.xpath("//*[@id='scrim_view']")).click();
      driver.findElement(By.xpath("//*[@contentDescription='Weather']")).click();
      driver.findElement(By.xpath("//*[@text='Payday']")).click();
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='layout']")));
      driver.findElement(By.xpath("//*[@id='layout']")).click();
      new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.view.View' and ./*[@text='#MakeForIndia']]")));
      driver.findElement(By.xpath("//*[@class='android.view.View' and ./*[@text='#MakeForIndia']]")).click();
      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='overview_panel']")));
      driver.findElement(By.xpath("//*[@id='overview_panel']")).click();
      driver.findElement(By.xpath("//*[@text='Bajaj Finserv']")).click();
      driver.findElement(By.xpath("//*[@text='Welcome To Bajaj Finserv' and @class='android.webkit.WebView']")).click();
      driver.findElement(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]")).click();
      driver.findElement(By.xpath("//*[@text='6']")).click();
      driver.findElement(By.xpath("//*[@text='GHI']")).click();
      driver.findElement(By.xpath("//*[@text='5']")).click();
      driver.findElement(By.xpath("//*[@text='4']")).click();
      driver.findElement(By.xpath("//*[@text='ABC']")).click();
      driver.findElement(By.xpath("//*[@text='GHI']")).click();
      driver.findElement(By.xpath("//*[@text='6']")).click();
      driver.findElement(By.xpath("//*[@text='1']")).click();
      driver.findElement(By.xpath("//*[@class='android.widget.EditText' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]]")).click();
      driver.findElement(By.xpath("//*[@text='7']")).click();
      driver.findElement(By.xpath("//*[@text='7']")).click();
      driver.findElement(By.xpath("//*[@text='9']")).click();
      driver.findElement(By.xpath("//*[@text='8']")).click();
      driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout' and ./*[@text='2']]")).click();
      driver.findElement(By.xpath("//*[@text='2']")).click();
      driver.findElement(By.xpath("//*[@text='7']")).click();
      driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout' and ./*[@text='0']]")).click();
      driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
      driver.findElement(By.xpath("//*[@text='Active Relations' and @class='android.webkit.WebView']")).click();
     // new TouchAction(driver).press(TouchAction<TouchAction<T>>).wa(461, 1526).waitAction(Duration.ofMillis(1820)).moveTo(326, 88).release().perform();
    //  new TouchAction(driver).press(500, 1550).waitAction(Duration.ofMillis(1462)).moveTo(288, 126).release().perform();
    //  new TouchAction(driver).press(538, 1723).waitAction(Duration.ofMillis(1022)).moveTo(400, 353).release().perform();
    //  new TouchAction(driver).press(469, 1530).waitAction(Duration.ofMillis(659)).moveTo(469, 792).release().perform();
      driver.findElement(By.xpath("((((//*[@id='tabpanel-t1-3']/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[2]/*/*[@text='SEE DETAILS'])[10]")).click();
  }

  @AfterMethod
  public void tearDown() {
      driver.quit();
  }
}