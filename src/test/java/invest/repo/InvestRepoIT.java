package invest.repo;

import invest.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Bryan
 * Date: 6/25/14
 * Time: 9:05 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class InvestRepoIT {

    @Autowired
    InvestRepo investRepo;

    @Test
    public void getInvest(){
        investRepo.getAll();
    }

}
