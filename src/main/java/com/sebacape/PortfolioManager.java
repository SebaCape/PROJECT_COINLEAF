package com.sebacape;

import java.util.ArrayList;
import java.util.List;
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
