package com.crawler.app.port;

import com.crawler.app.calculator.TextDistanceCalculator;
import com.crawler.app.domain.entity.HtmlElement;
import com.crawler.app.parser.ElementMapper;
import com.crawler.app.parser.HtmlParser;
import com.crawler.app.usecase.port.TextCrawlerPort;
import lombok.Builder;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
@Builder
public class HtmlFileCrawlerPort implements TextCrawlerPort {
    private HtmlParser parser;
    private TextDistanceCalculator textDiscanceCalc;
    private ElementMapper elementMapper;

    @Override
    public HtmlElement findInOrigin(String id, String path) throws IOException {
        return elementMapper.mapSource(parser.getElementById(id, path));
    }

    @Override
    public HtmlElement findInTarget(HtmlElement element, String path) throws IOException {
        List<Element> sameTagElements = parser.getElementsInTag(path, element.getTagName());
         return elementMapper.mapTarget(textDiscanceCalc.findSimilarElement(element.getAllAtributesSplitted(), sameTagElements));
    }
}
