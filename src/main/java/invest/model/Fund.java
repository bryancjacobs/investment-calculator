package invest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bryan
 * Date: 6/27/14
 * Time: 10:34 PM
 */
public class Fund {

    private String name;

    private Double averageChange;

    private List<Quote> quotes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Double getAverageChange() {
        return averageChange;
    }

    public void setAverageChange(Double averageChange) {
        this.averageChange = averageChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fund fund = (Fund) o;

        if (averageChange != null ? !averageChange.equals(fund.averageChange) : fund.averageChange != null)
            return false;
        if (name != null ? !name.equals(fund.name) : fund.name != null) return false;
        if (quotes != null ? !quotes.equals(fund.quotes) : fund.quotes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (averageChange != null ? averageChange.hashCode() : 0);
        result = 31 * result + (quotes != null ? quotes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "name='" + name + '\'' +
                ", averageChange=" + averageChange +
                ", quotes=" + quotes +
                '}';
    }
}
