package bootstrap;

import java.util.function.Consumer;

public class CashRegister {

    private final Display display;
    private final Catalog catalog;
    private Price price;

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
                priceFound(),
                () -> display.displayProductNotFound(barcode));
    }

    private Consumer<Price> priceFound() {
        return p -> {
            price = p;
            display.displayPrice(p);
        };
    }

    public void onTotal() {
        if (price == null) {
            display.total();
        } else {
            display.displayTotalPurchase(price.toString());
        }
    }
}
