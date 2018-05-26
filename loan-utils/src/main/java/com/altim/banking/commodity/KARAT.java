package com.altim.banking.commodity;

public enum KARAT {
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20),
    TWENTYONE(21),
    TWENTYTWO(22),
    TWENTYTHREE(23),
    TWENTYFOUR(24);

    private final int karat;

    KARAT(int i) {
        this.karat = i;
    }

    public int getKarat() {
        return karat;
    }
}
