package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import invest.repo.FundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static invest.util.BigDecimalUtil.create;

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

        List<Fund> funds = fundRepo.getAll();

        for (Fund fund : funds) {

            int limit = fund.getQuotes().size() - 1;

            List<Quote> quotes = fund.getQuotes();

            double total = 0.0;

            for (int i = 0; i <= limit; i++) {

                if (i == limit) {
                    break;
                }

                Quote current = quotes.get(i);

                Quote next = quotes.get(i + 1);

                Double originalAdjusted = current.getAdjusted();

                Double newAdjusted = next.getAdjusted();

                // calculate percentage increase - if negative then we have percentage decrease
                BigDecimal change = create(((newAdjusted - originalAdjusted) / originalAdjusted) * 100);

                current.setChange(change.doubleValue());

                total += current.getChange();
            }

            BigDecimal averageChange = create(total / quotes.size());
            fund.setAverageChange(averageChange.doubleValue());
        }

        return funds;
    }
}
