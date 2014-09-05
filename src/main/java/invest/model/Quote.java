package invest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Calendar;
import java.util.Date;

/**
 * User: Bryan
 * Date: 6/27/14
 * Time: 10:35 PM
 */
public class Quote {

    private Double adjusted;

    private Double change;

    private Date date;

    private Integer rank;

    @JsonIgnore
    public boolean isWednesday() {

        if (date == null) return false;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        // 4 = Wednesday in the calendar api
        return dayOfWeek == 4;
    }

    public Double getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(Double adjusted) {
        this.adjusted = adjusted;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (adjusted != null ? !adjusted.equals(quote.adjusted) : quote.adjusted != null) return false;
        if (change != null ? !change.equals(quote.change) : quote.change != null) return false;
        if (date != null ? !date.equals(quote.date) : quote.date != null) return false;
        return !(rank != null ? !rank.equals(quote.rank) : quote.rank != null);

    }

    @Override
    public int hashCode() {
        int result = adjusted != null ? adjusted.hashCode() : 0;
        result = 31 * result + (change != null ? change.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "adjusted=" + adjusted +
                ", change=" + change +
                ", date=" + date +
                ", rank=" + rank +
                '}';
    }
}
