package com.crawler.app;

import com.crawler.config.AppConfig;
import com.crawler.config.ConfigurationProperties;

public class Main {
	public static void main(String[] args) {
		final String ELEMENT_ID = "make-everything-ok-button";
		final String CHARSET = "utf8";
	    final double MIN_DIST = 1.0F;
		// Setup

		var  config = AppConfig.builder().props(ConfigurationProperties.builder().charset(CHARSET)
				.elementId(ELEMENT_ID).minDist(MIN_DIST).build()).build();


		var findElement = config.getUseCase();

		// Create User Input
		var userInput = config.createUserInput(args);

		// Get element by id
		var element = findElement.findInOrigin(userInput.getOriginalElementId()
				, userInput.getOriginFilePath());
		System.out.println("Origin - Element: " + element.getAllAtributesSplitted());

		//Get similar element from target
		var foundElement = findElement.findInTarget(element, userInput.getSampleFilePath());
		System.out.println("target found element: " + foundElement.getAllAtributesSplitted());
		System.out.println("Element path in target: " + foundElement.getElementPath());

	}
}
