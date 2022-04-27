package ua.lviv.IoT.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Magazine extends Item {
    private final LocalDate releaseDate;
    private final String topic;
    private final boolean isColor;

    public Magazine(int pages, boolean isChild, float priceInUAH, LocalDate releaseDate, String topic, boolean isColor) {
        super(pages, isChild, priceInUAH);
        this.releaseDate = releaseDate;
        this.topic = topic;
        this.isColor = isColor;
    }

    public String toCSV(){
        return releaseDate+","+topic+","+isColor+","+super.toCSV();
    }

    public String getHeaders(){
        return "releaseDate,topic,isColor,"+super.getHeaders();
    }

}
