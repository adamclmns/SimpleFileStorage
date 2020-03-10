package com.blogspot.debukkitsblog.filestorage;

import java.io.IOException;
import java.io.Serializable;

public class FileStorage<K, V> extends AbstractFileStorage<K, V> implements Serializable, IFileStorage<K, V> {
    
    private static final long serialVersionUID = 6410127608267365958L;
    
    
    public FileStorage(String filepath, boolean autosave)
            throws IllegalArgumentException, IOException {
        super(filepath, autosave);
    }
    
    public FileStorage(String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }
    
}
