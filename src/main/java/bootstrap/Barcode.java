package bootstrap;

import java.util.Objects;

public class Barcode {

    private final String value;

    private Barcode(String value) {
        this.value = value;
    }

    public static Barcode parse(String value) {
        return new Barcode(value);
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    @Override public String toString() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barcode barcode = (Barcode) o;
        return Objects.equals(value, barcode.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
