package bootstrap;

import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SellMultipleItems {

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
        CashRegister cashRegister = new CashRegister(display,
                new Catalog(Map.of(Barcode.parse("12345"), new Price(Money.ofMinor(CurrencyUnit.EUR, 650)))));
        cashRegister.onBarcode(Barcode.parse("12345"));

        cashRegister.onTotal();

        assertThat(display.lastDisplayed()).isEqualTo("Total: EUR 6.50");
    }

    @Test
    void one_item_not_found() {
        Display display = new Display();
        CashRegister cashRegister = new CashRegister(display,
                new Catalog(Map.of(Barcode.parse("12345"), new Price(Money.ofMinor(CurrencyUnit.EUR, 650)))));

        cashRegister.onBarcode(Barcode.parse("99999"));
        cashRegister.onTotal();

        assertThat(display.lastDisplayed()).isEqualTo("No sale in progress. Try scanning a product");
    }
}
