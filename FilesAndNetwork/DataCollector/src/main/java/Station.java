public class Station {
    private String name;
    private String line;
    private String date;
    private String depth;
    private String hasConnection;

    public Station(String name, String line, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.hasConnection = String.valueOf(hasConnection);
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }

    public String getDate() {
        return date;
    }

    public String getDepth() {
        return depth;
    }

    public String getHasConnection() {
        return hasConnection;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }


    public String toString() {
        String message = "Станция: " + name + System.lineSeparator() +
                "Номер линии: " + line + System.lineSeparator() +
                "Дата основания: " + date + System.lineSeparator() +
                "Глубина: " + depth + System.lineSeparator() +
                "hasConnection: " + hasConnection;
        return message;
    }
}
