package study.sunbo.sample.provider2.client.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.sunbo.sample.provider2.client.data.Version;

@Slf4j
@Component
public class VersionServiceDefaultFallbackFactory implements FallbackFactory<VersionService> {

    @Override
    public VersionService create(Throwable throwable) {
        return new VersionService() {
            @Override
            public Version version() {
                log.warn(" 失败： {}", throwable.getMessage());
                return new Version("unknown");
            }

            @Override
            public int sometimeException() {
                log.warn(" 失败： {}", throwable.getMessage());
                return 999;
            }
        };
    }
}
