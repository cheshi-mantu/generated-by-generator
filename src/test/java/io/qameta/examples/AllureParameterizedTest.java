package io.qameta.examples;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

/**
 * Allure.parameter uses basic Junit5 annotations and allows you to assign text labels to entry variables of
 * parameterized tests, which improves code readability and helps analyze data in Allure Report.
 * See a screenshot here: ###allure-report-documentation##/parameter
 */

public class AllureParameterizedTest {
    private static Stream<Arguments> numbers() {
        return Stream.of(
          Arguments.of(1, 1, 2),
          Arguments.of(2, 2, 4)
        );
    }
    @ParameterizedTest
    @MethodSource("numbers")
    public void sumTest(int a, int b, int r) {
        parameter("1First Number", a);
        parameter("2Second Number", b);
        parameter("3Result Sum", r);

        step(("Arrange"), () ->{
            step(String.format("Take collection №[%s] of parameters", a));
        });
        step(("Act"), () ->{
            step(String.format("Add [%s]", a)+ String.format("to [%s]", b));
        });
        step(("Assert"), () ->{
            step("Compare the sum");
            Assertions.assertEquals( r , (a+b));
        });
    }

}