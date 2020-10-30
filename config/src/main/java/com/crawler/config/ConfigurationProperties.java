package com.crawler.config;

import lombok.Builder;
import lombok.Getter;

@Getter
//@ConstructorBinding
//@ConfigurationProperties("crawler.config")
@Builder
public class ConfigurationProperties {

    String elementId;
    String charset;
    double minDist;
    //TODO: Let Spring do the magic
    /*
    public InputConfigurationProperties(
            @DefaultValue("make-everything-ok-button") String elementId,
            @DefaultValue("utf8") String charset
    ){
        this.elementId = elementId;
        this.charset = charset;
    }
     */
}
