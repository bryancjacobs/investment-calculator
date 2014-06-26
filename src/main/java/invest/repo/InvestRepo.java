package invest.repo;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.json.simple.parser.JSONParser;
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

    public static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select * from yahoo.finance.historicaldata where symbol in (\"YHOO\", \"fselx\") and startDate = \"2014-01-11\" and endDate = \"2014-03-10\"&format=json&env=store://datatables.org/alltableswithkeys&callback=";


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JSONParser jsonParser;

    public String getAll() {

        String s = restTemplate.getForObject(URL, String.class);

        JSONArray yahoo = JsonPath.read(s, "$.query.results.quote[?(@.Symbol == 'YHOO')]");
        System.out.println(yahoo.size());

        JSONArray fselx = JsonPath.read(s, "$.query.results.quote[?(@.Symbol == 'fselx')]");
        System.out.println(fselx.size());

        System.out.println("TOtal: " + (fselx.size() + yahoo.size()));

        return null;
    }
}
