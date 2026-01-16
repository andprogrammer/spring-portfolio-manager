package com.portfolio.service;

import com.portfolio.asset.core.Asset;
import com.portfolio.asset.core.Money;
import com.portfolio.asset.model.Bond;
import com.portfolio.asset.model.Cash;
import com.portfolio.asset.unit.Currency;
import com.portfolio.manager.dto.PortfolioLine;
import com.portfolio.repository.PortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PortfolioServiceTest {

    private PortfolioRepository repository;
    private PortfolioService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(PortfolioRepository.class);
        service = new PortfolioService(repository);
    }

    @Test
    void shouldReturnPortfolioReportWithProfitForValuableAsset() {
        // given
        Bond bond = new Bond(
                "Test Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.now().minusYears(1),
                10.0,
                12
        );

        when(repository.findAll()).thenReturn(List.of(bond));

        // when
        List<PortfolioLine> report = service.getPortfolioReport();

        // then
        assertThat(report).hasSize(1);

        PortfolioLine line = report.getFirst();
        assertThat(line.assetType()).isEqualTo("Bond");
        assertThat(line.name()).isEqualTo("Test Bond");
        assertThat(line.profit()).isNotNull();
        assertThat(line.profit().amount()).isGreaterThan(0);
    }

    @Test
    void shouldReturnPortfolioReportWithNullProfitForNonValuableAsset() {
        // given
        Asset cash = new Cash(
                new Money(500, Currency.USD),
                LocalDate.now()
        );

        when(repository.findAll()).thenReturn(List.of(cash));

        // when
        List<PortfolioLine> report = service.getPortfolioReport();

        // then
        assertThat(report).hasSize(1);
        assertThat(report.getFirst().profit()).isNull();
    }
}
