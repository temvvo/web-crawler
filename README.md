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
