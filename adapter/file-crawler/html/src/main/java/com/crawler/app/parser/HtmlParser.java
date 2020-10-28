package com.crawler.app.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HtmlParser {

	//TODO: get config from properties file
	private static final String CHARSET_NAME = "utf8";
	private static final String DEFAULT_ELEMENT_ID = "make-everything-ok-button";

	public Element getElementById(String id, String path) throws IOException {
		File file = new File(path);
		Document doc = Jsoup.parse(
			file,
			CHARSET_NAME,
			file.getAbsolutePath());

		return doc.getElementById(id);
	}

	public List<Element> getElementsInTag(String path, String sourceTagName) throws IOException {
		File file = new File(path);
		Document doc = Jsoup.parse(
			file,
			CHARSET_NAME,
			file.getAbsolutePath());

		//Elements elementsOriginTag = doc.select(originTag.getName());
		//List<Element> result = new ArrayList<>();
		//for (Element curElement : elementsOriginTag) {
		//	result.add(curElement);
		//}
		return doc.select(sourceTagName);

	}

//	private static List<Element> getElementsInTag(File htmlFile, String tagName) throws IOException {
//		Document doc = Jsoup.parse(
//			htmlFile,
//			CHARSET_NAME,
//			htmlFile.getAbsolutePath());
//
////		Elements elementsOriginTag = doc.select(tagName);
////		List<Element> result = new ArrayList<>();
////		for (Element curElement : elementsOriginTag) {
////			result.add(curElement);
////		}
//		return doc.select(tagName);
//	}
}
