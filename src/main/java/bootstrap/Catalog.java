package bootstrap;

import java.util.Map;
import java.util.Optional;

public class Catalog {

    private final Map<Barcode, Price> pricesByBarcode;

    public Catalog(Map<Barcode, Price> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public Optional<Price> priceFor(Barcode barcode) {
        return Optional.ofNullable(pricesByBarcode.get(barcode));
    }
}
