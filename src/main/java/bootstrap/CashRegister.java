package bootstrap;

public class CashRegister {
    private final Display display;
    private final Catalog catalog;

    public CashRegister(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if (barcode.isEmpty()) {
            display.show("Error, empty barcode!");
            return;
        }

        display.show(catalog.priceFor(barcode));
    }
}
