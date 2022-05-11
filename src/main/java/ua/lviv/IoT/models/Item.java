package ua.lviv.IoT.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Item {
    private final int pages;
    private final boolean isChild;
    private final float priceInUAH;

    public String toCSV(){
        return pages+","+isChild+","+priceInUAH;
    }

    public String getHeaders(){
        return "pages,isChild,priceInUAH";
    }

}
