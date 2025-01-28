package com.sebacape.coinleaf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * Class to allow temporary in-memory storage of Cryptocurrency portfolio with
 * list-based implementation. Allows all CRUD functionality within the console.
 * 
 * @author Sebastian Capellan
 */
public class PortfolioManager 
{
    private List<Crypto> portfolio;

    public PortfolioManager() 
    {
        this.portfolio = new ArrayList<>();
    }

    /*
     * Save a portfolio to a JSON file given a file path.
     * 
     * @param filePath path to portfolio file to be saved.
     */
    public void saveToFile(String filePath) 
    {
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), this.portfolio);
            System.out.println("Portfolio saved successfully!");
        } 
        catch (IOException e) 
        {
            System.err.println("Failed to save portfolio: " + e.getMessage());
        }
    }

    /*
     * Load a portfolio from a JSON file given a file path.
     * 
     * @param filePath path to portfolio file to be loaded.
     */
    public void loadFromFile(String filePath) 
    {
        ObjectMapper mapper = new ObjectMapper();
        try 
        {
            Crypto[] cryptos = mapper.readValue(new File(filePath), Crypto[].class);
            this.portfolio = new ArrayList<>(List.of(cryptos));
            System.out.println("Portfolio loaded successfully!");
        } 
        catch (IOException e) 
        {
            System.err.println("Failed to load portfolio: " + e.getMessage());
        }
    }

    /*
     * Add a Cryptocurrency to the portfolio.
     * 
     * @param crypto Cryptocurrency to be added to portfolio.
     */
    public void addCrypto(Crypto crypto) 
    {
        portfolio.add(crypto);
        System.out.println(crypto.getName() + " added to the portfolio.");
    }

    /*
     * Getter method for given portfolio object.
     * 
     * @return this PortfolioManager's portfolio.
     */
    public List<Crypto> getPortfolio() 
    {
        return portfolio;
    }

    /*
     * View all Cryptocurrencies in the portfolio.
     */
    public void viewPortfolio() 
    {
        if (portfolio.isEmpty()) 
        {
            System.out.println("\nYour portfolio is empty.");
            return;
        }
        System.out.println("\nYour Portfolio:");
        for (Crypto crypto : portfolio) 
        {
            System.out.println(crypto);
        }
    }

    /*
     * Update a Cryptocurrency's quantity.
     * Do nothing if Cryptocurrency not found in portfolio.
     * 
     * @param name Cryptocurrency to be updated
     * @param newQuantity new Cryptocurrency quantity after update
     */
    public void updateCrypto(String name, double newQuantity) 
    {
        for (Crypto crypto : portfolio) 
        {
            if (crypto.getName().equalsIgnoreCase(name)) 
            {
                crypto.setQuantity(newQuantity);
                System.out.println(name + " updated with new quantity: " + newQuantity);
                return;
            }
        }
        System.out.println("\nCryptocurrency " + name + " not found in the portfolio.");
    }

    /*
     * Remove a Cryptocurrency from the portfolio.
     * 
     * @param name This Cryptocurrency will be removed.
     */
    public void removeCrypto(String name) 
    {
        portfolio.removeIf(crypto -> crypto.getName().equalsIgnoreCase(name));
        System.out.println("\n" + name + " removed from the portfolio.");
    }
}
