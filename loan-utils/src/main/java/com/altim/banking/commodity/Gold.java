package com.altim.banking.commodity;

public class Gold {
    private final KARAT karat;
    private final float weight;

    public Gold(KARAT karat, float weight) {
        this.karat = karat;
        this.weight = weight;
    }

    public KARAT getKarat() {
        return karat;
    }

    public float getWeight() {
        return weight;
    }
}
