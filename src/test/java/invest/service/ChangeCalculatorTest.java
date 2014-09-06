package invest.service;

import invest.model.Fund;
import invest.model.FundType;
import invest.model.Quote;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
public class ChangeCalculatorTest {

    @Test
    public void calculate() {
        ChangeCalculator calculator = new ChangeCalculator();

        List<Fund> funds = createFunds();
        calculator.calculate(funds);

        assertFunds(funds);
    }

    public static void assertFunds(List<Fund> funds) {
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

    public static List<Fund> createFunds() {
        List<Quote> quotes = new ArrayList<>();
        List<Fund> funds = new ArrayList<>();
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

        return funds;
    }
}
