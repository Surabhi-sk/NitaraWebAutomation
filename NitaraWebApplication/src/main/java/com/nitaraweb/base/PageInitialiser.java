package com.nitaraweb.base;

import com.nitaraweb.pages.AmazonHomePage;
import com.nitaraweb.pages.BasePage;
import com.nitaraweb.pages.NitaraHomePage;
import com.nitaraweb.pages.NitaraLoginPage;


public class PageInitialiser {

	protected static AmazonHomePage amazonHomePage;
	protected static BasePage basePage;
	protected static NitaraHomePage nitaraHomePage;
	protected static NitaraLoginPage nitaraLoginPage;

	
	public static void initializeAllPages() {

		amazonHomePage = new AmazonHomePage();
		basePage = new BasePage();
		nitaraHomePage = new NitaraHomePage();
		nitaraLoginPage = new NitaraLoginPage();

	}
	
	

}
