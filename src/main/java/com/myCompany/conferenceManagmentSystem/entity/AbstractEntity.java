package com.myCompany.conferenceManagmentSystem.entity;

import com.myCompany.conferenceManagmentSystem.model.AbstractModel;

import java.io.Serializable;
import java.util.Objects;

public class AbstractEntity<PK> extends AbstractModel implements Serializable {
    private PK id;

    public PK getId() {
        return id;
    }
    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 17 + ((id == null) ? 0 : id.hashCode());
        return hash;
    }
}
