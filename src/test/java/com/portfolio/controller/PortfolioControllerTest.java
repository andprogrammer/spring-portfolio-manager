package com.portfolio.controller;

import com.portfolio.asset.core.Money;
import com.portfolio.asset.model.Bond;
import com.portfolio.asset.unit.Currency;
import com.portfolio.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PortfolioService portfolioService;

    @Test
    void shouldReturnPortfolioReport() throws Exception {
        // given
        portfolioService.addAsset(new Bond(
                "REST Bond",
                new Money(2_000, Currency.PLN),
                LocalDate.now().minusMonths(6),
                6.0,
                12
        ));

        // when / then
        mockMvc.perform(get("/api/assets/report")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].assetType").value("Bond"))
                .andExpect(jsonPath("$[0].name").value("REST Bond"))
                .andExpect(jsonPath("$[0].profit.amount").isNumber());
    }
}
