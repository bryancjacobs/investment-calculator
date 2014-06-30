package invest.model;

import invest.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bryan
 * Date: 6/27/14
 * Time: 10:34 PM
 */
public class Quotes {

    private List<Quote> quotes = new ArrayList<>();

    public void add(String adjusted, String date) {
        Quote quote = new Quote();
        quote.setAdjusted(Double.valueOf(adjusted));
        quote.setDate(DateUtil.toDate(date));

        // only add wednesday's because we only want one day per week
        // right now wednesday is arbitrary...its a starting point
        if (quote.isWednesday()) {
            quotes.add(quote);
        }
    }

    public void addAll(Quotes quotes) {
        this.quotes.addAll(quotes.getQuotes());
    }

    public int size() {
        return quotes.size();
    }

    public Quote get(int index) {
        return quotes.get(index);
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public static Quotes instance() {
        return new Quotes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quotes qutoes = (Quotes) o;

        if (quotes != null ? !quotes.equals(qutoes.quotes) : qutoes.quotes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return quotes != null ? quotes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "quotes=" + quotes +
                '}';
    }
}
