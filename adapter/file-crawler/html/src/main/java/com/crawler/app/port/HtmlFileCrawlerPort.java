package com.crawler.app.port;

import com.crawler.app.calculator.TextDistanceCalculator;
import com.crawler.app.domain.entity.HtmlElement;
import com.crawler.app.parser.ElementMapper;
import com.crawler.app.parser.HtmlParser;
import com.crawler.app.usecase.port.TextCrawlerPort;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

//@RequiredArgsConstructor
public class HtmlFileCrawlerPort implements TextCrawlerPort {
	private HtmlParser parser;
	private TextDistanceCalculator tdc;
	private ElementMapper elementMapper;

	public HtmlFileCrawlerPort(HtmlParser parser, TextDistanceCalculator tdc) {
		this.parser = parser;
		this.tdc = tdc;
	}

	@Override
	public HtmlElement findInOrigin(String id, String path) throws IOException {
		return elementMapper.map(parser.getElementById(id, path));
	}

	@Override
	public HtmlElement findInTarget(HtmlElement element, String path) throws IOException {
		List<Element> sameTagElements = parser.getElementsInTag(path, element.getTagName());

		//String originAllAttrs = element.getAllAtributesSplitted();
		return elementMapper.map(tdc.findSimilarElement(element.getAllAtributesSplitted(), sameTagElements));

	}



}
