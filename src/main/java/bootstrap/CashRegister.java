package bootstrap;

import java.util.function.Consumer;

public class CashRegister {

    private final Display display;
    private final Catalog catalog;
    private Price scannedPrice;

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
            scannedPrice = p;
            display.displayPrice(p);
        };
    }

    public void onTotal() {
        boolean saleNotInProgress = (scannedPrice != null);
        if (saleNotInProgress) {
            display.displayTotalPurchase(scannedPrice);
        } else {
            display.total();
        }
    }
}
