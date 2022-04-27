package ua.lviv.IoT.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends Item {
    private final String genre;
    private final String title;
    private final boolean isColor;

    public Book(int pages, boolean isChild, float priceInUAH, String genre, String title, boolean isColor) {
        super(pages, isChild, priceInUAH);
        this.genre = genre;
        this.title = title;
        this.isColor = isColor;
    }

    public String toCSV(){
        return genre+","+title+","+isColor+","+super.toCSV();
    }

    public String getHeaders(){
        return "genre,title,isColor,"+super.getHeaders();
    }

}
