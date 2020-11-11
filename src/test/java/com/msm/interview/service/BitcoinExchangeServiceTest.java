package com.msm.interview.service;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class BitcoinExchangeServiceTest {

    private BitcoinExchangeService service;

    @Before
    public void setUp() {initMocks (this);}

    @Test
    public void test_BTC_Json_Formatting(){

        //given
        String btcJson = retrieveBtcJson();
        //when
        //then
    }

    @Test
    public void test_USD_Json_Formatting() {
        //given
        String usdJson = retrieveUsdJson();

        //when

        //then
    }

    @Test
    public void validate_APIDetails_HashMap() {
        //given
        //when
        //then
    }

    @Test
    public void mapping_USD_Price() {
        //given
        //when
        //then
    }

    @Test
    public void mapping_BTC_Price() {
        //given
        //when
        //then
    }

    /**
     * Pick up JSON file from Resource folder
     * @return
     */
    private String retrieveBtcJson() {
        return null;
    }

    /**
     * Pick up JSON file from Resource folder
     * @return
     */
    private String retrieveUsdJson() {
        return null;
    }
}