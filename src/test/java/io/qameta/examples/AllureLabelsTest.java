package io.qameta.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.LabelAnnotation;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Labels in the Allure report allow you to sort the tests in the tree by its behaviors and environments
 *
 * 1) Common static label
 * 2) Common dynamic tag
 * 3) Custom static tag
 * 4) Custom Dynamic Tag
 * 5) CustomLabel interface
 *
 * 1) Common static label
 *    Allows you to create a label based on a common basic annotation
 *    See a screenshot here: ###allure-report-documentation##/common_static_label
 *    Pros: Hard to get wrong, all labels are placed directly above the test.
 *    Cons: Unable to change values from test results
 *
 * 2) Common dynamic label.
 *    Allows you to create base labels from code using internal Allure shortcuts.
 *    See a screenshot here: ###allure-report-documentation##/common_dynamic_label
 *    Pros: Allows to change the value of a label by taking it from the test results
 *    Cons: More control over code quality is needed, any mistake can distort the test results tree.
 *
 * 3) Custom static label
 *    Allows you to create your own labels using the '@CustomLabel' annotation and an interface (5) that describes
 *    your rules for that label.
 *    See a screenshot here: ###allure-report-documentation##/custom_static_label
 *    Pros: Own label, with custom name and value. Placed directly above the test.
 *    Cons: Need to create an additional interface in the code. Unable to change values from test results
 *
 * 4) Custom Dynamic Label.
 *    Allows you to create your own label using the '@CustomLabel' annotation and a method (5) that describes your
 *    rules for that label.
 *    See a screenshot here: ###allure-report-documentation##/custom_dynamic_label
 *    Pros: Own label, with a custom name and value. Allows you to change the value of the label by taking it from
 *    a test run.
 *    Cons: Need more control over code quality, any mistake can distort test results tree.
 *
 * 5) Public interface describing '@CustomLabel' annotation
 */

public class AllureLabelsTest {

    @Test
    @Epic("static epic")
    @Feature("static feature")
    @Story("static story")
    @Owner("static owner")
    public void commonStaticLabelTest() {

        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Test
    public void commonDynamicLabelTest() {

        Allure.epic("dynamic epic");
        Allure.feature("dynamic feature");
        Allure.story("dynamic story");
        Allure.suite("dynamic suite");

        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Test
    @CustomLabel("static value")
    public void customStaticLabelTest() {

        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Test
    public void customDynamicLabelTest() {

        Allure.label("custom", "dynamic value");

        step("Arrange");
        step("Act");
        step("Assert");

    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    @LabelAnnotation(name = "custom")
    public @interface CustomLabel {

        String value();

    }


}