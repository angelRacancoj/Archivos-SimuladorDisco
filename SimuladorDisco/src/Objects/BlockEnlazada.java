package Objects;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class BlockEnlazada extends Block {
    
    private int puntero=0;
    
    public BlockEnlazada(int id, File data,int puntero) {
        super(id, data);
        this.puntero=puntero;
    }
}
