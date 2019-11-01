package bootstrap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Catalog {

    private final Map<String, String> c = new ConcurrentHashMap<>();

    public void add(Item item) {
        c.put(item.getBarcode(), item.getPrice());
    }

    public String priceFor(String barcode) {
        return c.getOrDefault(barcode, "No price available for item " + barcode);
    }
}
