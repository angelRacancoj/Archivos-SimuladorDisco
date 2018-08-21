package partitions;

import Objects.Block;
import Objects.BlockLinked;
import Objects.Directory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teodoroD
 */
public class Linked {

    private int DiskSize;
    private List<Directory> directory;
    private List<BlockLinked> blocks;

    //como parametro el tamano de la particion en MB
    public Linked(int DiskSize,int sizeBlocks) {
        //conversion de MB a Kb
        this.DiskSize = DiskSize * 1024;
        this.directory = new ArrayList<>();
        this.blocks = new ArrayList<>();
        //crear los bloques
        createBlocks(this.DiskSize,sizeBlocks);
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }
    public void formatDisk(){
        for (int i = 0; i < blocks.size(); i++) {
            blocks.set(i, new BlockLinked(i, null, 0));
        }
    }

    public List<BlockLinked> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockLinked> blocks) {
        this.blocks = blocks;
    }

    private void createBlocks(int size,int sizeBlocks) {
        int quantity = size / sizeBlocks;
        for (int i = 0; i < quantity; i++) {
            this.blocks.add(new BlockLinked(i, null, 0));
        }
    }

    //metodo recursivo para insertar archvo
    private int insertFile(int index, int size) {
        if (size == 0) {
            if (isEmpty(index)) {
                blocks.get(index).setData(null);
                blocks.get(index).setPuntero(-1);
                return index;
                //blocke Vacio
            } else {
                return insertFile(index(), size);
            }
        } else {
            if (isEmpty(index)) {
                blocks.get(index).setData(null);
                blocks.get(index).setPuntero(-2);
                blocks.get(index).setPuntero(insertFile(index(), size - 1));
                return index;
                //blocke Vacio
            } else {
                return insertFile(index(), size);
            }
        }
    }

    /**
     *
     * @param file
     */
    public void insert(File file) {
        //calcular la cantidad de bloques que usara el archivo
        int size = (int) (file.getTotalSpace() / 4);
        boolean repeat = true;
        int position = index();
        if (space(size)) {
            //agregamos el archivo a guardar en el directorio de archivos
            directory.add(new Directory(Integer.parseInt(file.getName()), position));
            while (repeat) {
                if (isEmpty(position)) {
                    //para no modificar el master no cambie el tipo de atributo para date pero ahi hay que mandar el path
                    blocks.get(position).setData(file);
                    blocks.get(position).setPuntero(insertFile(index(), size - 1));
                    break;
                } else {
                    position = index();
                }
            }
        }
    }

    private int index() {
        return (int) (Math.random() * blocks.size());
    }

    private boolean isEmpty(int id) {
        boolean result = false;
        if (blocks.get(id).getPuntero() == 0) {
            result = true;
        }
        return result;
    }

    private int sizeData(BlockLinked puntero) {
        if (puntero.getPuntero() != -1) {
            return 1 + sizeData(blocks.get(puntero.getPuntero()));
        } else {
            return 1;
        }
    }

    public File getFile(int id) {
        Directory file = dataExist(id);
        if (file != null) {
            return blocks.get(file.getPosition()).getData();
        } else {
            //file no encontrado
            return null;
        }
    }
    private void resetBlock(BlockLinked block){
        blocks.set(block.getId(),new BlockLinked(block.getId(), null, 0));
    }
    private void delete(int puntero){
        if(puntero!=-1){
            delete(blocks.get(puntero).getPuntero());
            resetBlock(blocks.get(puntero));
        }else{
            resetBlock(blocks.get(puntero));
        }
    }

    public void deleteFile(int id) {
        Directory file = dataExist(id);
        if (file != null) {
            delete(file.getPosition());
            directory.remove(file);
        } else {
            //no existe el archivo
        }
    }

    public void modifyFile(File file) {
        if (dataExist(Integer.parseInt(file.getName())) != null) {
            deleteFile(Integer.parseInt(file.getName()));
            insert(file); 
        } else {
            //no existe el archivo
        }
    }

    public int getSizeData(int idFile) {
        int val;
        if (dataExist(idFile) != null) {
            int index = dataExist(idFile).getPosition();
            return 1 + sizeData(blocks.get(blocks.get(index).getPuntero()));
        } else {
            //archivo no encontrado
            return -1;
        }
    }

    private Directory dataExist(int idFile) {
        Directory state = null;
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i).getFile() == idFile) {
                state = directory.get(i);
                break;
            }
        }
        return state;
    }

    private boolean space(int sizeData) {
        int size = 0;
        boolean result = false;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getPuntero() == 0) {
                size++;
            }
            if (size >= sizeData) {
                result = true;
                break;
            }
        }
        return result;
    }
}
