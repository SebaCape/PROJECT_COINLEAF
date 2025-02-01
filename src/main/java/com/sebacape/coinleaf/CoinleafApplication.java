package com.sebacape.coinleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.sebacape.coinleaf.model")
@EnableJpaRepositories(basePackages = "com.sebacape.coinleaf.repository")
public class CoinleafApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(CoinleafApplication.class, args);
    }
}
