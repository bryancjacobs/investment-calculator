package invest.service;

import invest.model.Fund;

import java.util.List;

/**
 * Created by bryan.jacobs
 * on 9/6/14.
 */
public interface Calculateable {

    public void calculate(List<Fund> funds);

}
