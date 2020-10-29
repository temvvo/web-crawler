package com.crawler.app.calculator;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import info.debatty.java.stringsimilarity.interfaces.NormalizedStringDistance;
import org.jsoup.nodes.Element;

import java.util.List;


public class TextDistanceCalculator {
	private NormalizedStringDistance nsd = new NormalizedLevenshtein();

	public Element findSimilarElement(String source, List<Element> targetElements) {
		//TODO: Set mminDistance in app properties file
		var wrapper = new Object() {
			double minDistance = 1.0F;
			Element similarElement = null;
		};

		targetElements.forEach(element -> {
			double compareDistance = nsd.distance(
					source,
					element.attributes().toString()
			);
			if (compareDistance < wrapper.minDistance) {
				wrapper.minDistance = compareDistance;
				wrapper.similarElement = element;
			}
		});
		return wrapper.similarElement;
	}
}