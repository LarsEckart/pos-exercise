package bootstrap;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SellOneItem {

    @Test
    void scan_one_product_displays_price() {
        Display display = new ConsoleDisplay();
        CashRegister cashRegister = new CashRegister(display);

        cashRegister.onBarcode("12345");

        assertThat(display.lastDisplayed()).isEqualTo("3€");
    }
}
