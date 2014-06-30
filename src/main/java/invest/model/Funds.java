package invest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Bryan
 * Date: 6/30/14
 * Time: 12:16 AM
 */
public class Funds {
    List<Fund> funds = new ArrayList<>();

    public void add(FundType fundType, Quotes quotes) {
        Fund fund = new Fund();
        fund.setName(fundType.name());
        fund.setQuotes(quotes);
        funds.add(fund);
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funds funds1 = (Funds) o;

        if (funds != null ? !funds.equals(funds1.funds) : funds1.funds != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return funds != null ? funds.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Funds{" +
                "funds=" + funds +
                '}';
    }
}
