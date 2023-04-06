import service.ExchangeRateBott;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("config")
public class ExchangeRateBot {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateBot.class, args);
    }
}