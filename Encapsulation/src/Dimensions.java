public class Dimensions {
    private final int width;
    private final int height;
    private final int length;
    private final int cargoVolume;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.cargoVolume = width * height * length;
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
        return cargoVolume;
    }
    public Dimensions setWidth(int width) {
        return new Dimensions(width, height, length);
    }
    public Dimensions setHeight(int height) {
        return new Dimensions(width, height, length);
    }
    public Dimensions setLength(int length) {
        return new Dimensions(width, height, length);
    }
}
