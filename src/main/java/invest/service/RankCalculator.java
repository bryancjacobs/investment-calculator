package invest.service;

import invest.model.Fund;
import invest.model.Quote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
@Component
public class RankCalculator implements Calculateable {
    @Override
    public void calculate(List<Fund> funds) {
        // the first week is zero...so the count is 0,1,2,...
        int totalWeeks = funds.get(0).getQuotes().size() - 1;

        for (int week = 0; week <= totalWeeks; week++) {
            List<Quote> quotes = getQuotesByWeek(funds, week);

            Collections.sort(quotes, new QuoteComparator());

            int rank = 1;

            for (int i = 0; i < quotes.size(); i++) {

                Quote current = quotes.get(i);

                if (i == 0) {
                    current.setRank(rank);
                }
                else{

                    Quote previous = quotes.get(i - 1);

                    if (current.getChange().equals(previous.getChange())) {
                        current.setRank(previous.getRank());
                    } else {
                        current.setRank(++rank);
                    }
                }
            }
        }
    }

    private List<Quote> getQuotesByWeek(List<Fund> funds, int week) {
        List<Quote> quotes = new ArrayList<>();

        for (Fund fund : funds) {
            quotes.add(fund.getQuotes().get(week));
        }

        return quotes;
    }

    private class QuoteComparator implements Comparator<Quote> {

        @Override
        public int compare(Quote o1, Quote o2) {
            return o2.getChange().compareTo(o1.getChange());
        }
    }
}
