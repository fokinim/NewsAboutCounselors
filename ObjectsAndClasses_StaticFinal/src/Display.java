public class Display {
    private final int displayDiagonal;
    private final int displayWeight;
    private final DisplayType displayType;

    public Display(int displayDiagonal, int displayWeight, DisplayType displayType) {
        this.displayDiagonal = displayDiagonal;
        this.displayWeight = displayWeight;
        this.displayType = displayType;
    }

    public int getDisplayWeight() {
        return displayWeight;
    }

    public String toString() {
        return "Диагональ экрана: " + displayDiagonal + "\n" +
                "Тип экрана: " + displayType + "\n" +
                "Масса экрана: " + displayWeight;
    }
}
