package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static invest.util.BigDecimalUtil.percentageChange;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
@Component
public class ChangeCalculator implements Calculateable {
    @Override
    public void calculate(List<Fund> funds) {
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
    }
}
