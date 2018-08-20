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
    
    private int[] data = new int[Constants.DATA_SIZE];
            
    private Indexed_Block prompter1;
    private Indexed_Block prompter2;
    private Indexed_Block prompter3;
    
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

    public Indexed_Block getPrompter1() {
        return prompter1;
    }

    public void setPrompter1(Indexed_Block prompter1) {
        this.prompter1 = prompter1;
    }

    public Indexed_Block getPrompter2() {
        return prompter2;
    }

    public void setPrompter2(Indexed_Block prompter2) {
        this.prompter2 = prompter2;
    }

    public Indexed_Block getPrompter3() {
        return prompter3;
    }

    public void setPrompter3(Indexed_Block prompter3) {
        this.prompter3 = prompter3;
    }

    public int getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(int spaceUsed) {
        this.spaceUsed = spaceUsed;
    }
    
}
