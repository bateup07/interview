package com.msm.interview;

import com.msm.interview.service.BitcoinExchangeService;

/**
 * @author matthewbateup
 * @date 11/11/2020
 */

public class App {
    public static void main(String[] args) {
        BitcoinExchangeService exchangeService = new BitcoinExchangeService();
        exchangeService.printPricing();
    }
}