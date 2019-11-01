package bootstrap;

public class Display {

    private String lastDisplayed;

    public String lastDisplayed() {
        return lastDisplayed;
    }

    public void displayEmptyProductMessage() {
        this.lastDisplayed = "Error, empty barcode!";
    }

    public void displayProductNotFound(Barcode barcode) {
        this.lastDisplayed = "No price available for item " + barcode;
    }

    public void displayPrice(Price price) {
        this.lastDisplayed = price.toString();
    }

    public void total() {
        this.lastDisplayed = "No sale in progress. Try scanning a product";
    }

    public void displayTotalPurchase(Price total) {
        lastDisplayed = "Total: " + total.toString();
    }
}
