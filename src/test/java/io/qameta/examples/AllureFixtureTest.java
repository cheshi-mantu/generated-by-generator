package io.qameta.examples;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

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
    public void simpleTest() {
        step("Step inside test");
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