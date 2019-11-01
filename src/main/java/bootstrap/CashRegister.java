package bootstrap;

public class CashRegister {
    private final Display display;

    public CashRegister(Display display) {
        this.display = display;
    }

    public void onBarcode(String barcode) {
        display.show("3€");
    }
}
