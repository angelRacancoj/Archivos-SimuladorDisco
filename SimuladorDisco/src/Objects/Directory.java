package Objects;

/**
 *
 * @author teodoro
 */
public class Directory {

    private int file;
    private int position;

    public Directory(int file, int position) {
        this.file = file;
        this.position = position;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
