import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.IoT.manager.RegexManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class RegexManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void emptyCaseTest(){
        RegexManager regexManager = new RegexManager();
        regexManager.printPenultimateWordsInAllSentences("");
        assertEquals("",outContent.toString().trim());
    }

    @Test
    public void oneWordSentenceTest(){
        RegexManager regexManager = new RegexManager();
        regexManager.printPenultimateWordsInAllSentences("Snow.");
        assertEquals("",outContent.toString().trim());
    }

    @Test
    public void regularSentenceTest(){
        RegexManager regexManager = new RegexManager();
        regexManager.printPenultimateWordsInAllSentences("Never give up.");
        assertEquals("give",outContent.toString().trim());
    }

    @Test
    public void regularTextTest() throws IOException {
        RegexManager regexManager = new RegexManager();
        regexManager.printPenultimateWordsInAllSentences(new String(Files.readAllBytes(Paths.get("someText"))));
        assertEquals(new String(Files.readAllBytes(Paths.get("expectedResultRegex"))),outContent.toString().trim());
    }

}
