/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author rafael
 */
public class File {
   
    private int id;
    private Indexed_Block indexBlock;

    public File(int id, Indexed_Block indexBlock) {
        this.id = id;
        this.indexBlock = indexBlock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Indexed_Block getIndexBlock() {
        return indexBlock;
    }

    public void setIndexBlock(Indexed_Block indexBlock) {
        this.indexBlock = indexBlock;
    }
    
}
