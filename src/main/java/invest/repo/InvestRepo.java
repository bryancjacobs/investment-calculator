package invest.repo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:41 PM
 */
@Repository
public class InvestRepo {

    public static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select * from yahoo.finance.historicaldata where symbol = \"YHOO\" and startDate = \"2009-09-11\" and endDate = \"2010-03-10\"&format=json&env=store://datatables.org/alltableswithkeys&callback=";


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JSONParser jsonParser;

    public String getAll() {

        String s = restTemplate.getForObject(URL, String.class, null);
        System.out.println(s);


        try {
            JSONObject jsonObject = (JSONObject)jsonParser.parse(s);
            JSONObject query = (JSONObject)jsonObject.get("query");
            JSONObject results = (JSONObject)query.get("results");
            JSONArray quotes = (JSONArray) results.get("quote");

            System.out.println(quotes.size());
            System.out.println(quotes);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse results from yql: " + s);
        }

        return null;
    }
}
