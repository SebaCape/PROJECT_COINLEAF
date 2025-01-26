package com.sebacape;

/**
 * Cryptocurrency object class with relevant fields and methods.
 * Implemented for console based portfolio prototype. 
 * 
 * @author Sebastian Capellan
 */
public class Crypto
{
    private String name;
    private double quantity;
    private double priceAtPurchase;

    /*
     * Empty default constructor for Cryptocurrency object. Necessary for Jackson.
     */
    public Crypto() {}

    /*
     * Constructor for Crypto object
     * 
     * @param n The name of the Crypto
     * @param q The quantity of the Crypto
     * @param p The price at which the Crypto was bought
     */
    public Crypto(String n, double q, double p)
    {
        name = n;
        quantity = q;
        priceAtPurchase = p;
    }

    /* 
     * Returns the name of the Crypto.
     * 
     * @return the name of the Crypto.
     */
    public String getName()
    {
        return name;
    }

    /*
     * Returns the quantity of the Crypto.
     * 
     * @return the quantity of the Crypto.
     */
    public double getQuantity()
    {
        return quantity;
    }

    /*
     * Sets the quantity of the Crypto.
     * 
     * @param q new quantity of Crypto to be set.
     */
    public void setQuantity(double q)
    {
        quantity = q;
    }

    /*
     * Returns the price at which the Crypto was purchased.
     * 
     * @return the price at which the Crypto was purchased.
     */
    public double getPriceAtPurchase()
    {
        return priceAtPurchase;
    }

    /*
     * ToString override method for Crypto object.
     * 
     * @return Crypto in string format.
     */
    @Override
    public String toString()
    {
        return ("Name: " + name + "\nQuantity: " + quantity + "\nValue Per Unit At Purchase: " + priceAtPurchase + "\n");
    }
}