import org.junit.jupiter.api.Test;
import ua.lviv.IoT.manager.BookWriter;
import ua.lviv.IoT.models.Book;
import ua.lviv.IoT.models.Coloring;
import ua.lviv.IoT.models.Item;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookWriterTest {

    @Test
    public void testWritingToSCVEmptyCase() throws IOException {
        BookWriter.writeToFile(new ArrayList<>());
        File file = new File("result.csv");
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()){
            result.append(scanner.nextLine());
        }
        assertEquals("", result.toString());
    }

    @Test
    public void testWritingToScvOneClassInstancesCase() throws IOException {
        List<Item> items = new ArrayList<>();
        items.add(new Book(250,true,400,"horror","It",true));
        items.add(new Book(290,true,100,"fantasy","Harry Potter",false));
        BookWriter.writeToFile(items);
        File file = new File("result.csv");
        Scanner scanner = new Scanner(file,StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()){
            result.append(scanner.nextLine());
        }
        assertEquals("\"genre\",\"title\",\"isColor\",\"pages\",\"isChild\",\"priceInUAH\"" +
                "\"horror\",\"It\",\"true\",\"250\",\"true\",\"400.0\"" +
                "\"fantasy\",\"Harry Potter\",\"false\",\"290\",\"true\",\"100.0\"", result.toString());
    }

    @Test
    public void testWritingToScvRegularCase() throws IOException {
        List<Item> items = new ArrayList<>();
        items.add(new Book(250,true,400,"horror","It",true));
        items.add(new Book(290,true,100,"fantasy","Harry Potter",false));
        items.add(new Coloring(10,true,20,"Easter",10));
        BookWriter.writeToFile(items);
        File file = new File("result.csv");
        Scanner scanner = new Scanner(file,StandardCharsets.UTF_8);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()){
            result.append(scanner.nextLine());
        }
        assertEquals("\"genre\",\"title\",\"isColor\",\"pages\",\"isChild\",\"priceInUAH\"" +
                "\"horror\",\"It\",\"true\",\"250\",\"true\",\"400.0\"" +
                "\"fantasy\",\"Harry Potter\",\"false\",\"290\",\"true\",\"100.0\"" +
                "\"topic\",\"numberOfColorings\",\"pages\",\"isChild\",\"priceInUAH\"" +
                "\"Easter\",\"10\",\"10\",\"true\",\"20.0\"", result.toString());
    }


}
