package com.crawler.app.parser;

import com.crawler.app.domain.entity.HtmlButton;
import org.jsoup.nodes.Element;

//@Mapper
public class ElementMapper {

	//@Mapping(target = "allAtributesSplitted", source = "toString")
	//@Mapping(expression = "java( String.valueOf(source) )", target = "allAtributesSplitted")
	//@Mapping(expression = "java( source.toString())", target = "allAtributesSplitted")
	//TODO: solve mapping using mapstruct
	public static HtmlButton mapTarget(Element element) {
		return HtmlButton.builder().allAtributesSplitted(element.toString()).id(element.id()).tagName(element.tagName())
				.elementPath(fillPathDecorator(element)).build();
	}

	public static HtmlButton mapSource(Element element) {

		return HtmlButton.builder().allAtributesSplitted(element.toString()).id(element.id()).tagName(element.tagName())
				.build();
	}

	private static String fillPathDecorator(Element element) {
		StringBuilder decorator = new StringBuilder();

		for (int index = element.parents().size() - 1; index >= 0; index--) {
			Element parent = element.parents().get(index);
			fill(decorator, parent);
			decorator.append(" >");
		}
		fill(decorator, element);
		return decorator.toString();
	}


	private static void fill(StringBuilder decorator, Element element) {
		decorator.append(" ");
		decorator.append(element.tag());
		if (null != element.id() && 0 < element.id().length()) {
			decorator.append("#");
			decorator.append(element.id());
		} else if (null != element.className() && 0 < element.className().length()) {
			decorator.append(".");
			decorator.append(element.className());
		}
		if (element.tag().getName().equals("a")) {
			String href = element.attr("href");
			if (null != href) {
				decorator.append(" href=\"");
				decorator.append(href);
				decorator.append("\"");
			}
		}
	}
}
