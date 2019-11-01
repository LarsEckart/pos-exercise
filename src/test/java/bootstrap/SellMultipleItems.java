package bootstrap;

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
}
