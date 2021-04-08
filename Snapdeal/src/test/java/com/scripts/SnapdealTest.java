package com.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.pageFactory.HomePage;

public class SnapdealTest extends BaseClass {
	private HomePage objHomePage;
	
	public void initializeviewandPages()
	{
		objHomePage=new HomePage(this);
	}
	
	@BeforeTest
	public void initialize()
	{
		this.initializeBrowserSetup();
		this.initializeviewandPages();
	}
	@Test
	public void SnapdealTest() throws IOException 
	{
		objHomePage.getOnHomePageAllLinksCount();
		//objHomePage.GetOnHomePageList();
		objHomePage.clickOnHomePageElectronicsPage();
		objHomePage.ClickOnRandomSpeakers();
		objHomePage.clickOnHomePageReviews();
		objHomePage.getAllLInkFromSpeakersPage();
		objHomePage.getPriceOfAllProducts();
		objHomePage.getRatings();
		objHomePage.getReview();
		objHomePage.clickOnReviews();
	}

}
