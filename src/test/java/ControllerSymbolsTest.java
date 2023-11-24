import org.example.service.ServiceImplSymbols;
import org.example.service.ServiceSymbols;
import org.example.exeption.NoInformationFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ControllerSymbolsTest {

    String text = "aaaaabcccc";
    String response = "\"a\":5, \"c\":4, \"b\":1";
    String text1 = "ddd   tt   ee  ";
    String response1 = "\"d\":3, \"t\":2, \"e\":2";

    private final ServiceSymbols serviceSymbols = new ServiceImplSymbols();

    @Test
    public void textWithoutWhitespace() {
        assertEquals(serviceSymbols.numberOfCharacters(text), response);
    }

    @Test
    public void textWithWhitespace() {
        assertEquals(serviceSymbols.numberOfCharacters(text1), response1);
    }

    @Test
    public void missingSymbols() {
        final NoInformationFoundException exception = assertThrows(
                NoInformationFoundException.class,
                () -> serviceSymbols.numberOfCharacters(""));

        assertEquals("Empty string", exception.getMessage());
    }
}