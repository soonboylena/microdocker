package study.sunbo.sample.aggregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"study.sunbo.sample"})
@EnableFeignClients(basePackages = "study.sunbo.sample.provider2.client")
@EnableHystrix
@EnableCircuitBreaker
public class SampleAggregateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAggregateApplication.class, args);
    }

}
