package fr.lernejo;

import fr.lernejo.Sample;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SampleTest {

    private final Sample sample = new Sample();

    @ParameterizedTest
    @CsvSource({
        "ADD, 3, 3, 6",
        "MULT, 4, 2, 8"
    })
    void simple_operation(String op, int a, int b, int resultexpected){
        int result = sample.op(Sample.Operation.valueOf(op), a, b);

        Assertions
            .assertThat(result)
            .as(op + " of " + a + " and " + b)
            .isEqualTo(resultexpected);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "0, 1",
        "5, 120"
    })
    void fact_cases(int n, int resultexpected){
        int result = sample.fact(n);

        Assertions
            .assertThat(result)
            .as("Fact of " + n)
            .isEqualTo(resultexpected);
    }

    @Test
    void fact_negative_number_should_throw() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-2))
            .withMessage("N should be positive");
    }

}
