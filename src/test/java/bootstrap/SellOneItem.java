package bootstrap;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SellOneItem {

    private Display display;
    private CashRegister cashRegister;

    @Test
    void scan_one_product_displays_price() {
        var catalog = new Catalog(Collections.singletonList(new Item("12345", "3€")));
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);

        cashRegister.onBarcode("12345");

        assertThat(display.lastDisplayed()).isEqualTo("3€");
    }

    @Test
    void scan_another_product_displays_price() {
        var catalog = new Catalog(Collections.singletonList(new Item("23456", "5€")));
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);

        cashRegister.onBarcode("23456");

        assertThat(display.lastDisplayed()).isEqualTo("5€");
    }

    @Test
    void scan_yet_another_product_displays_price() {
        var catalog = new Catalog(Collections.singletonList(new Item("34567", "10€")));
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);

        cashRegister.onBarcode("34567");

        assertThat(display.lastDisplayed()).isEqualTo("10€");
    }

    @Test
    void scan_item_for_which_we_dont_have_price() {
        var catalog = new Catalog(Collections.emptyList());
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);

        cashRegister.onBarcode("12345");

        assertThat(display.lastDisplayed()).isEqualTo("No price available for item 12345");
    }

    @Test
    void empty_barcode_returns_error_message() {
        var catalog = new Catalog(Collections.emptyList());
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);

        cashRegister.onBarcode("");

        assertThat(display.lastDisplayed()).isEqualTo("Error, empty barcode!");
    }
}