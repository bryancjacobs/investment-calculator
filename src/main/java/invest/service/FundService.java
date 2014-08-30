package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import invest.repo.FundRepo;
import invest.util.BigDecimalUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static invest.util.BigDecimalUtil.newBigDecimal;
import static invest.util.DateUtil.threeMonthsBefore;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:40 PM
 */
@Service
public class FundService {

    @Autowired
    FundRepo fundRepo;

    public List<Fund> getWithPercentageChange() {

        DateTime now = DateTime.now();

        DateTime threeMonthsBefore = threeMonthsBefore(now);

        List<Fund> funds = fundRepo.getBetween(threeMonthsBefore, now);

        for (Fund fund : funds) {

            int limit = fund.getQuotes().size() - 1;

            List<Quote> quotes = fund.getQuotes();

            BigDecimal total = newBigDecimal(0.0);

            for (int i = 0; i <= limit; i++) {

                if (i == limit) {
                    break;
                }

                Quote current = quotes.get(i);

                Quote next = quotes.get(i + 1);

                Double originalAdjusted = current.getAdjusted();

                Double newAdjusted = next.getAdjusted();

                // calculate percentage increase - if negative then we have percentage decrease
                BigDecimal change = newBigDecimal(((newAdjusted - originalAdjusted) / originalAdjusted) * 100);

                current.setChange(change.doubleValue());

                total = total.add(BigDecimal.valueOf(current.getChange()));
            }

            // subtract one from the collection because the changes only have 12 since the last week has nothing to compare
            BigDecimal averageChange = total.divide(BigDecimal.valueOf(quotes.size() - 1), 2, BigDecimalUtil.ROUND);

            fund.setAverageChange(averageChange.doubleValue());
        }

        return funds;
    }
}
