package bootstrap;

public class ConsoleDisplay implements Display {

    private String lastDisplayed;

    @Override
    public String lastDisplayed() {
        return lastDisplayed;
    }

    @Override
    public void show(String text) {
        this.lastDisplayed = text;
    }
}
