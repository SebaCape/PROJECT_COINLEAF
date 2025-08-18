package com.sebacape.coinleaf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sebacape.coinleaf.service.CoinbaseService.CoinbaseResponse;
/**
 * Coinbase service class meant to handle API Requests and data retrieval from Coinbase API. 
 * 
 * @author Sebastian Capellan
 */
@Service
public class CoinbaseService 
{
    private final RestTemplate restTemplate = new RestTemplate();

    /*
     * Returns a double floating-point value corresponding to a requested cryptocurrency's price from Coinbase API endpoint.
     * 
     * @returns double Price of retrieved cryptocurrency in USD.
     */
    public double getCurrentPrice(String symbol)
    {
        String url = "https://api.coinbase.com/v2/prices/" + symbol.toUpperCase() + "-USD/spot";
        CoinbaseResponse response = restTemplate.getForObject(url, CoinbaseResponse.class);

        if (response == null || response.getData() == null)
            throw new RuntimeException("Failed to fetch price for " + symbol);

        return Double.parseDouble(response.getData().getAmount());
    }


    /*
     * CoinbaseResponse class to abstract data pulled from API as one object.
     */
    public static class CoinbaseResponse
    {
        private Data data;

        /*
        * Returns Data of our retrieved cryptocurrency.
        * 
        * @returns Data of cryptocurrency.
        */
        public Data getData() 
        { 
            return data; 
        }

        /*
        * Sets Data of our retrieved cryptocurrency.
        * 
        * @param data Data of cryptocurrency.
        */
        public void setData(Data data) 
        { 
            this.data = data; 
        }
    }

    /*
     * Data class to abstract important cryptocurrency metadata as object attributes.
     */
    public static class Data
    {
        private String base;
        private String currency;
        private String amount;

        /*
        * Returns a String holding the quantity of our retrieved cryptocurrency.
        * 
        * @returns String Amount of cryptocurrency.
        */
        public String getAmount() 
        { 
            return amount; 
        }

        /*
        * Sets a String holding the quantity of our retrieved cryptocurrency.
        * 
        * @param amount Amount of cryptocurrency.
        */
        public void setAmount(String amount) 
        { 
            this.amount = amount; 
        }
    }
}
