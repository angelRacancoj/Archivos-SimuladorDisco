package Objects;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class Block {
    
    private int id;
    private int size;

    public Block(int id, int size){
        this.id = id;
        this.size = size;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
