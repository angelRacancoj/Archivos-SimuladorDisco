package partitions;

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
    private int sizeBlocks;
    private List<Directory> directory;
    private List<BlockLinked> blocks;

    //como parametro el tamano de la particion en MB
    /**
     * When the partition is created this needs the partition size in Mb and the
     * size block must be in Kb
     *
     * @param DiskSize (Mb)
     * @param sizeBlocks (Kb)
     */
    public Linked(int DiskSize, int sizeBlocks) {
        //conversion de MB a Kb
        this.DiskSize = DiskSize * 1024;
        this.directory = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.sizeBlocks = sizeBlocks;
        //crear los bloques
        createBlocks(this.DiskSize, sizeBlocks);
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }

    public void formatDisk() {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.set(i, new BlockLinked(i, null, -3));
        }
    }

    public List<BlockLinked> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BlockLinked> blocks) {
        this.blocks = blocks;
    }

    private void createBlocks(int size, int sizeBlocks) {
        int quantity = size / sizeBlocks;
        for (int i = 0; i < quantity; i++) {
            this.blocks.add(new BlockLinked(i, null, -3));
        }
    }

    //metodo recursivo para insertar archvo
    private int insertFile(int index, int size) {
        if (size == 1) {
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
     * This method need the file to add into de partition
     *
     * @param file
     */
    public void insert(File file) {
        if (getFile(Integer.parseInt(file.getName())) == null) {
            //calcular la cantidad de bloques que usara el archivo
            int size = (int) ((file.length() * 0.001) / blocks.size());
            if (size == 0) {
                size++;
            }
            boolean repeat = true;
            int position = index();
            //Si existe espacio para insertar archivo
            if (space(size)) {
                //agregamos el archivo a guardar en el directorio de archivos
                while (repeat) {
                    if (isEmpty(position)) {
                        //para no modificar el master no cambie el tipo de atributo para date pero ahi hay que mandar el path
                        directory.add(new Directory(Integer.parseInt(file.getName()), position));
                        if (size == 1) {
                            blocks.get(position).setData(file);
                            blocks.get(position).setPuntero(-1);
                            break;
                        } else {
                            blocks.get(position).setData(file);
                            blocks.get(position).setPuntero(-2);
                            blocks.get(position).setPuntero(insertFile(index(), size - 1));
                            break;
                        }
                    } else {
                        position = index();
                    }
                }
            } else {
                //NO hay espacio
            }
        } else {
            //Ya existe un archivo con ese nombre
        }
    }

    private int index() {
        return (int) (Math.random() * blocks.size());
    }

    private boolean isEmpty(int id) {
        boolean result = false;
        if (blocks.get(id).getPuntero() == -3) {
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

    /**
     * Return the file that had been saved at this partition, need the position
     * or code of the file
     *
     * @param id
     * @return
     */
    public File getFile(int id) {
        Directory file = dataExist(id);
        if (file != null) {
            return blocks.get(file.getPosition()).getData();
        } else {
            //file no encontrado
            return null;
        }
    }

    private void resetBlock(BlockLinked block) {
        blocks.set(block.getId(), new BlockLinked(block.getId(), null, -3));
    }

    private void delete(int antes, int puntero) {
        if (puntero != -1) {
            delete(puntero, blocks.get(puntero).getPuntero());
            resetBlock(blocks.get(puntero));
        } else {
            resetBlock(blocks.get(antes));
        }
    }

    /**
     * To delete a file it needs the code or position of the file
     *
     * @param id
     */
    public void deleteFile(int id) {
        Directory file = dataExist(id);
        if (file != null) {
            delete(file.getPosition(), file.getPosition());
            directory.remove(file);
        } else {
            //no existe el archivo
        }
    }

    /**
     * This method require for the file that is going to be replace by itself
     * modify version
     *
     * @param file
     */
    public void modifyFile(File file) {
        if (dataExist(Integer.parseInt(file.getName())) != null) {
            deleteFile(Integer.parseInt(file.getName()));
            insert(file);
        } else {
            //no existe el archivo
        }
    }

    /**
     * This method return the number of blocks that the file required to be
     * stored at the partition
     *
     * @param idFile
     * @return
     */
    public int getSizeData(int idFile) {
        int val;
        if (dataExist(idFile) != null) {
            int index = dataExist(idFile).getPosition();
            if (blocks.get(index).getPuntero() != -1) {
                return 1 + sizeData(blocks.get(blocks.get(index).getPuntero()));
            } else {
                return 1;
            }
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
            if (blocks.get(i).getPuntero() == -3) {
                size++;
            }
            if (size >= sizeData) {
                result = true;
                break;
            }
        }
        return result;
    }

    public String getReporte1() {
        String contenido = "Archivo,Bloque inicial \n";
        for (int i = 0; i < directory.size(); i++) {
            contenido += directory.get(i).getFile() + "," + directory.get(i).getPosition() + "\n";
        }
        return contenido;
    }

    //se ingresa la cantidad de bloques a reportar
    public String getReporte2(int cantidad) {
        String contenido = "id Bloque,apuntador \n";
        if (cantidad <= blocks.size()) {
            for (int i = 0; i < cantidad; i++) {
                contenido += blocks.get(i).getId() + "," + blocks.get(i).getPuntero() + "\n";
            }
        } else {
            for (int i = 0; i < blocks.size(); i++) {
                contenido += blocks.get(i).getId() + "," + blocks.get(i).getPuntero() + "\n";
            }
        }

        return contenido;
    }
}
