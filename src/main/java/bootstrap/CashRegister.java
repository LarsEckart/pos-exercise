package bootstrap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CashRegister {

    private final Display display;
    private final Catalog catalog;
    private Collection<Price> scannedPrices = new ArrayList<>();

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
            scannedPrices.add(p);
            display.displayPrice(p);
        };
    }

    public void onTotal() {
        if (scannedPrices.isEmpty()) {
            display.noSaleInProgress();
        } else {
            display.displayTotalPurchase(scannedPrices.iterator().next());
        }
    }
}
