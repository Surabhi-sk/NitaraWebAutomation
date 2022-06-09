package com.nitaraweb.base;

import com.nitaraweb.pages.AmazonHomePage;
import com.nitaraweb.pages.BasePage;


public class PageInitialiser {

	protected static AmazonHomePage amazonHomePage;
	protected static BasePage basePage;

	
	
	public static void initializeAllPages() {

		amazonHomePage = new AmazonHomePage();
		basePage = new BasePage();
		
	}

}
