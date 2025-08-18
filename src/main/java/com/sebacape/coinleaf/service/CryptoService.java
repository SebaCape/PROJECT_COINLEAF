package com.sebacape.coinleaf.service;

import com.sebacape.coinleaf.model.Crypto;
import com.sebacape.coinleaf.repository.CryptoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Cryptocurrency service class meant to handle business logic. 
 * 
 * @author Sebastian Capellan
 */
@Service
public class CryptoService 
{
    private final CryptoRepository repository;
    private final CoinbaseService coinbaseService;

    /*
     * Constructor for CryptoService class.
     * 
     * @param repository Repository to be initialized for services.
     */
    public CryptoService(CryptoRepository repository, CoinbaseService coinbaseService) 
    {
        this.repository = repository;
        this.coinbaseService = coinbaseService;
    }

    /*
     * Returns a list of all Cryptos in repository.
     * 
     * @return List of all Cryptos.
     */
    public List<Crypto> getAllCryptos() 
    {
        return repository.findAll();
    }

    /*
     * Saves a new Crypto to the current repository.
     * 
     * @param crypto Crypto to be saved to repository.
     */
    public Crypto saveCrypto(Crypto crypto) 
    {
        double currentPrice = coinbaseService.getCurrentPrice(crypto.getSymbol());
        crypto.setCurrentPrice(currentPrice); 
        return repository.save(crypto);
    }

    /*
     * Deletes a Crypto from repository based on id.
     * 
     * @param id Long input value for Crypto id to be searched and removed
     */
    public void deleteCrypto(Long id) 
    {
        repository.deleteById(id);
    }
}
