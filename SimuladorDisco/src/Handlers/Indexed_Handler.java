/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Constants.Constants;
import Exceptions.WithoutSpaceException;
import Objects.File;
import Objects.Indexed_Block;
import java.util.ArrayList;
import partitions.Indexed_Partition;

/**
 *
 * @author rafael
 */
public class Indexed_Handler {

    private Indexed_Partition indexedPartition;
    
    public Indexed_Handler() {
    
    }
    
    public void createPartition(String name, int size, int blocksize){
        this.indexedPartition = new Indexed_Partition(name, convertMbtoKb(size), blocksize);
    }
    
    public void createFile(int id, int size) throws WithoutSpaceException{
        if (freeSpace() < size + 1*Indexed_Block.SIZE_BLOCK){
            throw new WithoutSpaceException("No se puede Guardar el archivo\n Espacio Insuficiente");
        } else {
            ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
            int requiredBlock;
            if (size%Indexed_Block.SIZE_BLOCK == 0){
                requiredBlock = size/Indexed_Block.SIZE_BLOCK;
            } else { 
                requiredBlock = (size/Indexed_Block.SIZE_BLOCK) + 1;
            }        
            
            int filesInDirextory = requiredBlock/Constants.POINTERS_PER_BLOCK;
            if ((requiredBlock % Constants.POINTERS_PER_BLOCK) != 0){
               filesInDirextory++;
            }
        
            for (int i = 0; i < filesInDirextory; i++) {
                for (int j = 0; j < blocks.size(); j++) {
                    if (blocks.get(j).getStatus() == Constants.FREE){
                        Indexed_Block indexBlock = blocks.get(j);
                        indexBlock.setStatus(Constants.INDEX);
                        int counter = 1;
                        while (size > 0 && counter < 4){
                            Indexed_Block block = searchfreeBlock();
                            switch (counter){
                                case 1:
                                    indexBlock.setPrompter1(block);
                                    size = fillBlockData(size, block);
                                    counter++;
                                    break;
                                case 2:
                                    indexBlock.setPrompter2(block);
                                    size = fillBlockData(size, searchfreeBlock());
                                    counter++;
                                    break;
                                case 3: 
                                    indexBlock.setPrompter2(block);
                                    size = fillBlockData(size, searchfreeBlock());
                                    counter++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        indexedPartition.getDirectory().add(new File(id,indexBlock));
                    }                
                } 
               
            }
        }
    }
    
    private Indexed_Block searchfreeBlock(){
        ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getStatus() == Constants.FREE){
                return blocks.get(i);
            }
        }
        return null;
    }
    
    private int fillBlockData(int size, Indexed_Block block){
        block.setStatus(Constants.DATA);
        if (size >= Indexed_Block.SIZE_BLOCK){
            block.setSpaceUsed(Indexed_Block.SIZE_BLOCK);
            return size-Indexed_Block.SIZE_BLOCK;
        } else {
            block.setSpaceUsed(size);
            return 0;
        }
    }
    
    private Indexed_Block searchBlock(int idBlock) {
        ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getId() == idBlock) {
                    return blocks.get(i);
            }
        }
        return null;
    }
    
    
    /**
     * Calcula es espacio disponible en el disco
     * @return 
     */
    public int freeSpace(){
        ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
        int amountOfFreeBlocks = 0;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getStatus() == Constants.FREE){
                amountOfFreeBlocks++;
            }
        }
        return amountOfFreeBlocks * Indexed_Block.SIZE_BLOCK;
    }
    
    
    private int convertMbtoKb(int mb){
        return mb*1024;
    }
}
