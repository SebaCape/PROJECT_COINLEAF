package com.sebacape.coinleaf.repository;

import java.util.List;
import com.sebacape.coinleaf.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Cryptocurrency repository class with query methods
 * for database access with Spring data JPA. Replaces 
 * PortfolioManager.
 * 
 * @author Sebastian Capellan
 */
public interface CryptoRepository extends JpaRepository<Crypto, Long> 
{
    //Find Cryptos by name
    List<Crypto> findByName(String name);
    
    //Find Cryptos above a price threshold
    List<Crypto> findByPriceGreaterThan(double price);
    
    //Find Cryptos below a price threshold
    List<Crypto> findByPriceLessThan(double price);
    
    //Find Cryptos with quantity greater than X
    List<Crypto> findByQuantityGreaterThan(double quantity);
    
    //Check if a Crypto exists
    boolean existsByName(String name);
    
    //Delete a Crypto by name
    void deleteByName(String name);
}
