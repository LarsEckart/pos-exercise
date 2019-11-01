package bootstrap;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SellMultipleItems {

    @Test
    void zero_items() {
        Display display = new Display();
        CashRegister cashRegister = new CashRegister(display, null);

        cashRegister.onTotal();

        assertThat(display.lastDisplayed()).isEqualTo("No sale in progress. Try scanning a product");
    }

    @Test
    void one_item_found() {
        Display display = new Display();
        CashRegister cashRegister = new CashRegister(display, new Catalog(Map.of(Barcode.parse("12345"), new Price(6.5))));
        cashRegister.onBarcode(Barcode.parse("12345"));

        cashRegister.onTotal();

        assertThat(display.lastDisplayed()).isEqualTo("Total: 6.50");
    }
}
