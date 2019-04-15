package study.sunbo.sample.provider2.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.sunbo.sample.provider2.client.data.Version;

@FeignClient("sample-provider2")
@RequestMapping("/v")
@Service
public interface VersionService {

    @GetMapping
    public Version version();
}
