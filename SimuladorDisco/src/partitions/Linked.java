package partitions;

import Objects.Block;
import Objects.BlockLinked;
import Objects.Directory;
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

    //como parametro el tamano de la particion
    public Linked(int DiskSize) {
        this.DiskSize = DiskSize * 1024 * 1024;
        this.directory = new ArrayList<>();
        this.blocks = new ArrayList<>();
        createBlocks(15);
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
                blocks.get(index).setPuntero(insertFile(index(), size-1));
                return index;
                //blocke Vacio
            } else {
                return insertFile(index(), size);
            }
        }
    }

    public void insert(int size,int idFile) {
        boolean repeat = true;
        int position = index();
        if (space(size)) {
            directory.add(new Directory(idFile, position));
            while (repeat) {
                if (isEmpty(position)) {
                    blocks.get(position).setData(null);
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

    public void getData() {

    }

    public boolean space(int sizeData) {
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
