package partitions;

import Objects.Block;
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
    private List<Block> blocks;
    
    public Linked(int DiskSize) {
        this.DiskSize=DiskSize;
        this.directory = new ArrayList<>();
    }

    public List<Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<Directory> directory) {
        this.directory = directory;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
    
}
