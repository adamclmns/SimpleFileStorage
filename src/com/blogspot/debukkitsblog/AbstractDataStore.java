package com.blogspot.debukkitsblog;


import com.blogspot.debukkitsblog.filestorage.FileStorage;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")// TODO: Figure out how to fix these for real.
public abstract class AbstractDataStore<K, V extends AbstractStoredObject> {
    protected static final String HOME_DIR = System.getProperty("user.home");
    
    protected static final String UFU_HOME = ".ufu";

    
    protected final Path storeFilePath;
    
    private final FileStorage store;
    
    protected AbstractDataStore() throws IOException {
        this.storeFilePath = getDataStoreFilePath();
        this.store = new FileStorage<K, V>(storeFilePath.toString());
    }
    
    public void save(V object) throws IOException {
        if (object == null) {
            return;
        }
        this.store.store(object.getId().toString(), object);
    }
    
    public V findById(K id) {
        return (V) this.store.get(id.toString());
    }
    
    public List<V> getAll() {
        return (List<V>) this.store.getAll().values().stream().collect(Collectors.toList());
    }
    
    protected Path getDataStoreFilePath() {
        Path thePath = Paths.get(HOME_DIR, UFU_HOME);
        if (!thePath.toFile().exists()) {
            thePath.toFile().mkdirs();
        }
        return Paths.get(HOME_DIR, UFU_HOME, getStoreName());
    }
    
    protected abstract String getStoreName();
}
