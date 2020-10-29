package com.crawler.app.usecase.port;


import com.crawler.app.domain.entity.HtmlElement;

import java.io.IOException;

public interface TextCrawlerPort {

	HtmlElement findInOrigin(String id, String path) throws IOException;

	HtmlElement findInTarget(HtmlElement element, String path) throws IOException;
}
