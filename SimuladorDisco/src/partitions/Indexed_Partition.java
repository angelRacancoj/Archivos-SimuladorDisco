/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitions;

import Objects.File;
import Objects.Indexed_Block;
import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public class Indexed_Partition {
    
    private int size;
    private int blockSize;
    private ArrayList<Indexed_Block> blocks;
    private ArrayList<File> directory;

    public Indexed_Partition() {
        this.blocks = new ArrayList<>();
        this.directory = new ArrayList<>();
    }

    public ArrayList<Indexed_Block> getBlocks() {
        return blocks;
    }
    
    public void setBlocks(ArrayList<Indexed_Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<File> getDirectory() {
        return directory;
    }
    
    public void setDirectory(ArrayList<File> directory) {
        this.directory = directory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public void createBlocks(int size, int blockSize){
        ArrayList<Indexed_Block> blocksList = new ArrayList<>();
        for (int i = 0; i < (size/blockSize); i++) {
            Indexed_Block block = new Indexed_Block(i, blockSize);
            blocksList.add(block);
        }
        this.blocks.clear();
        this.blocks.addAll(blocksList);
    }
}
