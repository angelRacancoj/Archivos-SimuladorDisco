package bloques;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class Block {
    private int id;
    private int tamanio;
    
    public Block(int id,int tamanio){
        this.id=id;
        this.tamanio=tamanio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    
    
}
