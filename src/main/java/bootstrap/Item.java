package bootstrap;

public class Item {

    private final String barcode;
    private final String price;

    public Item(String barcode, String price) {
        this.barcode = barcode;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getPrice() {
        return price;
    }
}
