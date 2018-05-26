package com.altim.banking.service;

import com.altim.banking.commodity.Gold;
import com.altim.banking.commodity.KARAT;
import org.springframework.stereotype.Service;

@Service
public class GoldRateCalculator {
    public final static double BASE_VALUE = 750;
    private final static double INCREMENT_PER_KARAT = 50;

    public double getPrice(final Gold gold) {
        return (BASE_VALUE + ((gold.getKarat().getKarat() - KARAT.FOURTEEN.getKarat())* INCREMENT_PER_KARAT)) * gold.getWeight();
    }
}
