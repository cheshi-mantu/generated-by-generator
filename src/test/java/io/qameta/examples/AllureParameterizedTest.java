package io.qameta.examples;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static io.qameta.allure.Allure.parameter;



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
        parameter("First Number", a);
        parameter("Second Number", b);
        parameter("Result Sum", r);
    }

}