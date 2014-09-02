package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import invest.repo.FundRepo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static invest.util.BigDecimalUtil.*;
import static invest.util.DateUtil.monthsBefore;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:40 PM
 */
@Service
public class FundService {

    @Autowired
    FundRepo fundRepo;

    public List<Fund> getFunds() {

        DateTime now = DateTime.now();

        DateTime threeMonthsBefore = monthsBefore(now, 3);

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

                Double nextAdjusted = next.getAdjusted();

                // calculate percentage increase --- negative means percentage decrease
                BigDecimal change = percentageChange(nextAdjusted, originalAdjusted);
                current.setChange(change.doubleValue());

                total = total.add(BigDecimal.valueOf(current.getChange()));
            }

            // subtract one from the collection because the changes only have 12 since the last week has nothing to compare
            BigDecimal averageChange = total.divide(BigDecimal.valueOf(quotes.size() - 1), newMC());

            fund.setAverageChange(averageChange.doubleValue());
        }

        return funds;
    }
}
