package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import invest.repo.FundRepo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bryan
 * Date: 8/17/14
 * Time: 12:01 AM
 */
public class FundServiceTest {

    private FundService fundService = new FundService();

    // TODO: fix this test to actually do something
    @Test
    public void test() {
        fundService.fundRepo = new FundRepoMock();
        List<Fund> funds = fundService.getWithPercentageChange();

        for (Fund fund : funds) {
            for (Quote quote : fund.getQuotes()) {
                System.out.println(quote.getAdjusted());
            }
        }

        System.out.println(funds);
    }

    private class FundRepoMock extends FundRepo {
        public List<Fund> getAll() {

            List<Fund> funds = new ArrayList<>();

            Fund fund = new Fund();
            fund.setName("FSELX");
            fund.setQuotes(create(177.77, 186.31, 189.21, 194.98, 198.11, 199.44, 205.55, 196.19, 188.12, 198.78, 199.14, 195.79, 204.91));
            funds.add(fund);

            return funds;
        }
    }

    private List<Quote> create(Double... adjusteds) {
        List<Quote> quotes = new ArrayList<>();
        for (Double adjusted : adjusteds) {
            Quote quote = new Quote();
            quote.setAdjusted(adjusted);
            quotes.add(quote);
        }

        return quotes;
    }
}
