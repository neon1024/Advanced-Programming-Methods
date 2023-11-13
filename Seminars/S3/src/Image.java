public class Image {
    protected int width;
    protected int height;
    protected Pixel[][] pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Pixel getPixelAt(int x, int y) {
        return pixels[x][y];
    }

    public void resize(int scale) {}

    public void flipVertically() {}

    public void flipHorizontally() {}
}
