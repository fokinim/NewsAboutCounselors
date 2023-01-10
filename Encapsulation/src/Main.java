import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator(-3, 26);
        Dimensions dimensions = new Dimensions(20, 50, 45);
        Cargo cargo = new Cargo(dimensions, 120, "поселок Доброград",
                true, "343NM1", false);

        while (true) {
            System.out.print("Введите номер этажа или '999' для изменения характеристик груза, " +
                    "'000' - для просмотра параметров груза: ");

            int floor = new Scanner(System.in).nextInt();

            if (floor == 999) {
                Dimensions copyDimension = dimensions.setWidth(150);
                Cargo copyCargo = cargo.setDimensions(copyDimension);
                System.out.println("Измененная ширина: ");
                System.out.println(copyCargo);

                copyDimension = dimensions.setHeight(450);
                copyCargo = cargo.setDimensions(copyDimension);
                System.out.println();
                System.out.println("Измененная высота: ");
                System.out.println(copyCargo);

                copyDimension = dimensions.setLength(250);
                copyCargo = cargo.setDimensions(copyDimension);
                System.out.println();
                System.out.println("Измененная длина: ");
                System.out.println(copyCargo);

                copyCargo = cargo.setWeight(10);
                System.out.println();
                System.out.println("Измененная масса: ");
                System.out.println(copyCargo);

                copyCargo = cargo.setDeliveryAddress("Москва");
                System.out.println();
                System.out.println("Измененный адрес: ");
                System.out.println(copyCargo);

                System.out.println();
                System.out.println("Исходные параметры груза: ");
                System.out.println(cargo);

            } else if (floor == 000) {
                System.out.println("Просмотр параметров груза");
                System.out.println(cargo);
            } else {
                elevator.move(floor);
            }
        }
    }
}
