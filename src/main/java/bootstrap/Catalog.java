package bootstrap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {

    private final Map<String, String> pricesByBarcode;

    public Catalog(List<Item> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode.stream().collect(Collectors.toMap(Item::getBarcode, Item::getPrice));
    }

    public String priceFor(String barcode) {
        return pricesByBarcode.getOrDefault(barcode, "No price available for item " + barcode);
    }
}
