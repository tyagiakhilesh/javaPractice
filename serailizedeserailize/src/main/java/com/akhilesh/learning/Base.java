package com.akhilesh.learning;

import java.io.Serializable;

public class Base implements Serializable {

    private static final long serialVersionUID = 2451245245L;

    private final String base;

    public String getBase() {
        return base;
    }

    public Base(String base) {
        this.base = base;

    }
}
