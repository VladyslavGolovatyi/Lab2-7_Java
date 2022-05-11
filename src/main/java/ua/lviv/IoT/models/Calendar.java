package ua.lviv.IoT.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Calendar extends Item{
    private final int rangeOfYears;
    private final boolean isThematic;
    private final boolean isWithPictures;

    public Calendar(int pages, boolean isChild, float priceInUAH, int rangeOfYears, boolean isThematic, boolean isWithPictures) {
        super(pages, isChild, priceInUAH);
        this.rangeOfYears = rangeOfYears;
        this.isThematic = isThematic;
        this.isWithPictures = isWithPictures;
    }

    public String toCSV(){
        return rangeOfYears+","+isThematic+","+isWithPictures+","+super.toCSV();
    }

    public String getHeaders(){
        return "rangeOfYears,isThematic,isWithPictures,"+super.getHeaders();
    }

}
