package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass extends Pojo {
	
	@Test
	public void initializeBrowserSetup()
	{
	
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		setDriver(new ChromeDriver());
		getDriver().get("https://www.snapdeal.com/");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		objwrapper =new WrapperFunction(this);
	}

}
