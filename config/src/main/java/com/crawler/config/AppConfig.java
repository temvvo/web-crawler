package com.crawler.config;

import com.crawler.app.calculator.TextDistanceCalculator;
import com.crawler.app.domain.entity.Input;
import com.crawler.app.usecase.FindElement;
import com.crawler.app.parser.HtmlParser;
import com.crawler.app.port.HtmlFileCrawlerPort;
import com.crawler.app.usecase.port.TextCrawlerPort;
import com.crawler.validator.InputValidator;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//import org.springframework.context.annotation.Configuration;

//@Configuration
@RequiredArgsConstructor
@Builder
//@ConfigurationPropertiesScan
public class AppConfig {
	//TODO: let spring do the Dependency Injection
	private final ConfigurationProperties props ;


	public FindElement getUseCase() {
		final HtmlParser parser = HtmlParser.builder().charset(props.getCharset()).build();
		final TextDistanceCalculator textDistanCalculator = TextDistanceCalculator.builder().minDist(props.getMinDist()).build();
		final TextCrawlerPort textCrawlerPort = HtmlFileCrawlerPort.builder().parser(parser)
				.textDiscanceCalc(textDistanCalculator).build();
		return FindElement.builder().textCrawlerPort(textCrawlerPort).build();
	}

	public Input createUserInput(String[] args) {
				InputValidator.validateInput(args);
		return Input.builder().originFilePath(args[0]).sampleFilePath(args[1])
				.originalElementId(args.length>2?args[2]:props.getElementId()).build();
	}
}
