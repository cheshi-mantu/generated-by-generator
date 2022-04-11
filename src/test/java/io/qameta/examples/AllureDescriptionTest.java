package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

/**
 * A test description helps you quickly understand its purpose without going into unnecessary detail.
 *
 * Here are examples of how you can set a description in an allure report
 *
 * 1) annotationDescriptionTest
 * 2) javaDocDescriptionTest
 * 3) dynamicDescriptionTest
 *
 * 1) annotationDescriptionTest.
 *    The basic annotation '@Description' is used
 *    See a screenshot here: ###allure-report-documentation##/annotation_description
 *    Pros: Very simple method, hard to get wrong
 *    Cons: If you change the script, you will have to manually rewrite it.
 *
 * 2) javaDocDescriptionTest.
 *    Uses a basic '@Description' annotation and a javaDoc method that allows you to pass text commented out over the test
 * See a screenshot here: ###allure-report-documentation##/javadoc_description
 *    Pros: Very handy if you're used to keeping documentation in code.
 *    Cons: The description is not strongly tied to the test, there is a chance to make a mistake.
 *
 * 3) dynamicDescriptionTest.
 *    Uses Allure.description method, allows you to adjust to the test scenario and keep description up to date
 *    See a screenshot here: ###allure-report-documentation##/dynamic_description
 *    Pros: Description is always up to date
 *    Cons: Requires more control
 */

public class AllureDescriptionTest {

    @Test
    @Description("Static description")
    public void annotationDescriptionTest() {
                        
        step("Arrange");
        step("Act");
        step("Assert");

    }

    /**
     * JavaDoc description
     */
    @Test
    @Description(useJavaDoc = true)
    public void javadocDescriptionTest() {
                        
        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Test
    public void dynamicDescriptionTest() {
        Allure.description("Dynamic description");
                        
        step("Arrange");
        step("Act");
        step("Assert");

    }

}