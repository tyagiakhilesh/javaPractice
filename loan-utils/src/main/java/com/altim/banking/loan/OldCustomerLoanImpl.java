package com.altim.banking.loan;

import com.altim.banking.commodity.Gold;
import com.altim.banking.service.GoldRateCalculator;
import org.springframework.stereotype.Service;

@Service
public class OldCustomerLoanImpl extends Loan {

    private final GoldRateCalculator goldRateCalculator;

    public OldCustomerLoanImpl(final GoldRateCalculator goldRateCalculator) {
        this.goldRateCalculator = goldRateCalculator;
    }

    @Override
    public double eligibility(int customerId, CustomerType customerType, Gold gold, int ... transactionFee) {
        this.validateInputs(customerType);
        return goldRateCalculator.getPrice(gold);
    }

    private void validateInputs(CustomerType customerType) {
        if (!customerType.equals(CustomerType.OLD)) {
            throw new IllegalArgumentException();
        }
    }
}
