package Objects;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class Block {
    private int id;
    private File data;
    public Block(int id,File data){
        this.id=id;
        this.data=data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }
    
}
