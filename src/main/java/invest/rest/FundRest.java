package invest.rest;

import invest.model.Fund;
import invest.service.FundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:41 PM
 */
@RestController
@RequestMapping("/fund")
public class FundRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FundRest.class);

    @Autowired
    FundService fundService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Fund> getWithPercentageChange() {

        LOGGER.info("START: REST");

        List<Fund> funds = fundService.getFunds();

        LOGGER.info("END: REST");
        return funds;
    }
}
