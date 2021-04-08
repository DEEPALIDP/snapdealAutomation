package com.pageFactory;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class HomePage {
	private Pojo pojo;
	public HomePage(Pojo pojo) {
		this.pojo=pojo;
	}

	By lnkLinks=By.tagName("a");
	
	By lnkElectronics =By.xpath("//ul[@class='nav smallNav']/child::li[3]");
	By lnkSpeaker =By.linkText("Speakers");
	By lnkHomeAudio = By.linkText("Home Audio Systems");
	By lnkBluetooth =By.linkText("Bluetooth Speakers");
	By lnkSpeak =By.xpath("//span[text()='2.1 & 2.0 Speakers']");
	By reviews=By.xpath("//label[@for='avgRating-4.0']");
	By product = By.xpath("//p[@class='product-title']");
	By price =By.xpath("//span[@class='lfloat product-price']");
	By ratings = By.xpath("//span[@class='total-rating showRatingTooltip']");
	By review=By.xpath("//span[@class='numbr-review']");
	By getReviews =By.xpath("//div[@class='head']");
	
	public void getOnHomePageAllLinksCount()
	{
		pojo.getwrapper().getAllLink(lnkLinks);
		
	}
	public void GetOnHomePageList() throws IOException 
	{
		List<WebElement> list = pojo.getDriver().findElements(lnkLinks);
		 for (int i = 0; i < list.size(); i++) {
			 //writting text in other page
			String links = list.get(i).getText();
			FileWriter fw=new FileWriter("./src/test/resources/file/txtFile.txt",true);
			PrintWriter out=new PrintWriter(fw);
			out.println(links);
			out.close();
			
			
			String url = list.get(i).getAttribute("href");
			FileWriter fw1=new FileWriter("./src/test/resources/file/url.txt",true);
			PrintWriter out1=new PrintWriter(fw1);
			out1.println(url);
			out1.close();
	}	
		 
		
	}
	public void clickOnHomePageElectronicsPage()
	{
		pojo.getwrapper().click(lnkElectronics);
	}
	public void click1()
	{
		pojo.getwrapper().click(lnkElectronics);
	}
	public String ClickOnRandomSpeakers()
	{
		WebElement home=pojo.getDriver().findElement(lnkHomeAudio);
		WebElement bluetooth = pojo.getDriver().findElement(lnkBluetooth);
		WebElement spea=pojo.getDriver().findElement(lnkSpeak);
		
		ArrayList<WebElement> list=new ArrayList<WebElement>();
		list.add(home);
		list.add(bluetooth);
		list.add(spea);
		Random random= new Random();
		int randomValue=random.nextInt(list.size());
		 WebElement value = list.get(randomValue);
         String str = value.getText();
         value.click();
		return null;
		
		}
	public void clickOnHomePageReviews()
	{
		pojo.getwrapper().click(reviews);
	}
	public void getAllLInkFromSpeakersPage()
	{
		pojo.getwrapper().waitForElementPresence(product);
		List<WebElement>list=pojo.getDriver().findElements(product);
		for(WebElement item:list)
		{
			System.out.println(item.getText());
		}
	}
	public void getPriceOfAllProducts()
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		List<WebElement>pric=pojo.getDriver().findElements(price);
		for(int i=0;i<pric.size();i++)
		{
			System.out.println(pric.get(i).getAttribute("data-price"));
			String number= pric.get(i).getAttribute("data-price");
			int num1=Integer.parseInt(number);
			list.add(num1);
			
		}
		Integer maxnum= Collections.max(list);
		System.out.println(maxnum);
		int index = list.indexOf(maxnum);
		System.out.println("index of large"+index);
		pric.get(index).click();
		
	}
	public void getRatings()
	{
		pojo.getwrapper().windowHandling();
	String str=	pojo.getDriver().findElement(ratings).getText();
	System.out.println(str);
	}
	public void getReview()
	{
		 String str1=pojo.getDriver().findElement(review).getText();
		 System.out.println(str1);
	}
	public void clickOnReviews() throws IOException
	{
		pojo.getwrapper().click(review);
		List<WebElement> list=pojo.getDriver().findElements(getReviews);
		for (int i = 0; i < 1; i++) {
			 //writting text in other page
			String review = list.get(i).getText();
			FileWriter fw=new FileWriter("./src/test/resources/file/review.txt",true);
			PrintWriter out=new PrintWriter(fw);
			out.println(review);
			out.close();
		 }
	}
	
		
}
