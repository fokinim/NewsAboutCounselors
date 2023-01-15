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


    public Computer(String vendor, String name, Processor processor, Ram ram, HardDrive hardDrive, Display display, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.display = display;
        this.keyboard = keyboard;
    }

    public int getComputerWeight() {
        computerWeight = processor.getProcessorWeight() + ram.getRamWeight() + hardDrive.getHardDriveWeight() +
                display.getDisplayWeight() + keyboard.getKeyboardWeight();
        return computerWeight;
    }
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

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String toString() {
        message = "Производитель: " + vendor + "\n" + "Имя: " + name + "\n" + processor.toString() + "\n" +
                ram.toString() + "\n" + hardDrive.toString() + "\n" + display.toString() + "\n" +
                keyboard.toString();
        return message;
    }

}
