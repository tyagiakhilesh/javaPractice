package com.altim.banking.loan;

public enum CustomerType {
    OLD(0),NEW(1);

    private final int type;

    private CustomerType(int i) {
        this.type = i;
    }

    public int getType() {
        return type;
    }
}
