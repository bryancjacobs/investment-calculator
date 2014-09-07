package invest.service;

import invest.model.Fund;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
@Component
public class FundCalculator {

    // because order matters don't autowire
    List<Calculateable> calculateables;

    public void calculate(List<Fund> funds) {

        for (Calculateable calculateable : calculateables) {
            calculateable.calculate(funds);
        }
    }

    @PostConstruct
    void postConstruct() {
        calculateables = Arrays.asList(new ChangeCalculator(), new RankCalculator());
    }

}
