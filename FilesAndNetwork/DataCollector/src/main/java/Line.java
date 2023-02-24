public class Line {
    private String name;
    private String number;


    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }



    public String toString() {
        String message = "Линия: " + name + System.lineSeparator() + "Номер линии: " + number;
        return message;
    }
}
