import com.sun.source.tree.BreakTree;

public class Elevator {


    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int moveDown() {
        currentFloor = currentFloor - 1;
        return currentFloor;
    }
    public int moveUp() {
        currentFloor = currentFloor + 1;
        return currentFloor;
    }
    public void errorFloorNumber() {
        String message = "Недопустимый номер этажа";
        System.out.println(message);
    }
    public void move(int floor) {
        boolean correctFloor = floor >= minFloor && floor <= maxFloor;

        if (correctFloor) {
            while (currentFloor != floor) {
                currentFloor = currentFloor < floor ? moveUp() : moveDown();
                System.out.println(currentFloor);
            }
        } else {
            errorFloorNumber();
        }
    }
}

