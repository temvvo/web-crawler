package com.crawler.app;

import com.crawler.config.AppConfig;

public class Main {
	public static void main(String[] args) {
		// Setup
		var config = new AppConfig();
		var findElement = config.getUseCase();

		// Create User Input domain object
		var userInput = findElement.CreateUserInput(args);

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
