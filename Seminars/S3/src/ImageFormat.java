public abstract class ImageFormat extends Image {
    public ImageFormat(int width, int height) {
        super(width, height);
    }
    public abstract void load();
    public abstract void save();
}
