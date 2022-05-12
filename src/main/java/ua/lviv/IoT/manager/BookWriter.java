package ua.lviv.IoT.manager;

import com.opencsv.CSVWriter;
import ua.lviv.IoT.models.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BookWriter {
    public static void writeToFile(List<Item> items) throws IOException {
        File file = new File("result.csv");
        FileWriter outputFile = new FileWriter(file, StandardCharsets.UTF_8);
        CSVWriter writer = new CSVWriter(outputFile);
        String type = "";
        for (Item item:items) {
            if(!type.equals(item.getClass().getTypeName())){
                writer.writeNext(item.getHeaders().split(","));
                type = item.getClass().getTypeName();
            }
                writer.writeNext(item.toCSV().split(","));
        }
        writer.close();
    }
}
