/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Constants.Constants;
import Exceptions.ExistenceException;
import Exceptions.OutOfRangeException;
import Exceptions.WithoutSpaceException;
import Objects.File;
import Objects.Indexed_Block;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public void createFile(int id, int size) throws WithoutSpaceException, ExistenceException{
        int requiredBlock = requiredBlocks(size);
        int filesInDirextory = filesInDirectory(requiredBlock);
        int totalBlocksNeeded = requiredBlock + filesInDirextory;
        int spaceRequired = totalBlocksNeeded * Indexed_Block.SIZE_BLOCK;
        if (freeSpace() < spaceRequired){
            throw new WithoutSpaceException("No se puede Guardar el archivo\n Espacio Insuficiente");
        } else if (searchFile(id) != null){
            throw new ExistenceException("Ya existe un archivo con ese Id");
        } else {
            for (int i = 0; i < filesInDirextory; i++) {       
                Indexed_Block indexBlock = searchfreeBlock();
                indexBlock.setStatus(Constants.INDEX);
                size = locateFile(size, indexBlock);
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
    
    private File searchFile(int id){
        ArrayList<File> directory = indexedPartition.getDirectory();
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).getId() == id){
                return directory.get(i);
            }
        }
        return null;
    }
    
    private int locateFile(int size, Indexed_Block index){
        int counter = 0;
        while (size > 0 && counter<Constants.POINTERS_PER_BLOCK){
            Indexed_Block dataBlock = searchfreeBlock();
            size = fillBlockData(size, dataBlock);
            index.getPrompters()[counter] = dataBlock;
            counter++;
        }
        return size;
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
    
    public String directoryReport(){
        String report = "REPORTE DE DIRECTORIO - ASIGNACION INDEXADA\n";
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        report += ("Fecha del Reporte: "+hourdateFormat.format(date));
        report += "\n-------------------------------------------\n";
        report += "\nARCHIVO              BLOQUE INDICE\n";
        for (int i = 0; i < indexedPartition.getDirectory().size(); i++) {
            report += indexedPartition.getDirectory().get(i).getId() + "                    "
                    + indexedPartition.getDirectory().get(i).getIndexBlock().getId() + "\n";
        }
        return report;
    }
    
    public String blockReport(int numberOfBlocks) throws OutOfRangeException{
        if (indexedPartition.getBlocks().size() < numberOfBlocks){
            throw new OutOfRangeException("La cantidad de bloques ingresada es mayor a la existente");
        } else {
            String report = "REPORTE DE BLOQUES - ASIGNACION INDEXADA\n";
            Date date = new Date();
            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            report += ("Fecha del Reporte: "+hourdateFormat.format(date));
        report += "\n-------------------------------------------\n";
        report += printBlocks(numberOfBlocks);
        return report;
        }   
    }
    
    private String printBlocks(int numberOfBlocks){
        int blocksPerLine = 0;
        String text = "";
        ArrayList<Indexed_Block> blocks = indexedPartition.getBlocks();
        for (int i = 0; i < numberOfBlocks; i++) {
            if (blocksPerLine < Constants.BLOCK_PER_LINE_REPORT){
                blocksPerLine++;
                text += printOneBlock(blocks.get(i));
            } else {
                text += "\n";
                blocksPerLine = 0;
                text += printOneBlock(blocks.get(i));
            }
        }
        return text;
    }
    
    private String printOneBlock(Indexed_Block block){
        String textBlock = "";
        switch (block.getStatus()){
            case Constants.DATA:
                textBlock = "|" + block.getId() + "_" + "Ocupado: " + block.getSpaceUsed() + "_" + Constants.OCCUPIED + "|";
                break;
            case Constants.INDEX:
                textBlock = "|{" + block.getId() + "_" + printIndexes(block) + "_" + Constants.OCCUPIED + "}|";
                break;
            case Constants.FREE:
                textBlock = "|" + block.getId() + "_" + "-------"+ "_" + Constants.FREE + "|";
                break;
            default:
                break;
        }
        return textBlock;
    }
    
    private String printIndexes(Indexed_Block block){
        String text = "";
        for (int i = 0; i < Constants.POINTERS_PER_BLOCK; i++) {
            if (block.getPrompters()[i] != null){
                text += block.getPrompters()[i].getId() + " ";
            }
        }
        return text;
    }
    /*
    private String indexFile(int id){
        String indexes = "";
        for (int i = 0; i < indexedPartition.getDirectory().size(); i++) {
            if (indexedPartition.getDirectory().get(i).getId() == id){
                indexes += indexedPartition.getDirectory().get(i).getIndexBlock().getId() + " ";
            }
        }
        return indexes;
    }*/
}
