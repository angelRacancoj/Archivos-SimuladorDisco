/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Constants.Constants;

/**
 *
 * @author rafael
 */
public class Indexed_Block extends Block{
    
    public static int SIZE_BLOCK;
    
    private int status;
    private int spaceUsed; 
    private Indexed_Block[] prompters = new Indexed_Block[Constants.POINTERS_PER_BLOCK];
    
    public Indexed_Block(int id, int size) {
        super(id, size);
        this.status = Constants.FREE;
        this.spaceUsed = 0;
        SIZE_BLOCK = size;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(int spaceUsed) {
        this.spaceUsed = spaceUsed;
    }

    public Indexed_Block[] getPrompters() {
        return prompters;
    }

    public void setPrompters(Indexed_Block[] prompters) {
        this.prompters = prompters;
    }
    
}
