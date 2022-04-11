package io.qameta.examples;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

/**
 * Fixtures are general actions to be taken before or after the test steps.
 *
 * This example shows how fixtures can be specified by annotations.
 * See a screenshot here: ###allure-report-documentation##/fixtures
 */


public class AllureFixtureTest {

    @BeforeAll
    public static void beforeAllMethods() {

        step("Step inside before all methods");

    }

    @BeforeEach
    public void beforeEachMethod() {

        step("Step inside before each method");

    }

    @Test
    public void firstSimpleTest() {
                
        step("Arrange");
        step("Act", () -> {
            step("Step inside first test");
        });
        step("Assert");

    }

    @Test
    public void secondSimpleTest() {
                
        step("Arrange");
        step("Act", () -> {
            step("Step inside second test");
        });
        step("Assert");

    }

    @AfterEach
    public void afterEachMethod() {

        step("Step inside after each method");

    }
    
    @AfterAll
    public static void afterAllMethods() {

        step("Step inside after all methods");

    }

}