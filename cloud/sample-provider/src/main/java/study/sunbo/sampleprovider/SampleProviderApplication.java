package study.sunbo.sampleprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class SampleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProviderApplication.class, args);
    }

    @RestController
    @RequestMapping("/time")
    public class VersionController {

        @GetMapping()
        public Map<String, String> time() {
            log.info("-------------------------");
            return Collections.singletonMap("now", LocalDateTime.now().toString());
        }
    }

}

