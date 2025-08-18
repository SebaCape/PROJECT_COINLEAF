package com.sebacape.coinleaf.repository;

import java.util.List;
import com.sebacape.coinleaf.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Cryptocurrency repository class with query methods
 * for database access via Spring data JPA. Replaces 
 * in memory PortfolioManager.
 * 
 * @author Sebastian Capellan
 */
public interface CryptoRepository extends JpaRepository<Crypto, Long> 
{
    //Find Cryptos by symbol
    List<Crypto> findBySymbol(String symbol);
    
    //Find Cryptos above a price threshold
    List<Crypto> findByCurPriceGreaterThan(double curPrice);
    
    //Find Cryptos below a price threshold
    List<Crypto> findByCurPriceLessThan(double curPrice);
    
    //Find Cryptos with quantity greater than X
    List<Crypto> findByQuantityGreaterThan(double quantity);
    
    //Check if a Crypto exists
    boolean existsBySymbol(String symbol);
    
    //Delete a Crypto by symbol
    void deleteBySymbol(String symbol);
}
