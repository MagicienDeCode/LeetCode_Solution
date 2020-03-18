import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateTest {

    private final Template template = new Template();

    @ParameterizedTest
    @MethodSource("sumSource")
    void sum(int a, int b, int result) {
        assertEquals(result, template.sum(a, b));
    }

    private static Stream<Arguments> sumSource() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(Integer.MAX_VALUE, 1, 0)
        );
    }
}
