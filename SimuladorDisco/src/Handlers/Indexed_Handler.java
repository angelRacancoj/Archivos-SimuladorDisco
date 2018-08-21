/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Constants.Constants;
import Exceptions.OutOfRangeException;
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
        this.indexedPartition = new Indexed_Partition();
    }
    
    /**
     * Crea una nueva partición de asignacion indexada
     * @param size tamaño de la particion en Megabytes
     * @param blocksize tamaño de los bloques en KyloBytes
     * @return True si se creo de forma correcta 
     * @throws OutOfRangeException 
     */
    public boolean createPartition(int size, int blocksize) throws OutOfRangeException{
        int sizeKb = convertMbtoKb(size);
        if (sizeKb < blocksize){
            throw new OutOfRangeException("El tamaño de los bloques no puede ser mayor al tamaño de la partición");
        } else {
            this.indexedPartition.setSize(sizeKb);
            this.indexedPartition.setBlockSize(blocksize);
            this.indexedPartition.createBlocks(sizeKb, blocksize);
            System.out.println("Espacio Disponible: " + freeSpace());
            return true;
        }
    }
    
    /**
     * Crear un nuevo archivo para almacear 
     * @param id   id del archivo
     * @param size
     * @throws WithoutSpaceException 
     */
    public void createFile(int id, int size) throws WithoutSpaceException{
        int requiredBlock = requiredBlocks(size);
        int filesInDirextory = filesInDirectory(requiredBlock);
        int totalBlocksNeeded = requiredBlock + filesInDirextory;
        int spaceRequired = totalBlocksNeeded * Indexed_Block.SIZE_BLOCK;
        if (freeSpace() < spaceRequired){
            throw new WithoutSpaceException("No se puede Guardar el archivo\n Espacio Insuficiente");
        } else {
            ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
            for (int i = 0; i < filesInDirextory; i++) {       
                Indexed_Block indexBlock = searchfreeBlock();
                indexBlock.setStatus(Constants.INDEX);
                locateFile(size, indexBlock);
                indexedPartition.getDirectory().add(new File(id,indexBlock));
            }
        }
    }
    
    private int requiredBlocks(int size){
        if (size%Indexed_Block.SIZE_BLOCK == 0){
            return size/Indexed_Block.SIZE_BLOCK;
        } else { 
            return (size/Indexed_Block.SIZE_BLOCK) + 1;
        }
    }
    
    private int filesInDirectory(int requiredBlock){
        int filesInDirectory = requiredBlock/Constants.POINTERS_PER_BLOCK;
        if ((requiredBlock % Constants.POINTERS_PER_BLOCK) != 0){
            filesInDirectory++;
        }
        return filesInDirectory;
    }
    
    /**
     * Busca un cuadro libre
     * @return cuadro libre encontrado o en su defecto null
     */
    private Indexed_Block searchfreeBlock(){
        ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getStatus() == Constants.FREE){
                return blocks.get(i);
            }
        }
        return null;
    }
    
    
    private void locateFile(int size, Indexed_Block index){
        int counter = 0;
        while (size > 0){
            Indexed_Block dataBlock = searchfreeBlock();
            size = fillBlockData(size, dataBlock);
            index.getPrompters()[counter] = dataBlock;
            counter++;
        }
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
    
    /**
     * Determina el almacenamiento libre en KyloBytes
     * @return ALmacenamiento libre/Disponible en KyloBytes
     */
    public int freeSpace(){
        int amountOfFreeBlocks = 0;
        for (int i = 0; i < indexedPartition.getBlocks().size(); i++) {
            if (indexedPartition.getBlocks().get(i).getStatus() == Constants.FREE){
                amountOfFreeBlocks++;
            }
        }
        return amountOfFreeBlocks * Indexed_Block.SIZE_BLOCK;
    }
   
    /**
     * Convierte de Megabytes a KyloByte
     * @param mb tamaño en Megabyte a convertir
     * @return 
     */
    private int convertMbtoKb(int mb){
        return mb*1024;
    }
}
