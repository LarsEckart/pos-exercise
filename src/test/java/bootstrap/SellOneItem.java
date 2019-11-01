package bootstrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SellOneItem {

    private Display display;
    private CashRegister cashRegister;

    @BeforeEach
    void setUp() {
        Catalog catalog = new Catalog();
        catalog.add(new Item("12345", "3€"));
        catalog.add(new Item("23456", "5€"));
        catalog.add(new Item("34567", "10€"));
        display = new ConsoleDisplay();
        cashRegister = new CashRegister(display, catalog);
    }

    @Test
    void scan_one_product_displays_price() {
        cashRegister.onBarcode("12345");

        assertThat(display.lastDisplayed()).isEqualTo("3€");
    }

    @Test
    void scan_another_product_displays_price() {
        cashRegister.onBarcode("23456");

        assertThat(display.lastDisplayed()).isEqualTo("5€");
    }

    @Test
    void scan_yet_another_product_displays_price() {
        cashRegister.onBarcode("34567");

        assertThat(display.lastDisplayed()).isEqualTo("10€");
    }

    @Test
    void scan_item_for_which_we_dont_have_price() {
        cashRegister.onBarcode("00000");

        assertThat(display.lastDisplayed()).isEqualTo("No price available");
    }
}