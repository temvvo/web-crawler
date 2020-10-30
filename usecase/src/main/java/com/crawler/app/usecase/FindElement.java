package com.crawler.app.usecase;

import com.crawler.app.domain.entity.HtmlElement;
import com.crawler.app.domain.entity.Input;
import com.crawler.app.usecase.port.TextCrawlerPort;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@Builder
@RequiredArgsConstructor
public class FindElement {

	//TODO: Use properties @default from configuration properties file
	//final String DEFAULT_TARGET_ELEMENT_ID = "make-everything-ok-button";
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
}
