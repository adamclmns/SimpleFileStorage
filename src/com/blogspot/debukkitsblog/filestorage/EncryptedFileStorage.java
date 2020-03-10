package com.blogspot.debukkitsblog.filestorage;


import com.blogspot.debukkitsblog.crypt.CryptedObject;
import com.blogspot.debukkitsblog.crypt.Crypter;

import java.io.IOException;

public class EncryptedFileStorage<K, V> extends FileStorage<K, CryptedObject> implements IFileStorage<K, CryptedObject> {
    private Crypter crypter;
    
    public EncryptedFileStorage(final String filepath, final boolean autosave) throws IllegalArgumentException, IOException {
        super(filepath, autosave);
        this.crypter = new Crypter<V>();
    }
    
    public EncryptedFileStorage(final String filepath) throws IOException, IllegalArgumentException {
        super(filepath);
    }
    
    public void store(K key, CryptedObject o) throws IOException {
        super.store(key, o);
    }
    
    public void store(K key, V o, String password) throws IOException {
        store(key, this.crypter.encrypt(o, password));
    }
    
    public <V> V get(K key, String password) throws Crypter.DecryptionFailedException {
        return (V) this.crypter.decrypt(super.get(key), password);
    }
}
