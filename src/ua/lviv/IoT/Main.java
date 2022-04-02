package ua.lviv.IoT;

import ua.lviv.IoT.manager.BookShop;
import ua.lviv.IoT.models.Book;
import ua.lviv.IoT.models.Calendar;
import ua.lviv.IoT.models.ItemBox;

public class Main {

    public static void main(String[] args) {
        ItemBox itemBox = new ItemBox(new Book(300, true, 150, "fantasy",
                "Harry Potter and Sorcerer's stone", true),100,50,"Book");
        ItemBox itemBox1 = new ItemBox(new Book(200, false, 200, "horror",
                "It", false),50,20,"Book");
        ItemBox itemBox2 = new ItemBox(new Calendar(0,true,20,50,false,true),
                1000,30,"Calendar");
        BookShop knygarniaE = new BookShop();
        knygarniaE.addNewItems(itemBox,itemBox1,itemBox2);
        System.out.println("----------------------------------------");
        knygarniaE.getItemsForChildren().forEach(System.out::println);
        System.out.println("----------------------------------------");
        knygarniaE.getBooksByGenre("fantasy").forEach(System.out::println);
        System.out.println("----------------------------------------");
        knygarniaE.getItemsSortedByPrice(false).forEach(System.out::println);
        System.out.println("----------------------------------------");
        knygarniaE.getItemsSortedByNumberOfPages(false).forEach(System.out::println);

    }
}
