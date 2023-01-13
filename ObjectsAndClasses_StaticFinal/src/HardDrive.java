public class HardDrive {
    private final int hardDriveVolume;
    private final int hardDriveWeight;
    private final HardDriveType hardDriveType;

    public HardDrive(int hardDriveVolume, int hardDriveWeight, HardDriveType hardDriveType) {
        this.hardDriveVolume = hardDriveVolume;
        this.hardDriveWeight = hardDriveWeight;
        this.hardDriveType = hardDriveType;
    }
    public String hardDrivetoString() {
        return "Объем жесткого диска: " + hardDriveVolume + "\n" +
                "Тип жесткого диска: " + hardDriveType + "\n" +
                "Масса жесткого диска: " + hardDriveWeight;

    }
}
