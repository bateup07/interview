package com.msm.interview.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.msm.interview.util.Contant.*;

/**
 * @author matthewbateup
 * @date 11/11/2020
 */

/** This {@BitcoinExchangeService} is a Service class */
public class BitcoinExchangeService {

    /**
     * Main method to trigger this class
     */
    public void printPricing() {
        printBothPricing();
    }
    /**
     *
     */
    private void printBothPricing() {
        Map<String,Integer> apiDetails = new HashMap<>();
        apiDetails.put("https://api.exmo.com/v1/ticker", 1);
        apiDetails.put("https://blockchain.info/ticker", 2);

        apiDetails.forEach((k,v)->{
            callURL(k,v);
        });
    }
    /**
     * Scrap JSON via GSON
     * @param k
     * @param v
     */
    private void callURL(String k, Integer v) {
        try
        {
            URL url = new URL(k);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            //int httpStatusCode = conn.getResponseCode();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) conn.getContent()));

            JsonObject rootObject = root.getAsJsonObject();
            if (v == 1) {
                JsonObject childObject = rootObject.getAsJsonObject(USDBTC_SIGN); // get place object
                Double usdSellPrice = childObject.get(USDBTC_SELL).getAsDouble();
                System.out.println("API locator :- " + url);
                System.out.println(USD_SIGN + " Selling Price :- " + usdSellPrice);
                conn.disconnect();
            } else {
                JsonObject childObject = rootObject.getAsJsonObject(USD_SIGN); // get place object
                Double usdBtcSellPrice = childObject.get(USD_SELL).getAsDouble();
                System.out.println("API locator :- " + url);
                System.out.println(USDBTC_SIGN + " Selling Price :- " + usdBtcSellPrice);
                conn.disconnect();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}