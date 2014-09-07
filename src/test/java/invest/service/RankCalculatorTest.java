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
public class RankCalculatorTest {
    private RankCalculator calculator = new RankCalculator();

    @Test
    public void shouldGetRanks() {

        List<Fund> funds = createFunds();

        calculator.calculate(funds);

        assertFunds(funds);
    }

    public static void assertFunds(List<Fund> funds) {
        assertThat(funds, is(notNullValue()));
        assertThat(funds, hasSize(2));

        // assert fbiox
        {
            Fund fbiox = funds.get(0);
            assertThat(fbiox, is(notNullValue()));

            List<Quote> quotes = fbiox.getQuotes();
            assertThat(quotes, is(notNullValue()));
            assertThat(quotes, hasSize(4));

            Quote quote = quotes.get(0);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(1));

            quote = quotes.get(1);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(2));

            quote = quotes.get(2);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(2));
        }

        // assert fbmpx
        {

            Fund fbiox = funds.get(1);
            assertThat(fbiox, is(notNullValue()));

            List<Quote> quotes = fbiox.getQuotes();
            assertThat(quotes, is(notNullValue()));
            assertThat(quotes, hasSize(4));

            Quote quote = quotes.get(0);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(1));

            quote = quotes.get(1);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(1));

            quote = quotes.get(2);
            assertThat(quote, is(notNullValue()));
            assertThat(quote.getRank(), is(1));

        }

    }

    public static List<Fund> createFunds() {

        List<Fund> funds = new ArrayList<>();

        List<Quote> quotes = new ArrayList<>();

        // first
        Fund fund = new Fund();
        fund.setName(FundType.FBIOX.name());

        Quote quote = new Quote();
        quote.setChange(2.43);
        quotes.add(quote);

        quote = new Quote();
        quote.setChange(3.29);
        quotes.add(quote);

        quote = new Quote();
        quote.setChange(3.22);
        quotes.add(quote);

        quote = new Quote();
        quotes.add(quote);

        fund.setQuotes(quotes);
        funds.add(fund);

        // new fund
        fund = new Fund();
        fund.setName(FundType.FBMPX.name());

        quotes = new ArrayList<>();
        fund.setQuotes(quotes);

        quote = new Quote();
        quote.setChange(2.43);
        quotes.add(quote);

        quote = new Quote();
        quote.setChange(3.44);
        quotes.add(quote);

        quote = new Quote();
        quote.setChange(4.11);
        quotes.add(quote);

        quote = new Quote();
        quotes.add(quote);

        funds.add(fund);

        return funds;
    }
}
