package ua.lviv.IoT.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Coloring extends Item {
    private final String topic;
    private final int numberOfColorings;

    public Coloring(int pages, boolean isChild, float priceInUAH, String topic, int numberOfColorings) {
        super(pages, isChild, priceInUAH);
        this.topic = topic;
        this.numberOfColorings = numberOfColorings;
    }

    public String toCSV(){
        return topic+","+numberOfColorings+","+super.toCSV();
    }

    public String getHeaders(){
        return "topic,numberOfColorings,"+super.getHeaders();
    }

}
