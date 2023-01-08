import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator(-3, 26);
        Dimensions dimensions = new Dimensions(20,50,45);
        CargoInfo cargoInfo = new CargoInfo(dimensions,120,"поселок Доброград",
                true, "343NM1",false);

        while (true) {
            System.out.print("Введите номер этажа или '999' для изменения характеристик груза, " +
                    "'000' - для просмотра параметров груза: ");

            int floor = new Scanner(System.in).nextInt();

            if (floor == 999) {
                System.out.println("Новые параметры груза");
                dimensions.setDimensions();
                System.out.println(cargoInfo.setCargoinfo());
                System.out.println();
                System.out.println("Старые параметры груза");
                System.out.println(cargoInfo);
            } else if (floor == 000) {
                System.out.println("Просмотр параметров груза");
                System.out.println(cargoInfo);
            } else {
                elevator.move(floor);
            }
        }
    }
}
