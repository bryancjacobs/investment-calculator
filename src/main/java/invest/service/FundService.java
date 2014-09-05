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

            // find the most current quote and compare all other quotes to this one
            Quote compareToQuote = fund.getQuotes().get(limit);

            List<Quote> quotes = fund.getQuotes();

            for (int i = 0; i <= limit; i++) {

                if (i == limit) {
                    break;
                }

                Quote quote = quotes.get(i);

                Double original = quote.getAdjusted();

                Double current = compareToQuote.getAdjusted();

                // calculate percentage increase --- negative means percentage decrease
                BigDecimal change = percentageChange(current, original);

                quote.setChange(change.doubleValue());
            }
        }

        return funds;
    }
}
