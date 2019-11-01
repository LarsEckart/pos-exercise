package bootstrap;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Price {

    private double value;

    public Price(double value) {
        this.value = value;
    }

    @Override public String toString() {
        NumberFormat f = NumberFormat.getInstance(Locale.US);
        if (f instanceof DecimalFormat) {
            ((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
            ((DecimalFormat) f).setMinimumFractionDigits(2);
        }
        return f.format(value);
    }
}
