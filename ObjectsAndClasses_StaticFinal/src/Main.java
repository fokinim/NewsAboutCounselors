public class Main {
    public static void main(String[] args) {

        Processor defaultProcessor = new Processor(0,0,ProcessorManufacturer.UNKNOWN,0);
        Ram defaulRam = new Ram(0,RamType.UNKNOWN,0);
        HardDrive defaultHardDrive = new HardDrive(0,0,HardDriveType.UNKNOWN);
        Display defaultDisplay = new Display(0,0,DisplayType.UNKNOWN);
        Keyboard defaultKeyboard = new Keyboard(false,0,KeyboardType.UNKNOWN);

        Computer computer1 = new Computer("ASUS", "Dream", defaultProcessor, defaulRam,
                defaultHardDrive, defaultDisplay, defaultKeyboard);
        computer1.setProcessor(5000,4,ProcessorManufacturer.APPLE,250);
        computer1.setRam(1024,RamType.DDR2,100);
        computer1.setHardDrive(512,650,HardDriveType.SSD);
        computer1.setDisplay(42,1050,DisplayType.IPS);
        computer1.setKeyboard(true,320,KeyboardType.WIRELESS);


        Computer computer2 = new Computer("Lenovo","OldFriend", defaultProcessor, defaulRam,
                defaultHardDrive, defaultDisplay, defaultKeyboard);
        computer2.setProcessor(1000,1,ProcessorManufacturer.AMD,150);
        computer2.setRam(512,RamType.DDR,120);
        computer2.setHardDrive(256,750,HardDriveType.HDD);
        computer2.setDisplay(21,1550,DisplayType.VA);
        computer2.setKeyboard(false,650,KeyboardType.PRACTICE);

        System.out.println("Конфигурация копмьютера 1");
        System.out.println(computer1);
        System.out.println("Общая масса компьютера: " + computer1.getComputerWeight());
        System.out.println();
        System.out.println("Конфигурация копмьютера 2");
        System.out.println(computer2);
        System.out.println("Общая масса компьютера: " + computer2.getComputerWeight());



    }
}
