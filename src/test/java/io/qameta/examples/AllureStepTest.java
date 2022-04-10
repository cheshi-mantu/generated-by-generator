package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

/**
 * AllureStepTest.class
 *
 * Steps allow you combining set of instructions which complete some part of a test, for example arrange, action, assert.
 * You add a step using following options:
 *
 * 1) Annotated step.
 * 2) Lambda step.
 *
 * 1) Annotated step
 *    Annotated step uses '@Step' annotation which is placed above a method containing some actions.
 *    for example, method annotatedStep() contains a set of actions described as Arrange, Act, Assert.
 *    Each method having '@Step' annotation will be processed and displayed by Allure Report as a separate step with the details from your code.
 *    See screenshot here: ###allure-report-documentation###/annotated-step
 *    Pro: your code looks cleaner
 *    Cons: you need to jump to the annotated method to understand what is happening inside this method.
 *
 * 2) Lambda step
 *    Lambda steps use Lambda expression to combine actions logically tied together (same as above, e.g. Arrange, Act, Assert).
 *    To describe a lamda step you need to use folloing construct:
 *    Allure.step("Description", (step)->{yor methods here})
 *    See screenshot here: ###allure-report-documentation###/lambda-step
 *    Pro: Your code will be 100% self-explanatory
 *    Cons: Your code will become more massive. @eroshenkoam: are there any contra yet?
 *
 */

public class AllureStepTest {

    private static final String GLOBAL_PARAMETER = "global value";

    @Test
    public void annotatedStepTest() {
        annotatedStepArrange("Arrange");
        annotatedStepActions("Action");
        annotatedStepAssertion("Assertion");
    }

    @Step("Parent annotated step to Arrange with parameter [{parameter}]")
    public void annotatedStepArrange(final String parameter) {
        nestedAnnotatedStep();
    }

    @Step("Parent annotated step with Actions with parameter [{parameter}]")
    public void annotatedStepActions(final String parameter) {
        nestedAnnotatedStep();
    }

    @Step("Parent annotated step with Assertions with parameter [{parameter}]")
    public void annotatedStepAssertion(final String parameter) {
        nestedAnnotatedStep();
    }

    @Step("Nested annotated step with global parameter [{this.GLOBAL_PARAMETER}]")
    public void nestedAnnotatedStep() {

    }

    @Test
    public void lambdaStepTest() {
        final String localParameter = "parameter value";
        Allure.step(String.format("Parent lambda step with Arrange with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
            Allure.step(String.format("Nested lambda step with global parameter [%s]", GLOBAL_PARAMETER));
        });
        Allure.step(String.format("Parent lambda step with Actions with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
            Allure.step(String.format("Nested lambda step with global parameter [%s]", GLOBAL_PARAMETER));
        });
        Allure.step(String.format("Parent lambda step with Assertions with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
            Allure.step(String.format("Nested lambda step with global parameter [%s]", GLOBAL_PARAMETER));
        });
    }



}