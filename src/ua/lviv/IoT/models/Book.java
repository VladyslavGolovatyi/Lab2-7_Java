package ua.lviv.IoT.models;

public class Book extends Item{
    String genre;
    String title;
    boolean isColor;

    public Book(int pages, boolean isChild, float priceInUAH, String genre, String title, boolean isColor) {
        super(pages, isChild, priceInUAH);
        this.genre = genre;
        this.title = title;
        this.isColor = isColor;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public boolean isColor() {
        return isColor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", isColor=" + isColor +
                ", pages=" + pages +
                ", isChild=" + isChild +
                ", priceInUAH=" + priceInUAH +
                '}';
    }
}
