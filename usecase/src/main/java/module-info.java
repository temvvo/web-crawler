module crawler.app.usecase {
	exports com.crawler.app.usecase;
	exports com.crawler.app.usecase.exception;
	exports com.crawler.app.usecase.port;

	requires static lombok;
	requires crawler.app.domain;
	requires org.apache.commons.lang3;
	requires rt;
}
