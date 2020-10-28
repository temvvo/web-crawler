package com.crawler.app;

import java.util.Arrays;
import com.crawler.config.AppConfig;

public class Main {
	public static void main(String[] args) {
		// Setup
		var config = new AppConfig();
		var findElement = config.getUseCase();
		Arrays.stream(args).forEach(System.out::println);

		// Create User Input domain object
		var userInput = findElement.CreateUserInput(args);

		// Get element by id
		var element = findElement.findInOrigin(userInput.getOriginalElementId(),userInput.getOriginFilePath());
		System.out.println("Main - HtmlElement: "+ element.getAllAtributesSplitted());

		//Get similar element from target
		var foundElement = findElement.findInTarget(element,userInput.getSampleFilePath());
		System.out.println("Similar - HtmlElement: "+ foundElement.getAllAtributesSplitted());

	}
}
