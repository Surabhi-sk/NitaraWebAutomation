package com.nitaraweb.pages;

import com.nitaraweb.base.GenericBase;

public class BasePage extends GenericBase {
	
	public void launchURL(String url) {
		driver.get(url);
	}

}
