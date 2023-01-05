public class Arithmetic {
    private int number1;
    private int number2;
    private int result;

    public Arithmetic(int transmittedNumber1, int transmittedNumber2) {
        number1 = transmittedNumber1;
        number2 = transmittedNumber2;
    }
    public int sum() {
        result = number1 + number2;
        return result;
    }
    public int multiplication() {
        result = number1 * number2;
        return result;
    }
    public int min() {
        if (number1 > number2) {
            result = number2;
        } else if (number1 < number2) {
            result = number1;
        } else {
            result = number1;
        }
        return result;
    }
    public int max() {
        if (number1 > number2) {
            result = number1;
        } else if (number1 < number2) {
            result = number2;
        } else {
            result = number1;
        }
        return result;
    }
}
