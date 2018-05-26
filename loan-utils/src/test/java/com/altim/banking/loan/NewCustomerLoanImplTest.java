package com.altim.banking.loan;

import com.altim.banking.commodity.Gold;
import com.altim.banking.commodity.KARAT;
import com.altim.banking.service.GoldRateCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.altim.banking.loan.NewCustomerLoanImpl.NEW_CUSTOMER_BASE_TX_FEE;

public class NewCustomerLoanImplTest {

    @Test
    public void testEligibility() {
        GoldRateCalculator goldRateCalculator = new GoldRateCalculator();
        Loan loan = new NewCustomerLoanImpl(goldRateCalculator);
        Gold g = new Gold(KARAT.FOURTEEN, 10);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            loan.eligibility(1, CustomerType.OLD, g);
        });

        double e = loan.eligibility(1, CustomerType.NEW, g);
        Assertions.assertEquals(7500 - NEW_CUSTOMER_BASE_TX_FEE, e);
        int extraTxFee = 400;
        Gold g1 = new Gold(KARAT.TWENTYFOUR, 10);
        e = loan.eligibility(1, CustomerType.NEW, g1, extraTxFee);
        Assertions.assertEquals(goldRateCalculator.getPrice(g1) - NEW_CUSTOMER_BASE_TX_FEE - extraTxFee, e);
    }
}
