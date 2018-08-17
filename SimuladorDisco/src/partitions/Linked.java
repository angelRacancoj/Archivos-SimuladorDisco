package partitions;

import Objects.Block;
import Objects.Directory;
import java.util.List;

/**
 *
 * @author teodoro
 */
public class Linked {
    private List<Directory> directory;
    private List<Block> blocks;

    public Linked(List<Directory> directory, List<Block> blocks) {
        this.directory = directory;
        this.blocks = blocks;
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
