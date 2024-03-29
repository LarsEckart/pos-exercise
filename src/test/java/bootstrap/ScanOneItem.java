package bootstrap;

import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScanOneItem {

    private Display display;
    private CashRegister cashRegister;

    @Nested
    class happy_path {

        @BeforeEach
        void setUp() {
            var catalog = new Catalog(Map.of(
                    Barcode.parse("12345"), new Price(Money.ofMinor(CurrencyUnit.EUR, 300)),
                    Barcode.parse("23456"), new Price(Money.ofMinor(CurrencyUnit.EUR, 500)),
                    Barcode.parse("34567"), new Price(Money.ofMinor(CurrencyUnit.EUR, 1000))));
            display = new Display();
            cashRegister = new CashRegister(display, catalog);
        }

        @Test
        void scan_one_product_displays_price() {
            cashRegister.onBarcode(Barcode.parse("12345"));

            assertThat(display.lastDisplayed()).isEqualTo("EUR 3.00");
        }

        @Test
        void scan_another_product_displays_price() {
            cashRegister.onBarcode(Barcode.parse("23456"));

            assertThat(display.lastDisplayed()).isEqualTo("EUR 5.00");
        }

        @Test
        void scan_yet_another_product_displays_price() {
            cashRegister.onBarcode(Barcode.parse("34567"));

            assertThat(display.lastDisplayed()).isEqualTo("EUR 10.00");
        }

        @Test
        void scan_item_for_which_we_dont_have_price() {
            cashRegister.onBarcode(Barcode.parse("99999"));

            assertThat(display.lastDisplayed()).isEqualTo("No price available for item 99999");
        }
    }

    @Test
    void empty_barcode_returns_error_message() {
        // SMELL: refused request? move up call stack?
        display = new Display();
        cashRegister = new CashRegister(display, null);

        cashRegister.onBarcode(Barcode.parse(""));

        assertThat(display.lastDisplayed()).isEqualTo("Error, empty barcode!");
    }
}