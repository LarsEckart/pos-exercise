package bootstrap;

public interface Display {
    public String lastDisplayed();

    void show(String text);

    default void displayEmptyProductMessage() {
        show("Error, empty barcode!");
    }

    default void displayProductNotFound(String barcode) {
        show("No price available for item " + barcode);
    }

    default void displayPrice(String text) {
        show(text);
    }
}
