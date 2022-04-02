package ua.lviv.IoT.models;

import java.time.LocalDate;

public class Magazine extends Item{
    LocalDate releaseDate;
    String topic;
    boolean isColor;

    public Magazine(int pages, boolean isChild, float priceInUAH, LocalDate releaseDate, String topic, boolean isColor) {
        super(pages, isChild, priceInUAH);
        this.releaseDate = releaseDate;
        this.topic = topic;
        this.isColor = isColor;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isColor() {
        return isColor;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "pages=" + pages +
                ", isChild=" + isChild +
                ", priceInUAH=" + priceInUAH +
                ", releaseDate=" + releaseDate +
                ", topic='" + topic + '\'' +
                ", isColor=" + isColor +
                '}';
    }
}
