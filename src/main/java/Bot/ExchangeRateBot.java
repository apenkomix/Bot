package Bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ExchangeRateBot {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateBot.class, args);
    }

    @Bean
    public ExchangeRateBott exchangeRatebot() {return new ExchangeRateBott();
    }
}
