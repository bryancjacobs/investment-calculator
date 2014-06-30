package invest.service;

import invest.model.Fund;
import invest.model.Funds;
import invest.model.Quote;
import invest.model.Quotes;
import invest.repo.FundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:40 PM
 */
@Service
public class FundService {

    @Autowired
    FundRepo fundRepo;

    public Funds getWithPercentageChange() {

        Funds funds = fundRepo.getAll();

        for (Fund fund : funds.getFunds()) {


            int limit = fund.getQuotes().size() - 1;

            Quotes quotes = fund.getQuotes();

            for (int i = 0; i <= limit; i++) {

                if (i == limit) {
                    break;
                }

                Quote current = quotes.get(i);

                Quote next = quotes.get(i + 1);

                Double originalAdjusted = current.getAdjusted();

                Double newAdjusted = next.getAdjusted();

                // calculate percentage increase - if negative then we have percentage decrease
                current.setChange(((newAdjusted - originalAdjusted) / originalAdjusted) * 100);
            }
        }

        return funds;

    }
}
