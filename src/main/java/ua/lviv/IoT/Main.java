package ua.lviv.IoT;

import ua.lviv.IoT.manager.BookShop;
import ua.lviv.IoT.manager.RegexManager;
import ua.lviv.IoT.models.Book;
import ua.lviv.IoT.models.Calendar;
import ua.lviv.IoT.models.Item;
import ua.lviv.IoT.models.ItemBox;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RegexManager regexManager = new RegexManager();
        regexManager.findPenultimateWordsInAllSentences("word, word...").forEach(System.out::println);
    }
}
