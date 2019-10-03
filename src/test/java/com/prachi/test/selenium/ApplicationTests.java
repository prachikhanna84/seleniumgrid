package com.prachi.test.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void keypress() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "../../chrome/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://formy-project.herokuapp.com/keypress");

		WebElement name = driver.findElement(By.id("name"));
		name.click();
		name.sendKeys("Prachi Khanna");
		Thread.sleep(5000);
		WebElement button = driver.findElement(By.id("button"));
		button.click();
		Thread.sleep(5000);

		driver.quit();
	}

	@Test
	public void testSeleniumGridGoogleSearch() throws InterruptedException, MalformedURLException {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
//		System.setProperty("webdriver.chrome.driver", "../../chrome/chromedriver.exe");
		DesiredCapabilities capablity = new DesiredCapabilities();
		capablity.setBrowserName("chrome");
		capablity.setPlatform(Platform.WIN10);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.77:4444/wb/hub"),capablity);
		driver.get("http://www.google.com/");
		Thread.sleep(5000);  // Let the user actually see something!
		driver.quit();
	}

	@Test
	public void testGoogleSearch() throws InterruptedException {
		// Optional. If not specified, WebDriver searches the PATH for chromedriver.
		System.setProperty("webdriver.chrome.driver", "../../chrome/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		Thread.sleep(5000);  // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ChromeDriver");
		searchBox.submit();
		Thread.sleep(5000);  // Let the user actually see something!
		driver.quit();
	}

	@Test
	public void autocomplete() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","../../chrome/chromedriver.exe");

		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://formy-project.herokuapp.com/autocomplete");

		WebElement autocomplete = webDriver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("1319 cascade bay palatine IL");
		Thread.sleep(1000);
		WebElement selectAddress = webDriver.findElement(By.className("pac-item"));
		selectAddress.click();
	}

	@Test
	public void scrollPage() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","../../chrome/chromedriver.exe");

		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://formy-project.herokuapp.com/scroll");

		WebElement name = webDriver.findElement(By.id("name"));
		Actions action = new Actions(webDriver);
		action.moveToElement(name);
		name.sendKeys("Prachi Khanna");
		Thread.sleep(1000);
		WebElement date = webDriver.findElement(By.id("date"));
		date.sendKeys("12/12/2019");
//		selectAddress.click();
	}
}
