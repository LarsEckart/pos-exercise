package bootstrap;

public class CashRegister {
    private final Display display;
    private Catalog catalog;

    public CashRegister(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        display.show(catalog.priceFor(barcode));
    }
}
