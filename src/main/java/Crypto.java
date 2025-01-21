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
     * Constructor for Cryptocurrency object
     * 
     * @param n The name of the Cryptocurrency
     * @param q The quantity of the Cryptocurrency
     * @param p The price at which the Cryptocurrency was bought
     */
    public Crypto(String n, double q, double p)
    {
        name = n;
        quantity = q;
        priceAtPurchase = p;
    }

    /* 
     * Returns the name of the Cryptocurrency.
     * 
     * @return the name of the Cryptocurrency.
     */
    public String getName()
    {
        return name;
    }

    /*
     * Returns the quantity of the Cryptocurrency.
     * 
     * @return the quantity of the Cryptocurrency.
     */
    public double getQuantity()
    {
        return quantity;
    }

    /*
     * Sets the quantity of the Cryptocurrency.
     * 
     * @param q new quantity of Cryptocurrency to be set.
     */
    public void setQuantity(double q)
    {
        quantity = q;
    }

    /*
     * Returns the price at which the Cryptocurrency was purchased.
     * 
     * @return the price at which the Crypto currency was purchased.
     */
    public double getPriceAtPurchase()
    {
        return priceAtPurchase;
    }
}