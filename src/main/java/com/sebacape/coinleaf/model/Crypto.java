package com.sebacape.coinleaf.model;

import org.hibernate.type.descriptor.jdbc.DecimalJdbcType;

import jakarta.persistence.*;
/**
 * Cryptocurrency object class with relevant fields and methods.
 * Implemented for console based portfolio prototype. 
 * 
 * @author Sebastian Capellan
 */

@Entity
@Table (name = "crypto")
public class Crypto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private double quantity;
    private double initPrice;
    private double curPrice;

    /*
     * Empty default constructor for Cryptocurrency object. Necessary for JPA.
     */
    public Crypto() {}

    /*
     * Constructor for Crypto object.
     * 
     * @param s The sympol of the Crypto
     * @param q The quantity of the Crypto
     * @param p The price at which the Crypto was bought
     */
    public Crypto(String s, double q, double p)
    {
        symbol = s;
        quantity = q;
        initPrice = p;
        curPrice = p;
    }

    /* 
     * Returns the ID of the Crypto.
     * 
     * @return Long the ID of the Crypto.
     */
    public Long getId() 
    {
        return id;
    }

    /* 
     * Sets the ID of the Crypto.
     * 
     * @param id the new ID of the Crypto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /* 
     * Returns the name of the Crypto.
     * 
     * @return String the name of the Crypto.
     */
    public String getSymbol()
    {
        return symbol;
    }

    /*
     * Returns the quantity of the Crypto.
     * 
     * @return double the quantity of the Crypto.
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
     * @return double the price at which the Crypto was purchased.
     */
    public double getPriceAtPurchase()
    {
        return initPrice;
    }

    /*
     * Sets the price at which the Crypto was purchased.
     * 
     * @param p the price at which the Crypto was purchased.
     */
    public void setPriceAtPurchase(double p)
    {
        initPrice = p;
    }

    /*
     * Returns the current price of the Crypto.
     * 
     * @return double the current price of the Crypto.
     */
    public double getCurrentPrice()
    {
        return curPrice;
    }

    /*
     * Sets the current price of the Crypto.
     * 
     * @param p the current price of the Crypto.
     */
    public void setCurrentPrice(double p)
    {
        curPrice = p;
    }

    /*
     * ToString override method for Crypto object.
     * 
     * @return String Crypto in string format.
     */
    @Override
    public String toString()
    {
        return ("Name: " + symbol + "\nQuantity: " + quantity + "\nValue Per Unit At Purchase: " + initPrice+ "\n");
    }
}