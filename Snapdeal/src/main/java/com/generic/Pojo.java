package com.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {

	private static WebDriver driver;
	WrapperFunction objwrapper;
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	public WrapperFunction getwrapper()
	{
		return objwrapper;
	
	}
	public void setWrapper()
	{
		this.objwrapper=objwrapper;
	}
}
