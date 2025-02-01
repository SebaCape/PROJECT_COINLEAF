package com.sebacape.coinleaf.model;

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

    private String name;
    private double quantity;
    private double price;

    /*
     * Empty default constructor for Cryptocurrency object. Necessary for JPA.
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
        price = p;
    }

    /* 
     * Returns the ID of the Crypto.
     * 
     * @return the ID of the Crypto.
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
        return price;
    }

    /*
     * ToString override method for Crypto object.
     * 
     * @return Crypto in string format.
     */
    @Override
    public String toString()
    {
        return ("Name: " + name + "\nQuantity: " + quantity + "\nValue Per Unit At Purchase: " + price+ "\n");
    }
}