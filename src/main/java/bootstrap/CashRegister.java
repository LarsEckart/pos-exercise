package bootstrap;

public class CashRegister {
    private final Display display;

    public CashRegister(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("12345".equalsIgnoreCase(barcode)) {
            display.show("3€");
            return;
        } else if ("23456".equalsIgnoreCase(barcode)) {
            display.show("5€");
            return;
        }
        display.show("10€");
    }
}
