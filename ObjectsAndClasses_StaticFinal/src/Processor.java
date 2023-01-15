public class Processor {
    private final int frequency;
    private final int coresAmount;
    private final ProcessorManufacturer processorManufacturer;
    private final int processorWeight;

    public Processor(int frequency, int coresAmount, ProcessorManufacturer processorManufacturer, int processorWeight) {
        this.frequency = frequency;
        this.coresAmount = coresAmount;
        this.processorManufacturer = processorManufacturer;
        this.processorWeight = processorWeight;
    }

    public int getProcessorWeight() {
        return processorWeight;
    }

    public String toString() {
        return "Частота процессора: " + frequency + "\n" +
                "Количество ядер: " + coresAmount + "\n" +
                "Производитель процессора: " + processorManufacturer + "\n" +
                "Масса процессора: " + processorWeight;

    }

}
