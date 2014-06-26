package invest.service;

import invest.repo.InvestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Bryan
 * Date: 6/16/14
 * Time: 8:40 PM
 */
@Service
public class InvestService {

    @Autowired
    InvestRepo investRepo;

    public String getAll() {
        return investRepo.getAll();
    }
}
