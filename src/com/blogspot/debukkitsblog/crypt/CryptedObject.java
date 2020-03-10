package com.blogspot.debukkitsblog.crypt;

import java.io.Serializable;

public class CryptedObject implements Serializable {
    
    private static final long serialVersionUID = -5575861158027167628L;
    
    private final byte[] bytes;
    
    public CryptedObject(byte[] bytes) {
        this.bytes = bytes;
    }
    
    public byte[] getBytes() {
        return bytes;
    }
    
}
