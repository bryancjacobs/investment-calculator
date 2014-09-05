package invest.service;

import invest.model.Fund;
import invest.model.FundType;
import invest.model.Quote;
import invest.repo.FundRepo;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by bryan.jacobs
 * on 9/5/14.
 */
public class FundServiceTest {

    private static FundRepo mockFundRepo;

    private static FundService fundService;

    @BeforeClass
    public static void beforeClass() {
        mockFundRepo = Mockito.mock(FundRepo.class);

        List<Fund> funds = new ArrayList<>();
        List<Quote> quotes = new ArrayList<>();


        Fund fund = new Fund();
        fund.setName(FundType.FBIOX.name());

        Quote quote = new Quote();
        quote.setAdjusted(23.43);
        quotes.add(quote);

        quote = new Quote();
        quote.setAdjusted(24.23);
        quotes.add(quote);

        quote = new Quote();
        quote.setAdjusted(23.88);
        quotes.add(quote);

        fund.setQuotes(quotes);
        funds.add(fund);


        when(mockFundRepo.getBetween(any(DateTime.class), any(DateTime.class))).thenReturn(funds);

        fundService = new FundService();
        fundService.fundRepo = mockFundRepo;
    }

    @Test
    public void shouldGetFunds() {
        List<Fund> funds = fundService.getFunds();

        assertThat(funds.size(), is(1));

        Fund fund = funds.get(0);
        assertThat(fund, is(notNullValue()));

        List<Quote> quotes = fund.getQuotes();
        assertThat(quotes, is(notNullValue()));
        assertThat(quotes, hasSize(3));

        Quote quote = quotes.get(0);
        assertThat(quote, is(notNullValue()));
        assertThat(quote.getChange(), is(1.9));

        quote = quotes.get(1);
        assertThat(quote, is(notNullValue()));
        assertThat(quote.getChange(), is(-1.4));

        quote = quotes.get(2);
        assertThat(quote, is(notNullValue()));
        assertThat(quote.getChange(), is(nullValue()));
    }

}
