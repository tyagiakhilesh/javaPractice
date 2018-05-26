package com.altim.banking.loan;

import com.altim.banking.commodity.Gold;

public abstract class Loan {
    public abstract double eligibility(int customerId, CustomerType customerType, Gold gold, int ... transactionFee);

    protected double liquidate(int customerId, double amountPayable, double liquidationAmount) {
        if (liquidationAmount > 0) {
            return amountPayable;
        } else {
            return amountPayable + liquidationAmount;
        }
    }
}
