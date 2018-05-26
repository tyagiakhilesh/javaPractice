package com.altim.banking.loan;

import com.altim.banking.commodity.Gold;
import com.altim.banking.service.GoldRateCalculator;
import org.springframework.stereotype.Service;

@Service
public class NewCustomerLoanImpl extends Loan {
    public static final double NEW_CUSTOMER_BASE_TX_FEE = 500;
    private final GoldRateCalculator goldRateCalculator;

    public NewCustomerLoanImpl(GoldRateCalculator goldRateCalculator) {
        this.goldRateCalculator = goldRateCalculator;
    }

    /**
     * There is some contradiction in the QUESTION. Or at least appears to be.
     * THERE IS NO TRANSACTION FEE FOR OLD CUSTOMERS. FOR NEW CUSTOMERS, THE BASE FEE IS $500 AND IF THE BANK WANTS TO CHARGE MORE IT CAN SPECIFY THE VALUE.
     *
     * Above statement tells me that bank want to charge extra (above 500$) so that is why this variable argument.
     * @param customerId
     * @param customerType
     * @param gold
     * @param transactionFee
     * @return
     */
    @Override
    public double eligibility(int customerId, CustomerType customerType, Gold gold, int ... transactionFee) {
        this.validateInputs(customerType);
        return goldRateCalculator.getPrice(gold)
                - NEW_CUSTOMER_BASE_TX_FEE - ((transactionFee.length == 1 && transactionFee[0] > 0) ? transactionFee[0] : 0);
    }

    private void validateInputs(CustomerType customerType) {
        if (!customerType.equals(CustomerType.NEW)) {
            throw new IllegalArgumentException();
        }
    }
}
