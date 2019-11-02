package bootstrap;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Price {

    private int cents;

    public Price(int value) {
        this.cents = value;
    }

    @Override
    public String toString() {
        return Money.ofMinor(CurrencyUnit.EUR, cents).toString();
    }
}
