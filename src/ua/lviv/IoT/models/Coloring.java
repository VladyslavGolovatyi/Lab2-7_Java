package ua.lviv.IoT.models;

public class Coloring extends Item{
    String topic;
    int numberOfColorings;

    public Coloring(int pages, boolean isChild, float priceInUAH, String topic, int numberOfColorings) {
        super(pages, isChild, priceInUAH);
        this.topic = topic;
        this.numberOfColorings = numberOfColorings;
    }

    public String getTopic() {
        return topic;
    }

    public int getNumberOfColorings() {
        return numberOfColorings;
    }

    @Override
    public String toString() {
        return "Coloring{" +
                "topic='" + topic + '\'' +
                ", numberOfColorings=" + numberOfColorings +
                ", pages=" + pages +
                ", isChild=" + isChild +
                ", priceInUAH=" + priceInUAH +
                '}';
    }
}
