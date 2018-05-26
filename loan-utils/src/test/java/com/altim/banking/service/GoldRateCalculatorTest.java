package com.altim.banking.service;

import com.altim.banking.commodity.Gold;
import com.altim.banking.commodity.KARAT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoldRateCalculatorTest {
    @Test
    public void testRate() {
        GoldRateCalculator goldRateCalculator = new GoldRateCalculator();
        Gold g = new Gold(KARAT.FOURTEEN, 10.1f);
        Assertions.assertEquals(Math.floor(GoldRateCalculator.BASE_VALUE * 10.1), Math.floor(goldRateCalculator.getPrice(g)));
        g = new Gold(KARAT.TWENTYFOUR, 10);
        Assertions.assertEquals(12500, (goldRateCalculator.getPrice(g)));
    }
}
