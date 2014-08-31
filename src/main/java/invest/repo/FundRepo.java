package invest.repo;

import com.jayway.jsonpath.JsonPath;
import invest.model.Fund;
import invest.model.FundType;
import invest.model.Quote;
import invest.util.DateUtil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static invest.util.DateUtil.toStr;
import static java.lang.String.format;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:41 PM
 */
@Repository
public class FundRepo {

    public static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select * from yahoo.finance.historicaldata where symbol in (%s) and startDate = \"%s\" and endDate = \"%s\" | sort(field=\"Date\")&format=json&env=store://datatables.org/alltableswithkeys&callback=";

    @Autowired
    RestTemplate restTemplate;

    public List<Fund> getBetween(DateTime start, DateTime end) {

        String startStr = toStr(start);
        String endStr = toStr(end);

        // first request
        String commaSeparated = FundType.commaSeparated(0, 19);
        String formattedUrl = format(URL, commaSeparated, startStr, endStr);
        String json = restTemplate.getForObject(formattedUrl, String.class);
        List<Fund> funds = getFunds(json, commaSeparated);

        // second request
        commaSeparated = FundType.commaSeparated(20, 45);
        formattedUrl = format(URL, commaSeparated, startStr, endStr);
        json = restTemplate.getForObject(formattedUrl, String.class);
        funds.addAll(getFunds(json, commaSeparated));

        return funds;
    }

    private List<Fund> getFunds(String json, String commaSeparated) {
        List<Fund> funds = new ArrayList<>();

        for (FundType fundType : FundType.commaToFundTypes(commaSeparated)) {
            List<Quote> quotes = create(json, format("$.query.results.quote[?(@.Symbol == '%s')]", fundType.name()));
            Fund fund = new Fund();
            fund.setName(fundType.name());
            fund.setQuotes(quotes);
            funds.add(fund);
        }
        return funds;
    }

    private List<Quote> create(String json, String query) {

        JSONArray jsonArray = JsonPath.read(json, query);

        List<Quote> quotes = new ArrayList<>();

        for (Object aJsonArray : jsonArray) {
            JSONObject jsonQuote = (JSONObject) aJsonArray;

            Quote quote = new Quote();
            quote.setAdjusted(Double.valueOf((String) jsonQuote.get("Adj_Close")));
            quote.setDate(DateUtil.toDate((String) jsonQuote.get("Date")));

            if (quote.isWednesday()) {
                quotes.add(quote);
            }
        }

        return quotes;
    }
}
