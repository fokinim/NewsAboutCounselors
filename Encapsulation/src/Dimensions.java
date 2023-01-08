public class Dimensions {
    private final int width;
    private final int height;
    private final int length;
    private int cargoVolume;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
    public int cargoVolume() {
        cargoVolume = width * height * length;
        return cargoVolume;
    }

    public Dimensions setDimensions() {
        return new Dimensions(450,250,140);
    }


}
