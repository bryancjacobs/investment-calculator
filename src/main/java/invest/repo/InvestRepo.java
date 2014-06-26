package invest.repo;

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

    public static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22YHOO%22%20and%20startDate%20%3D%20%222009-09-11%22%20and%20endDate%20%3D%20%222010-03-10%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
    @Autowired
    RestTemplate restTemplate;

    JSONParser jsonParser = new JSONParser();

    public String getAll() {

        String s = restTemplate.getForObject(URL, String.class, null);

        try {
            jsonParser.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse results from yql: " + s);
        }

        return null;
    }
}
