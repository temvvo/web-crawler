package com.crawler.app.calculator;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import info.debatty.java.stringsimilarity.interfaces.NormalizedStringDistance;
import lombok.Builder;
import org.jsoup.nodes.Element;

import java.util.List;

@Builder
public class TextDistanceCalculator {
	//TODO: IOC in config
	private final NormalizedStringDistance nsd = new NormalizedLevenshtein();
	private double minDist; // 1.0F

	public Element findSimilarElement(String source, List<Element> targetElements) {
		var wrapper = new Object() {
			double minDistance = minDist;
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