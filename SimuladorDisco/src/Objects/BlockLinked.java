package Objects;

import java.io.File;

/**
 *
 * @author teodoro
 */
public class BlockLinked extends Block {
    private int puntero=0;
    public BlockLinked(int id, File data,int puntero) {
        super(id, data);
        this.puntero=puntero;
    }

    public int getPuntero() {
        return puntero;
    }

    public void setPuntero(int puntero) {
        this.puntero = puntero;
    }
    
}
