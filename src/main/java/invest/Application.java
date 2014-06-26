package invest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * User: Bryan
 * Date: 6/17/14
 * Time: 10:24 PM
 */
@ComponentScan
@EnableAutoConfiguration
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
