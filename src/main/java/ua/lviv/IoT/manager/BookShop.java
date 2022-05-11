package ua.lviv.IoT.manager;

import ua.lviv.IoT.models.Book;
import ua.lviv.IoT.models.Item;
import ua.lviv.IoT.models.ItemBox;

import java.util.*;
import java.util.stream.Collectors;

public class BookShop {
    private final List<Item> items = new ArrayList<>();

    public void addNewItems(final ItemBox... itemBoxes) {
        for (ItemBox itemBox:itemBoxes) {
            for(int i = 0; i < itemBox.numberOfItems(); ++i) {
                items.add(itemBox.item());
            }
        }
    }

    public Set<Item> getItemsForChildren() {
        return items.stream().filter(Item::isChild).collect(Collectors.toSet());
    }

    public Set<Book> getBooksByGenre(String genre) {
        Set<Book> result = new HashSet<>();
        items.stream().filter(item -> item.getClass().getTypeName().equals("ua.lviv.IoT.models.Book")).
                filter(book -> ((Book)book).getGenre().equals(genre)).forEach(book -> result.add((Book) book));
        return result;
    }

    public Set<Item> getItemsSortedByPrice(boolean reverse){
        Set<Item> result = items.stream().sorted(Comparator.comparingDouble(Item::getPriceInUAH)).collect(Collectors.toCollection(LinkedHashSet::new));
        if(reverse) {
            List<Item> list = new ArrayList<>(result);
            Collections.reverse(list);
            result = new LinkedHashSet<>(list);
        }
        return result;
    }

    public Set<Item> getItemsSortedByNumberOfPages(boolean reverse){
        Set<Item> result = items.stream().sorted(Comparator.comparingDouble(Item::getPages)).collect(Collectors.toCollection(LinkedHashSet::new));
        if(reverse) {
            List<Item> list = new ArrayList<>(result);
            Collections.reverse(list);
            result = new LinkedHashSet<>(list);
        }
        return result;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
