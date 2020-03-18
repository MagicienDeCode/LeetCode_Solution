import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TemplateKTest {

    private val templateK = TemplateK()

    @ParameterizedTest
    @MethodSource("sumSource")
    fun sum(a: Int, b: Int, result: Int) {
        assertEquals(result, templateK.sum(a, b))
    }

    companion object {
        @JvmStatic
        fun sumSource() = listOf(
            Arguments.of(1, 1, 2),
            Arguments.of(Int.MAX_VALUE, 1, 0)
        )
    }
}