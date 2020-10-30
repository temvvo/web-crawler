package com.crawler.app.test;

import com.crawler.app.usecase.FindElement;
import com.crawler.config.AppConfig;
import com.crawler.config.ConfigurationProperties;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class MainTest {

    FindElement useCase;
    AppConfig config;

    static final String SOURCE = "src/test/resources/sample-0-origin.html";
    static final String ELEMENT_ID = "make-everything-ok-button";
    static final String CHARSET = "utf8";
    static final double MIN_DIST = 1.0F;

    // Setup
    @Before
    public void configuration() {

        config = AppConfig.builder().props(ConfigurationProperties.builder().charset(CHARSET)
                .elementId(ELEMENT_ID).minDist(MIN_DIST).build()).build();
        useCase = config.getUseCase();
    }

    @Test
    public void testWithSample1() throws IOException {
        var expectedResult1 = "<a class=\"btn btn-success\" href=\"#check-and-ok\" title=\"Make-Button\" rel=\"done\" onclick=\"javascript:window.okDone(); return false;\"> Make everything OK </a>";
        var target1 = "src/test/resources/sample-1-evil-gemini.html";

        // Create User Input domain object
        var userInput = config.createUserInput(new String[]{SOURCE, target1});

        // Get element by id
        var element = useCase.findInOrigin(userInput.getOriginalElementId(), userInput.getOriginFilePath());
        //System.out.println("Main - HtmlElement: " + element.getAllAtributesSplitted());

        //Get similar element from target
        var foundElement = useCase.findInTarget(element, userInput.getSampleFilePath());
        assertEquals(expectedResult1, foundElement.getAllAtributesSplitted());
    }

    @Test
    public void testWithSample2() throws IOException {
        var expectedResult2 = "<a class=\"btn test-link-ok\" href=\"#ok\" title=\"Make-Button\" rel=\"next\" onclick=\"javascript:window.okComplete(); return false;\"> Make everything OK </a>";
        var target2 = "src/test/resources/sample-2-container-and-clone.html";

        // Create User Input domain object
        var userInput = config.createUserInput(new String[]{SOURCE, target2});

        // Get element by id
        var element = useCase.findInOrigin(userInput.getOriginalElementId(), userInput.getOriginFilePath());
        //System.out.println("Main - HtmlElement: " + element.getAllAtributesSplitted());

        //Get similar element from target
        var foundElement = useCase.findInTarget(element, userInput.getSampleFilePath());
        assertEquals(expectedResult2, foundElement.getAllAtributesSplitted());
    }

    @Test
    public void testWithSample3() throws IOException {
        var expectedResult3 = "<a class=\"btn btn-success\" href=\"#ok\" title=\"Do-Link\" rel=\"next\" onclick=\"javascript:window.okDone(); return false;\"> Do anything perfect </a>";
        var target3 = "src/test/resources/sample-3-the-escape.html";

        // Create User Input domain object
        var userInput = config.createUserInput(new String[]{SOURCE, target3});

        // Get element by id
        var element = useCase.findInOrigin(userInput.getOriginalElementId(), userInput.getOriginFilePath());
        //System.out.println("Main - HtmlElement: " + element.getAllAtributesSplitted());

        //Get similar element from target
        var foundElement = useCase.findInTarget(element, userInput.getSampleFilePath());
        assertEquals(expectedResult3, foundElement.getAllAtributesSplitted());
    }

    @Test
    public void testWithSample4() throws IOException {
        var expectedResult4 = "<a class=\"btn btn-success\" href=\"#ok\" title=\"Make-Button\" rel=\"next\" onclick=\"javascript:window.okFinalize(); return false;\"> Do all GREAT </a>";
        var target4 = "src/test/resources/sample-4-the-mash.html";

        // Create User Input domain object
        var userInput = config.createUserInput(new String[]{SOURCE, target4});


        // Get element by id
        var element = useCase.findInOrigin(userInput.getOriginalElementId(), userInput.getOriginFilePath());
        //System.out.println("Main - HtmlElement: " + element.getAllAtributesSplitted());

        //Get similar element from target
        var foundElement = useCase.findInTarget(element, userInput.getSampleFilePath());
        assertEquals(expectedResult4, foundElement.getAllAtributesSplitted());


    }

    @Test
    public void testWithSample1WithElementId() throws IOException {
        var expectedResult1 = "<a class=\"btn btn-success\" href=\"#check-and-ok\" title=\"Make-Button\" rel=\"done\" onclick=\"javascript:window.okDone(); return false;\"> Make everything OK </a>";
        var target1 = "src/test/resources/sample-1-evil-gemini.html";


        // Create User Input domain object
        var userInput = config.createUserInput(new String[]{SOURCE, target1, ELEMENT_ID});

        // Get element by id
        var element = useCase.findInOrigin(userInput.getOriginalElementId(), userInput.getOriginFilePath());
        //System.out.println("Main - HtmlElement: " + element.getAllAtributesSplitted());

        //Get similar element from target
        var foundElement = useCase.findInTarget(element, userInput.getSampleFilePath());
        assertEquals(expectedResult1, foundElement.getAllAtributesSplitted());
    }
}
