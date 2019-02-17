package study.sunbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.sunbo.provider2.data.Version;

@SpringBootApplication
public class SampleProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SampleProvider2Application.class, args);
    }

    @RestController
    public class AggregateController {

        @GetMapping
        public Version version() {
            return new Version();
        }

    }


}
