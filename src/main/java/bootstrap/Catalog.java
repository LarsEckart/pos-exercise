package bootstrap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Catalog {

    private final Map<String, String> pricesByBarcode;

    public Catalog(List<Item> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode.stream().collect(Collectors.toMap(Item::getBarcode, Item::getPrice));
    }

    public Optional<String> priceFor(String barcode) {
        return Optional.ofNullable(pricesByBarcode.get(barcode));
    }
}
