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
    
    private String name;
    private int size;
    private int blockSize;
    
    private ArrayList<Indexed_Block> blocks;
    private ArrayList<File> directory;

    public Indexed_Partition(String name, int size, int blockSize) {
        this.name = name;
        this.size = size;
        this.blockSize = blockSize;
        this.blocks = createBlocks(size, blockSize);
        this.directory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    private ArrayList<Indexed_Block> createBlocks(int size, int blockSize){
        ArrayList<Indexed_Block> blocks = new ArrayList<>();
        for (int i = 0; i < (size/blockSize); i++) {
            Indexed_Block block = new Indexed_Block(i, blockSize);
            blocks.add(block);
        }
        return blocks;
    }
}
