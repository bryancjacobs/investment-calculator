package invest.model;

/**
 * User: Bryan
 * Date: 6/27/14
 * Time: 10:34 PM
 */
public class Fund {

    private String name;

    private Quotes quotes = new Quotes();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fund fund = (Fund) o;

        if (name != null ? !name.equals(fund.name) : fund.name != null) return false;
        if (quotes != null ? !quotes.equals(fund.quotes) : fund.quotes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (quotes != null ? quotes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "name='" + name + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}
