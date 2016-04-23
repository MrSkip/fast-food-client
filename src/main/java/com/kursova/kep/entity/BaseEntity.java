package com.kursova.kep.entity;

import java.io.Serializable;

/**
 * by Mr Skip on 24.03.2016.
 */

public class BaseEntity{

    Long id;

    public Long getId() {
        if (id == null)
            return null;
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
