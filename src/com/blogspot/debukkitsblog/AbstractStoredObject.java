package com.blogspot.debukkitsblog;

import java.io.Serializable;
import java.util.UUID;

// TODO Remove path and push up to extended versions
public class AbstractStoredObject<T> implements Serializable {
    protected T id;
    
    
    public AbstractStoredObject(T id) {
        this.id = id;
    }
    
    public AbstractStoredObject() {
    }
    
    public T getId() {
        return this.id;
    }
    
    
    public void setId(T id) {
        this.id = id;
    }
    
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AbstractStoredObject)) return false;
        final AbstractStoredObject<?> other = (AbstractStoredObject<?>) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        return this$id == null ? other$id == null : this$id.equals(other$id);
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof AbstractStoredObject;
    }
    
    public static abstract class AbstractStoredObjectBuilder<B> {
        protected UUID id;
        protected String filePath;
        
        public AbstractStoredObjectBuilder() {
        }
        
        public AbstractStoredObjectBuilder id(UUID id) {
            this.id = id;
            return this;
        }
        
        public AbstractStoredObjectBuilder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }
        
        public abstract B build();
    }
}
