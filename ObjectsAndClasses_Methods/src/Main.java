public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Содержимое корзины:");
        Basket basket1 = new Basket();
        basket1.add("Salt", 4);
        basket1.add("Eggs", 25);
        basket1.print("Содержимое корзины:");
        Basket.printAverageValues();
    }
}
