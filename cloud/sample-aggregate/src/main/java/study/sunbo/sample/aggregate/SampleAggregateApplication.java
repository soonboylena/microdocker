package study.sunbo.sample.aggregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "study.sunbo.sample.provider2.client")
public class SampleAggregateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAggregateApplication.class, args);
    }

}
