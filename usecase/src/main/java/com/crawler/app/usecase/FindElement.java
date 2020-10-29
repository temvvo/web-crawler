package com.crawler.app.usecase;

import com.crawler.app.domain.entity.HtmlElement;
import com.crawler.app.domain.entity.Input;
import com.crawler.app.usecase.port.TextCrawlerPort;
import com.crawler.app.usecase.validator.InputValidator;
import lombok.RequiredArgsConstructor;

import java.io.IOException;


@RequiredArgsConstructor
public class FindElement {

	//TODO: Use properties @default from configuration properties file
	final String DEFAULT_TARGET_ELEMENT_ID = "make-everything-ok-button";
	private final TextCrawlerPort textCrawlerPort;


	public HtmlElement findInOrigin(String id, String path) {

		try {
			return textCrawlerPort.findInOrigin(id, path);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public HtmlElement findInTarget(HtmlElement element, String path) {

		try {
			return textCrawlerPort.findInTarget(element, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Input CreateUserInput(String[] args) {


		InputValidator.validateInput(args);
		if (args.length > 2) {
			return Input.builder().originFilePath(args[0]).sampleFilePath(args[1]).originalElementId(args[2]).build();
		}
		return Input.builder().originFilePath(args[0]).sampleFilePath(args[1])
				.originalElementId(DEFAULT_TARGET_ELEMENT_ID).build();
	}
}
