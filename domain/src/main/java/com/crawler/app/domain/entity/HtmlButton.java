package com.crawler.app.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder
@EqualsAndHashCode(callSuper = false)
public class HtmlButton implements HtmlElement {
	public String id, allAtributesSplitted, tagName, elementPath;
}
