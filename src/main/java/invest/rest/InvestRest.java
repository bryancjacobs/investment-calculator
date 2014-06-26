package invest.rest;

import invest.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:41 PM
 */
@RestController
@RequestMapping("/invest")
public class InvestRest {

    @Autowired
    InvestService investService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(){
        return investService.getAll();
    }
}
