package invest.service;

import invest.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
@Component
public class FundCalculator {

    @Autowired
    List<Calculateable> calculateables;

    public void calculate(List<Fund> funds) {
        for (Calculateable calculateable : calculateables) {
            calculateable.calculate(funds);
        }
    }

}
