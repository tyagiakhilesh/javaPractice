package com.akhilesh.learning;

import java.io.Serializable;

public final class Embedded extends Base implements Serializable {
    private static final long serialVersionUID = 1341341341L;

    private final String embedded;

    public Embedded(String embedded, String base) {
        super(base);
        this.embedded = embedded;
    }

    public String getEmbedded() {
        return embedded;
    }
}
