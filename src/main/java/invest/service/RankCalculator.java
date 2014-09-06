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
        int totalWeeks = 12;

        for (int week = 1; week <= totalWeeks; week++) {
            List<Quote> quotes = getQuotesByWeek(funds, week);

            Collections.sort(quotes, new QuoteComparator());

            int rank = 1;

            for (int i = 0; i < quotes.size(); i++) {

                Quote current = quotes.get(i);
                Quote previous = quotes.get(i - 1);

                if (i == 0) {
                    current.setRank(rank);
                }
                else{

                    if (current.getChange().equals(previous.getChange())) {
                        current.setChange(previous.getChange());
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
            return o1.getChange().compareTo(o2.getChange());
        }
    }
}
