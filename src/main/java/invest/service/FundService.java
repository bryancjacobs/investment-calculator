package invest.service;

import invest.model.Fund;
import invest.repo.FundRepo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static invest.util.DateUtil.monthsBefore;
import static invest.util.DateUtil.weeksBefore;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:40 PM
 */
@Service
public class FundService {

    @Autowired
    FundRepo fundRepo;

    @Autowired
    FundCalculator fundCalculator;

    public List<Fund> getFunds() {

        DateTime now = DateTime.now();

        DateTime threeMonthsBefore = weeksBefore(now, 12);

        List<Fund> funds = fundRepo.getBetween(threeMonthsBefore, now);

        fundCalculator.calculate(funds);

        return funds;
    }
}
