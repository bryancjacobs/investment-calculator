package invest.repo;

import invest.Application;
import invest.model.Fund;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static invest.util.DateUtil.monthsBefore;

/**
 * User: Bryan
 * Date: 6/25/14
 * Time: 9:05 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FundRepoIT {

    @Autowired
    FundRepo investRepo;

    @Test
    public void shouldGetFundsBetweenNowAndOneMonthBack() {
        DateTime now = DateTime.now();

        DateTime oneMonthBefore = monthsBefore(now, 1);

        List<Fund> funds = investRepo.getBetween(oneMonthBefore, now);
        System.out.println(funds);
    }

}
