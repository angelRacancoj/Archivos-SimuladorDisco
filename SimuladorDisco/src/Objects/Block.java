package Objects;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class Block {
    
    private int id;
    private int size;
    private File data;
    
    
    public Block(int id,File data){
        this.id=id;
        this.data=data;
    }

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

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
