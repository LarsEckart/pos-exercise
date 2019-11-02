package bootstrap;

import org.joda.money.Money;

public class Price {

    private Money money;

    public Price(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return money.toString();
    }
}
