package bootstrap;

public class CashRegister {

    private final Display display;
    private final Catalog catalog;

    public CashRegister(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(Barcode barcode) {
        // SMELL: refused request? move up call stack?
        if (barcode.isEmpty()) {
            display.displayEmptyProductMessage();
            return;
        }

        catalog.priceFor(barcode).ifPresentOrElse(
                display::displayPrice,
                () -> display.displayProductNotFound(barcode));
    }

    public void onTotal() {
        display.total();
    }
}
