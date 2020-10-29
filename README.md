# web-crawler
web crawler to find similar Elements between html files providing an optional Element id
This solution is based in the clean architecture vision of Robert C. Martin (aka Uncle Bob). Feel free to read following blogspot if you want to learn about it:
https://medium.com/slalom-engineering/clean-architecture-with-java-11-f78bba431041

### Pre-requisite

Java 11

```
> java -version
openjdk version "11" 2018-09-25
OpenJDK Runtime Environment 18.9 (build 11+28)
OpenJDK 64-Bit Server VM 18.9 (build 11+28, mixed mode)
```

### Compile

`./gradlew clean build`

### Run application examples:

Run with ElementId:
`java -jar application/build/libs/crawler-app-1.0.0-fat.jar application/src/test/resources/sample-0-origin.html application/src/test/resources/sample-3-the-escape.html make-everything-ok-button`

Run without ElementId (default id will be used):
`java -jar application/build/libs/crawler-app-1.0.0-fat.jar application/src/test/resources/sample-0-origin.html application/src/test/resources/sample-3-the-escape.html`

### Output example:

`Origin - Element: <a id="make-everything-ok-button" class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okDone(); return false;"> Make everything OK </a>`

`target found element: <a class="btn btn-success" href="#ok" title="Make-Button" rel="next" onclick="javascript:window.okFinalize(); return false;"> Do all GREAT </a>`

`Element path in target:  html > body > div#wrapper > div#page-wrapper > div.row > div.col-lg-8 > div.panel panel-default > div.panel-footer > a.btn btn-success href="#ok"`
