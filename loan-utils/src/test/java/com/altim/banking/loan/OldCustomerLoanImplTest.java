package com.altim.banking.loan;

import com.altim.banking.commodity.Gold;
import com.altim.banking.commodity.KARAT;
import com.altim.banking.service.GoldRateCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OldCustomerLoanImplTest {
    @Test
    public void testEligibility() {
        GoldRateCalculator goldRateCalculator = new GoldRateCalculator();
        Loan loan = new OldCustomerLoanImpl(goldRateCalculator);
        Gold g = new Gold(KARAT.FOURTEEN, 10);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            loan.eligibility(1, CustomerType.NEW, g);
        });

        double e = loan.eligibility(1, CustomerType.OLD, g);
        Assertions.assertEquals(7500, e);
    }

    @Test
    public void testLiquidation() {
        GoldRateCalculator goldRateCalculator = new GoldRateCalculator();
        Loan loan = new OldCustomerLoanImpl(goldRateCalculator);
        double r = loan.liquidate(1, 400, 0);
        Assertions.assertEquals(400, r);
        r = loan.liquidate(1, 400, -10);
        Assertions.assertEquals(390, r);
        r = loan.liquidate(1, 400, -500);
        Assertions.assertEquals(-100, r);
    }
}
