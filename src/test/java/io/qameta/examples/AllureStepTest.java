package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class AllureStepTest {

    /**
        AllureStepTest.class
    This class shows what actions Allure allows to do with the steps.

    1) GLOBAL_PARAMETER is a global variable which can be used inside AllureStepTest class.

    2) annotatedStepTest() - a test that contains the steps described in (5) and the passing parameter
    is a "local value" that can only be used within that test.

    3) lambdaStepTest() is a test which shows how Allure handles lambda steps.
    Here we see that the variable localParameter is set inside the test. This is used in the name
    of the "parent" step and the first nested step. The second nested step uses GLOBAL_PARAMETER inside,
    is a lambda step and can also have nested steps.

    4) annotatedStep() is a step which can take a parameter as shown in (1) and contain nested steps.

    5) nestedAnnotatedStep() - step which takes a GLOBAL_PARAMETER value and passes it in its name.

    If we run tests (2) and (3), we can see how Allure Report reproduces them.
     */

    // (1) GLOBAL_PARAMETER
    private static final String GLOBAL_PARAMETER = "global value";

    // (2) annotatedStepTest
    @Test
    public void annotatedStepTest() {
        annotatedStep("local value");
    }

    // (3) lambdaStepTest
    @Test
    public void lambdaStepTest() {
        final String localParameter = "parameter value";
        Allure.step(String.format("Parent lambda step with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
            Allure.step(String.format("Nested lambda step with global parameter [%s]", GLOBAL_PARAMETER));
        });
    }

    // (4) annotatedStep
    @Step("Parent annotated step with parameter [{parameter}]")
    public void annotatedStep(final String parameter) {
        nestedAnnotatedStep();
    }

    // (5) nestedAnnotatedStep
    @Step("Nested annotated step with global parameter [{this.GLOBAL_PARAMETER}]")
    public void nestedAnnotatedStep() {

    }

}