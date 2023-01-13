public class Computer {
    private String message;
    private final String vendor;
    private final String name;
    private Processor processor;
    private Ram ram;
    private HardDrive hardDrive;
    private Display display;
    private Keyboard keyboard;
    private int computerWeight;

    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public Display getDisplay() {
        return display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public int getComputerWeight() {
        return computerWeight;
    }

    public Computer(String vendor, String name, Processor processor, Ram ram, HardDrive hardDrive, Display display, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.display = display;
        this.keyboard = keyboard;
    }

    public Computer setProcessor(int frequency, int coresAmount,
                                 ProcessorManufacturer processorManufacturer,
                                 int processorWeight) {
        processor = new Processor(frequency, coresAmount, processorManufacturer, processorWeight);
        summaryComputerWeight(processorWeight);
        return new Computer(vendor, name, processor, ram, hardDrive, display, keyboard);
    }

    public Computer setRam(int ramAmount, RamType ramType, int ramWeight) {
        ram = new Ram(ramAmount, ramType, ramWeight);
        summaryComputerWeight(ramWeight);
        return new Computer(vendor, name, processor, ram, hardDrive, display, keyboard);
    }

    public Computer setHardDrive(int hardDriveVolume, int hardDriveWeight, HardDriveType hardDriveType) {
        hardDrive = new HardDrive(hardDriveVolume, hardDriveWeight, hardDriveType);
        summaryComputerWeight(hardDriveWeight);
        return new Computer(vendor, name, processor, ram, hardDrive, display, keyboard);
    }

    public Computer setDisplay(int displayDiagonal, int displayWeight, DisplayType displayType) {
        display = new Display(displayDiagonal, displayWeight, displayType);
        summaryComputerWeight(displayWeight);
        return new Computer(vendor, name, processor, ram, hardDrive, display, keyboard);
    }

    public Computer setKeyboard(boolean keyboardLight, int keyboardWeight, KeyboardType keyboardType) {
        keyboard = new Keyboard(keyboardLight, keyboardWeight, keyboardType);
        summaryComputerWeight(keyboardWeight);
        return new Computer(vendor, name, processor, ram, hardDrive, display, keyboard);
    }

    public void summaryComputerWeight(int weight) {
        computerWeight = computerWeight + weight;
    }

    public String toString() {
        message = "Производитель: " + vendor + "\n" + "Имя: " + name + "\n" + processor.processorToString() + "\n" +
                ram.ramToString() + "\n" + hardDrive.hardDrivetoString() + "\n" + display.displayToString() + "\n" +
                keyboard.keyboardToString();
        return message;
    }

}
