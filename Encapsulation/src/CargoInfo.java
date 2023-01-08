public class CargoInfo {

    private Dimensions dimensions;
    private final int weight;
    private final String deliveryAddress;
    private final boolean flipOk;
    private final String regNumber;
    private final boolean fragile;

    public CargoInfo(Dimensions dimensions, int weight, String deliveryAddress,
                     boolean flipOk, String regNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.flipOk = flipOk;
        this.regNumber = regNumber;
        this.fragile = fragile;
    }

    public CargoInfo setCargoinfo() {
        return new CargoInfo(dimensions.setDimensions(), 480, "Нью-йорк",
                flipOk, regNumber, fragile);
    }

    public String toString() {

        String flipOkString = flipOk ? "Да" : "Нет";
        String fragileString = fragile ? "Да" : "Нет";

        return "Ширина: " + dimensions.getWidth() + "\n" +
                "Высота: " + dimensions.getHeight() + "\n" +
                "Длина: " + dimensions.getLength() + "\n" +
                "Вес: " + weight + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Можно переворачивать: " + flipOkString + "\n" +
                "Регистрационный номер: " + regNumber + "\n" +
                "Хрупкое: " + fragileString;
    }

}
