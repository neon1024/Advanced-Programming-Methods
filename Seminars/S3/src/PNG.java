public class PNG implements ImageFormat {
    Image img;

    public PNG(int width, int height) {
        super(width, height);
        this.img = new Image(width, height);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
