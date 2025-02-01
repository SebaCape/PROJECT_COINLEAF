package com.sebacape.coinleaf.controller;

import com.sebacape.coinleaf.model.Crypto;
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
    private final CryptoService service;

    //Create a new CryptoService for controller
    public CryptoController(CryptoService service) 
    {
        this.service = service;
    }

    //Get every Crypto from the service
    @GetMapping
    public List<Crypto> getAllCryptos() 
    {
        return service.getAllCryptos();
    }

    //Add a Crypto to the service
    @PostMapping
    public Crypto addCrypto(@RequestBody Crypto crypto) 
    {
        return service.saveCrypto(crypto);
    }

    //Delete a Crypto from the service by ID
    @DeleteMapping("/{id}")
    public void deleteCrypto(@PathVariable Long id) 
    {
        service.deleteCrypto(id);
    }
}
