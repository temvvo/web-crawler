package com.crawler.app.domain.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Input {
	String originFilePath, sampleFilePath, originalElementId;
}
