package study.sunbo.sample.provider2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.sunbo.sample.provider2.client.data.Version;

import java.util.Random;

@SpringBootApplication
@Slf4j
public class SampleProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SampleProvider2Application.class, args);
    }

    @RestController
    @RequestMapping("/v")
    public class VersionController {

        @GetMapping()
        public Version version() {
            final Version version = new Version();
            version.setVersion("ver 1.0");
            log.info("provider2 服务， ver1.0");
            return version;
        }

        @GetMapping("sometimeException")
        public int sometimeException() {

            Random r = new Random();
            final int i = r.nextInt(5);
            if (i == 4) {
                log.warn(" **********************触发异常！！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("equals 4 exception");
            }
            log.info("正常执行！！！");

            return i;
        }
    }
}
