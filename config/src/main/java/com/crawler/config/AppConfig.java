package com.crawler.config;

import com.crawler.app.calculator.TextDistanceCalculator;
import com.crawler.app.usecase.FindElement;
import com.crawler.app.parser.HtmlParser;
import com.crawler.app.port.HtmlFileCrawlerPort;
import com.crawler.app.usecase.port.TextCrawlerPort;


public class AppConfig {
	//TODO: let spring do the Dependency Injection
	private final HtmlParser parser = new HtmlParser();
	private final TextDistanceCalculator textDistanCalculator = new TextDistanceCalculator();
	private final TextCrawlerPort textCrawlerPort = new HtmlFileCrawlerPort(parser, textDistanCalculator);

	public FindElement getUseCase() {
		return new FindElement(textCrawlerPort);
	}
}
