package bootstrap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Catalog {

    private final Map<String, String> pricesByBarcode = new ConcurrentHashMap<>();

    public void add(Item item) {
        pricesByBarcode.put(item.getBarcode(), item.getPrice());
    }

    public String priceFor(String barcode) {
        return pricesByBarcode.getOrDefault(barcode, "No price available for item " + barcode);
    }
}
