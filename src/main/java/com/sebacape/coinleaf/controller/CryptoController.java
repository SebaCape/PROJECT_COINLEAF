package com.sebacape.coinleaf.controller;

import com.sebacape.coinleaf.model.Crypto;
import com.sebacape.coinleaf.service.CoinbaseService;
import com.sebacape.coinleaf.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * CryptoController class with the purpose of exposing
 * REST API endpoints for operation access.
 * 
 * @author Sebastian Capellan
 */
@RestController
@RequestMapping("/api/cryptos")
public class CryptoController 
{
    private final CryptoService cryptoService;
    private final CoinbaseService coinbaseService;

    //Create a new CryptoService for controller
    public CryptoController(CryptoService cryptoService, CoinbaseService coinbaseService) 
    {
        this.cryptoService = cryptoService;
        this.coinbaseService = coinbaseService;
    }

    
    //Get every Crypto from the service
    @GetMapping
    public List<Crypto> getAllCryptos() 
    {
        return cryptoService.getAllCryptos();
    }

    //Add a Crypto to the service
    @PostMapping
    public Crypto addCrypto(@RequestBody Crypto crypto) 
    {
        return cryptoService.saveCrypto(crypto);
    }

    //Retrieve the live price of a Crypto from Coinbase
    @GetMapping("/cryptos/{symbol}/price")
    public double getLivePrice(@PathVariable String symbol) 
    {
        return coinbaseService.getCurrentPrice(symbol);
    }

    //Delete a Crypto from the service by ID
    @DeleteMapping("/{id}")
    public void deleteCrypto(@PathVariable Long id) 
    {
        cryptoService.deleteCrypto(id);
    }
}
