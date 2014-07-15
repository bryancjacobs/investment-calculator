package invest.repo;

import invest.Application;
import invest.model.Fund;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: Bryan
 * Date: 6/25/14
 * Time: 9:05 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class InvestRepoIT {

    @Autowired
    FundRepo investRepo;

    @Test
    public void getInvest() {
        List<Fund> funds = investRepo.getAll();
        System.out.println(funds);
    }

}
