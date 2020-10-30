package com.crawler.app.parser;

import lombok.Builder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Builder
public class HtmlParser {

	//TODO: get config from properties file
	//private static final String CHARSET_NAME = "utf8";
	private String charset;

	public Element getElementById(String id, String path) throws IOException {
		File file = new File(path);
		Document doc = Jsoup.parse(
				file,
				charset,
				file.getAbsolutePath());

		return doc.getElementById(id);
	}

	public List<Element> getElementsInTag(String path, String sourceTagName) throws IOException {
		File file = new File(path);
		Document doc = Jsoup.parse(
				file,
				charset,
				file.getAbsolutePath());
		return doc.select(sourceTagName);
	}
}
