package models;

public class Item {
    int pages;
    boolean isChild;
    float priceInUAH;

    public int getPages() {
        return pages;
    }

    public boolean isChild() {
        return isChild;
    }

    public float getPriceInUAH() {
        return priceInUAH;
    }

    public Item(int pages, boolean isChild, float priceInUAH) {
        this.pages = pages;
        this.isChild = isChild;
        this.priceInUAH = priceInUAH;
    }

    @Override
    public String toString() {
        return this.getClass().getName().split("\\.")[1]+"{" +
                "pages=" + pages +
                ", isChild=" + isChild +
                ", priceInUAH=" + priceInUAH +
                '}';
    }
}
