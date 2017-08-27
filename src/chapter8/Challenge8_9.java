package chapter8;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by asus on 8/27/17.
 * In-memory file system design.
 */

abstract class Entry{
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        created = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
    }

    public boolean delete(){
        if (parent == null) return false;
        return parent.deleteEntry(this);
    }

    public abstract int size();

    public String getFullPath(){
        if (parent == null) return name;
        return parent.getFullPath() + "/" + name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class File extends Entry{
    private String content;
    private int size;

    public File(Directory parent, String name, int s) {
        super(parent, name);
        size = s;
    }

    @Override
    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Directory extends Entry{
    protected List<Entry> contents;

    public Directory(Directory parent, String name) {
        super(parent, name);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e: contents)
            size += e.size();
        return size;
    }

    public int numberOfFiles(){
        int count = 0;
        for (Entry e : contents){
            if (e instanceof Directory){
                count++;
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            }
            else if (e instanceof File) count++;
        }
        return count;
    }

    public boolean deleteEntry(Entry entry){
        return contents.remove(entry);
    }

    public void addEntry(Entry entry){
        contents.add(entry);
    }

    public List<Entry> getContents() {
        return contents;
    }
}
public class Challenge8_9 {
}
