package com.sebacape.coinleaf;

import io.github.cdimascio.dotenv.Dotenv;
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
        //Load and set sensitive variables from .env file
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("COINBASE_KEY", dotenv.get("COINBASE_KEY"));

        SpringApplication.run(CoinleafApplication.class, args);
    }
}
