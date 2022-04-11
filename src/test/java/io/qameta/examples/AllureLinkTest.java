package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import org.junit.jupiter.api.Test;

/**
 * Here are examples of how you can make the links in Allure Report more readable.
 *
 * 1) Annotation with a single static link
 * 2) Annotation with two(or more) static links
 * 3) A method that allows you to set the title and body of the link both statically and dynamically from the code
 *
 * 1) The '@Link' annotation is used here, it allows you to assign a single link to a test and also makes it possible
 *    to hide them for more readable titles.
 * 2) A special case of point 1, which shows how you can set several static links for one test
 *    See a screenshot here: ###allure-report-documentation##/static_link
 *    Pros: Very simple and readable way
 *    Cons: Links cannot fetch values from code
 *
 * 3) 'Allure.link' is a very handy tool, it allows you to quickly access the data obtained during the test run.
 *    See a screenshot here: ###allure-report-documentation##/dynamic_link
 *    Pros: The actuality of the data obtained
 *    Cons: Zero:) @cheshi-mantu: Does any of this exist?
 */

public class AllureLinkTest {

    private static final String LINK_TITLE = "Static link";
    private static final String LINK = "https://qameta.io";
    String firstDynamicLinkTitle = "First dynamic link";

    @Test
    @Link(name = LINK_TITLE, url = "https://qameta.io")
    public void staticLinkTest() {
    }

    @Test
    @Links({
            @Link(name = "First static link", url = LINK),
            @Link(name = "Second static link", url = "https://qameta.io")
    })
    public void staticLinksTest() {
                
        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Test
    public void dynamicLinkTest() {

        String secondDynamicLinkTitle = "Second dynamic link";

        Allure.link(firstDynamicLinkTitle, LINK);
        Allure.link(secondDynamicLinkTitle, "https://qameta.io");

        step("Arrange");
        step("Act");
        step("Assert");


    }
    
}