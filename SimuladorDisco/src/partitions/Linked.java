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
    public Linked(int DiskSize) {
        //conversion de MB a Bytes
        this.DiskSize = DiskSize*1024*1024;
        this.directory = new ArrayList<>();
        this.blocks = new ArrayList<>();
        //crear los bloques
        createBlocks(DiskSize);
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }

    public List<BlockLinked> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockLinked> blocks) {
        this.blocks = blocks;
    }

    private void createBlocks(int size) {
        int quantity = size / 5;
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

    public void insert(File file) {
        //calcular la cantidad de bloques que usara el archivo
        int size=(int) (file.getTotalSpace()/4);
        boolean repeat = true;
        int position = index();
        if (space(size)) {
            //agregamos el archivo a guardar en el directorio de archivos
            directory.add(new Directory(Integer.parseInt(file.getName()),position));
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
    private int sizeData(BlockLinked puntero){
        if(puntero.getPuntero()!=-1){
            return 1+sizeData(blocks.get(puntero.getPuntero()));
        }else{
            return 1;
        }
    }

    public int getSizeData(int idFile) {
        int val;
        if (dataExist(idFile)!=null) {
            int index=dataExist(idFile).getPosition();
            return 1+sizeData(blocks.get(blocks.get(index).getPuntero())); 
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
