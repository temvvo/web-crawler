package com.crawler.app.parser;

import com.crawler.app.domain.entity.HtmlButton;
import org.jsoup.nodes.Element;

//@Mapper
public class ElementMapper {

	//@Mapping(target = "allAtributesSplitted", source = "toString")
	//@Mapping(expression = "java( String.valueOf(source) )", target = "allAtributesSplitted")
	//@Mapping(expression = "java( source.toString())", target = "allAtributesSplitted")
	public static HtmlButton map(Element element) {
		return HtmlButton.builder().allAtributesSplitted(element.toString()).id(element.id()).tagName(element.tagName()).build();
	}
}
