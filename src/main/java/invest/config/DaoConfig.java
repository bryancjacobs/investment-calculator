package invest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * User: Bryan
 * Date: 6/25/14
 * Time: 9:24 PM
 */
@Configuration
public class DaoConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
