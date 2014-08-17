package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import invest.repo.FundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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

            for (int i = 0; i <= limit; i++) {

                if (i == limit) {
                    break;
                }

                Quote current = quotes.get(i);

                Quote next = quotes.get(i + 1);

                Double originalAdjusted = current.getAdjusted();

                Double newAdjusted = next.getAdjusted();

                // calculate percentage increase - if negative then we have percentage decrease
                BigDecimal change = new BigDecimal(((newAdjusted - originalAdjusted) / originalAdjusted) * 100)
                        .setScale(2, RoundingMode.HALF_UP);

                current.setChange(change.doubleValue());
            }
        }

        return funds;

    }
}
