public class Keyboard {
    private final boolean keyboardLight;
    private final int keyboardWeight;
    private final KeyboardType keyboardType;

    public Keyboard(boolean keyboardLight, int keyboardWeight, KeyboardType keyboardType) {
        this.keyboardLight = keyboardLight;
        this.keyboardWeight = keyboardWeight;
        this.keyboardType = keyboardType;
    }

    public int getKeyboardWeight() {
        return keyboardWeight;
    }

    public String toString() {
        return "Наличие подсветки клавиатуры: " + keyboardLight + '\n' +
                "Тип клавиатуры: " + keyboardType + '\n' +
                "Масса клавиатуры: " + keyboardWeight;
    }
}
