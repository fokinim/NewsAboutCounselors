public class Ram {
    private final int ramAmount;
    private final RamType ramType;
    private final int ramWeight;

    public Ram(int ramAmount, RamType ramType, int ramWeight) {
        this.ramAmount = ramAmount;
        this.ramType = ramType;
        this.ramWeight = ramWeight;
    }

    public int getRamWeight() {
        return ramWeight;
    }

    public String toString() {
        return "Объем оперативной памяти: " + ramAmount + "\n" +
                "Тип оперативной памяти: " + ramType + "\n" +
                "Масса оперативной памяти: " + ramWeight;

    }
}
