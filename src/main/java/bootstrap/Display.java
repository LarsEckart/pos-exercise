package bootstrap;

public class Display {

    private String lastDisplayed;

    public String lastDisplayed() {
        return lastDisplayed;
    }

    public void displayEmptyProductMessage() {
        this.lastDisplayed = "Error, empty barcode!";
    }

    public void displayProductNotFound(String barcode) {
        this.lastDisplayed = "No price available for item " + barcode;
    }

    public void displayPrice(String text) {
        this.lastDisplayed = text;
    }
}
