package io.qameta.examples;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Titles are used to name the test case.
 *
 * 1) Annotation Title Test
 * 2) Dynamic Title Test
 *
 * 1) Annotation Title Test
 *    Allows you to set the test case title statically.
 *    See a screenshot here: ###allure-report-documentation####/annotated-title
 *    Pros: your code looks cleaner
 *    Cons: no way to assign values used in other test cases
 *
 * 2) Dynamic Title Test
 *    Shows us how we can set the test case title from the code.
 *    See a screenshot here: ###allure-report-documentation##/dynamic-title
 *    Pros: your code looks more complex
 *    Cons: more options to change a large number of test cases quickly and efficiently
 */

public class AllureTitleTest {
    @Test
    @DisplayName("Static name")
    public void annotationTitleTest() {
        
        step("Arrange");
        step("Act");
        step("Assert");


    }

    @Test
    public void dynamicTitleTest() {
        final String dynamicPart = "dynamic parameter";
        final String dynamicName = String.format("Test with parameter [%s]", dynamicPart);
        Allure.getLifecycle().updateTestCase(result -> result.setName(dynamicName));
        
        step("Arrange");
        step("Act");
        step("Assert");

    }

}