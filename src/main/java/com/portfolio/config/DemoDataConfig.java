package com.portfolio.config;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.model.*;
import com.portfolio.asset.unit.CryptoCurrency;
import com.portfolio.asset.unit.Currency;
import com.portfolio.service.PortfolioService;
import com.portfolio.asset.unit.Metal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Profile("!test")
@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner initDemoPortfolio(PortfolioService service) {
        return args -> {
            service.addAsset(new Bond(
                    "Obligacja 3-letnie TOS",
                    new Money(10_000, Currency.PLN),
                    LocalDate.of(2025, 2, 5),
                    5.75,
                    36
            ));

            service.addAsset(new Cash(
                    new Money(800, Currency.PLN),
                    LocalDate.of(2025, 2, 5)
            ));

            service.addAsset(new Crypto(
                    CryptoCurrency.BTC,
                    Currency.EUR,
                    LocalDate.of(2024, 3, 2),
                    0.3,
                    39_000
            ));

            service.addAsset(new Deposit(
                    "Lokata Mobilna",
                    new Money(12_000, Currency.PLN),
                    LocalDate.of(2025, 3, 6),
                    4.5,
                    6
            ));

            service.addAsset(new Fund(
                    "PKO Technologii i Innowacji Globalny",
                    LocalDate.of(2025, 3, 6),
                    Currency.PLN,
                    85,
                    250
            ));

            service.addAsset(new com.portfolio.asset.model.Metal(
                    Metal.GOLD,
                    LocalDate.of(2024, 3, 8),
                    Currency.USD,
                    2,
                    31.1,
                    3_500
            ));

            service.addAsset(new SavingsAccount(
                    "Oko Bonus",
                    "ING",
                    new Money(15_000, Currency.PLN),
                    LocalDate.of(2025, 2, 7),
                    5.2
            ));

            service.addAsset(new Stock(
                    "PKN Orlen",
                    Currency.PLN,
                    LocalDate.of(2025, 2, 7),
                    4,
                    65.3
            ));
        };
    }
}
