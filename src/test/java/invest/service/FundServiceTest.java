package invest.service;

import invest.repo.FundRepo;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static invest.service.ChangeCalculatorTest.assertFunds;
import static invest.service.ChangeCalculatorTest.createFunds;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by bryan.jacobs
 * on 9/5/14.
 */
public class FundServiceTest {

    private static FundService fundService = new FundService();

    @BeforeClass
    public static void beforeClass() {
        FundRepo mockFundRepo = Mockito.mock(FundRepo.class);

        fundService.fundRepo = mockFundRepo;

        FundCalculator fundCalculator = new FundCalculator();

        fundService.fundCalculator = fundCalculator;

        fundCalculator.calculateables = Arrays.asList(new RankCalculator(), new ChangeCalculator());

        when(mockFundRepo.getBetween(any(DateTime.class), any(DateTime.class))).thenReturn(createFunds());
    }

    @Test
    public void shouldGetFunds() {
        assertFunds(fundService.getFunds());
    }
}
