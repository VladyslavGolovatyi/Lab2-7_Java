package models;

public class Calendar extends Item{
    int rangeOfYears;
    boolean isThematic;
    boolean isWithPictures;

    public Calendar(int pages, boolean isChild, float priceInUAH, int rangeOfYears, boolean isThematic, boolean isWithPictures) {
        super(pages, isChild, priceInUAH);
        this.rangeOfYears = rangeOfYears;
        this.isThematic = isThematic;
        this.isWithPictures = isWithPictures;
    }

    public int getRangeOfYears() {
        return rangeOfYears;
    }

    public boolean isThematic() {
        return isThematic;
    }

    public boolean isWithPictures() {
        return isWithPictures;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "rangeOfYears=" + rangeOfYears +
                ", isThematic=" + isThematic +
                ", isWithPictures=" + isWithPictures +
                ", pages=" + pages +
                ", isChild=" + isChild +
                ", priceInUAH=" + priceInUAH +
                '}';
    }
}
