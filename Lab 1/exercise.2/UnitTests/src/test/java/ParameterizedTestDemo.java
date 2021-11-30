
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.util.StringUtils;

/**
 *
 * @author Gall Anonim
 */
public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab"}) // add "" 
    void palindromes(String candidate) {
        assertTrue(StringUtils.isNotBlank(candidate), "String is empty!");
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void shouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue, "Obtained results cover not only capital letters");
    }
}
