package invest.repo;

import invest.it.IntegrationTest;
import invest.model.Fund;
import invest.model.FundType;
import invest.model.Quote;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static invest.util.DateUtil.monthsBefore;
import static org.junit.Assert.assertTrue;

/**
 * User: Bryan
 * Date: 6/25/14
 * Time: 9:05 PM
 */
public class FundRepoIT extends IntegrationTest {

    @Autowired
    FundRepo fundRepo;

    @Test
    public void shouldGetFundsBetweenStartAndEnd() {
        DateTime end = new DateTime(2014, 4, 3, 10, 0);

        DateTime start = monthsBefore(end, 1);

        List<Fund> funds = fundRepo.getBetween(start, end);

        assertTrue(funds.size() == FundType.values().length);

        for (Fund fund : funds) {
            for (Quote quote : fund.getQuotes()) {
                assertTrue(quote.isWednesday());
            }
        }
    }

}
