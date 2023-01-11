public class Basket {

    private static int count = 0;
    private static int fullPrice;
    private static int totalItemsAmount;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight;

    public static void fullPriceCount(int price) {
        fullPrice = fullPrice + price;
    }

    public static void totalItemsCount(int itemsCount) {
        totalItemsAmount = totalItemsAmount + itemsCount;
    }

    public static double averagePriceOfProduct() {
        return (double) fullPrice / totalItemsAmount;
    }

    public static double averageBasketCost() {
        return (double) fullPrice / count;
    }


    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count, double weight) {
        totalWeight = totalWeight + weight;
        add(name, price, count);

    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        fullPriceCount(count * price);
        totalItemsCount(count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);

        }
    }

    public static void printAverageValues() {
        System.out.println("Средняя стоимость товара в корзинах: " + averagePriceOfProduct());
        System.out.println("Средняя стоимость корзины: " + averageBasketCost());

    }
}

