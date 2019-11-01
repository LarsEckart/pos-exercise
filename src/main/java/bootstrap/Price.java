package bootstrap;

public class Price {

    private double value;

    public Price(double value) {
        this.value = value;
    }

    @Override public String toString() {
        return String.valueOf(value);
    }
}
