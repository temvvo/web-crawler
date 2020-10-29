module crawler.app.port {
	exports com.crawler.app.port;
	exports com.crawler.app.parser;
	exports com.crawler.app.calculator;

	requires crawler.app.usecase;
	requires crawler.app.domain;
	requires org.jsoup;
	requires java.string.similarity;
	requires static lombok;
}
