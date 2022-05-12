import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.IoT.manager.BookShop;
import ua.lviv.IoT.models.*;

import java.time.LocalDate;
import java.util.Set;

public class BookShopTest {

    private static BookShop bookShop;

    @Test
    public void testAddingNewItems(){
        BookShop bookShop = new BookShop();
        assertEquals(bookShop.getItems().size(),0);
        bookShop.addNewItems(
                new ItemBox(new Book(100,true,100,"genre","title",true),
                        5,100),
                new ItemBox(new Book(100,true,100,"genre","title",true),
                        7,100)
        );
        assertEquals(bookShop.getItems().size(),12);
    }

    @Test
    public void testGettingItemsForChildren(){
        Set<Item> result = bookShop.getItemsForChildren();
        for (Item item:result) {
            assertTrue(item.isChild());
        }
    }

    @Test
    public void testGettingBooksByGenre(){
        Set<Book> result = bookShop.getBooksByGenre("fantasy");
        assertNotEquals(result.size(),0);
        for (Book book:result) {
            assertEquals("fantasy", book.getGenre());
        }
    }

    @Test
    public void testGettingItemsSortedByPriceNullCase(){
        BookShop bookShop = null;
        assertThrows(NullPointerException.class,()->bookShop.getItemsSortedByPrice(true));
    }

    @Test
    public void testGettingItemsSortedByPriceOneElementCase(){
        BookShop bookShop = new BookShop();
        Item item = new Book(5,true,10,"drama","title",true);
        bookShop.addNewItems(new ItemBox(item,1,10));
        Set<Item> set = bookShop.getItemsSortedByPrice(true);
        assertEquals(1,set.size());
        assertTrue(set.contains(item));
    }

    @Test
    public void testGettingItemsSortedByPriceRegularCase(){
        Set<Item> set = bookShop.getItemsSortedByPrice(true);
        assertTrue(set.size() > 1);
        float a = Float.MAX_VALUE;
        for (Item item:set) {
            assertTrue(item.getPriceInUAH() <= a);
            a = item.getPriceInUAH();
        }
    }

    @Test
    public void testGettingItemsSortedByNumberOfPagesNullCase(){
        BookShop bookShop = null;
        assertThrows(NullPointerException.class,()->bookShop.getItemsSortedByNumberOfPages(true));
    }

    @Test
    public void testGettingItemsSortedByNumberOfPagesOneElementCase(){
        BookShop bookShop = new BookShop();
        Item item = new Book(5,true,10,"drama","title",true);
        bookShop.addNewItems(new ItemBox(item,1,10));
        Set<Item> set = bookShop.getItemsSortedByNumberOfPages(true);
        assertEquals(1,set.size());
        assertTrue(set.contains(item));
    }

    @Test
    public void testGettingItemsSortedByNumberOfPagesRegularCase(){
        Set<Item> set = bookShop.getItemsSortedByNumberOfPages(true);
        assertTrue(set.size() > 1);
        int a = Integer.MAX_VALUE;
        for (Item item:set) {
            assertTrue(item.getPages() <= a);
            a = item.getPages();
        }
    }

    @BeforeEach
    void initBookShop(){
        bookShop = new BookShop();
        int n = 3;
        bookShop.addNewItems(
                new ItemBox(new Magazine(20,true,20, LocalDate.now(),"news",true),
                        n,100),
                new ItemBox(new Calendar(5,false,10,10,true,true),
                        n,100),
                new ItemBox(new Coloring(15,false,5,"New Year",5),
                        n,100),
                new ItemBox(new Book(259,true,100,"fantasy","Harry Potter",true),
                        n,100),
                new ItemBox(new Book(367,true,200,"detective","Lord of the rings",true),
                        n,100)
        );
    }

}
