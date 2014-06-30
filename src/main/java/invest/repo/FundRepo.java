package invest.repo;

import com.jayway.jsonpath.JsonPath;
import invest.model.FundType;
import invest.model.Funds;
import invest.model.Quotes;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

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

    public Funds getAll() {

        Date now = new Date();

        Date nowMinusThreeMonths = new DateTime().minusMonths(3).toDate();

        String json = restTemplate.getForObject(format(URL, FundType.commaSeparated(), toStr(nowMinusThreeMonths), toStr(now)), String.class);


        Funds funds = new Funds();
        for (FundType fundType : FundType.values()) {
            Quotes quotes = create(json, format("$.query.results.quote[?(@.Symbol == '%s')]", fundType.name()));
            funds.add(fundType, quotes);
        }

        return funds;
    }

    private Quotes create(String json, String query) {

        JSONArray jsonArray = JsonPath.read(json, query);

        Quotes quotes = Quotes.instance();

        for (Object aJsonArray : jsonArray) {
            JSONObject quote = (JSONObject) aJsonArray;
            quotes.add((String) quote.get("Adj_Close"), (String) quote.get("Date"));
        }

        return quotes;
    }
}
