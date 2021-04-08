package com.generic;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunction {
	private Pojo objPojo;
	private WebDriverWait wait;
	
	
	public WrapperFunction(Pojo objPojo) {
		this.objPojo=objPojo;
	}

	public void click(By locator)
	{
		objPojo.getDriver().findElement(locator).click();
	}
	public String getAllLink(By locator)
	{
		List<WebElement>list=objPojo.getDriver().findElements(locator);
		
		int sizeoflinks=list.size();
		System.out.println("SizeOfLinks="+sizeoflinks);
		return "";
	}
/*	public String getAllLinkList(By locator)
	{
		List<WebElement>list=objPojo.getDriver().findElements(locator);
		for(WebElement item1:list)
		{
			System.out.println(item1.getText());
		}
		return "";
	}*/
	public String getAllLinkList(By locator) 
	{
		List<WebElement>list=objPojo.getDriver().findElements(locator);
		try {
			for(int i=0;i<=list.size();i++)
			{ 
				String links=list.get(i).getText();
				FileWriter fw= new FileWriter("D:\\Deepali\\Snapdeal\\src\\test\\resources\\file\\txtFile.txt", true);
				PrintWriter    writer1 = new PrintWriter(fw); 
				writer1.println(links);
		        // writer1.flush();  
		         writer1.close(); 
		         return "";
			}
		} catch (Exception e) {
			System.out.println(e);	
			}
		
		return "";
	}
	public void waitForElementPresent(By locator)
	{
		wait=new WebDriverWait(objPojo.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public void waitForElementPresence(By locator)
	{
		wait=new WebDriverWait(objPojo.getDriver(),30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public void windowHandling()
	{
		String mainweb = objPojo.getDriver().getWindowHandle();
		Set <String> set = objPojo.getDriver().getWindowHandles();
	//	System.out.println(set);
		Iterator <String> itr = set.iterator();
		while(itr.hasNext())
		{
		
			String child = itr.next();
			if(!mainweb.equals(child))
			{
				objPojo.getDriver().switchTo().window(child);
				//System.out.println(driver.switchTo().window(child).getTitle());
		// driver.close();
		}
		}
		
		
		
			
 }
	
}
