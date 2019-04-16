package study.sunbo.sample.aggregate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.sunbo.sample.provider2.client.data.Version;
import study.sunbo.sample.provider2.client.service.VersionService;

@RestController
@RequestMapping("aggre")
@Slf4j
public class AggregateController {

    @Autowired
    private VersionService versionService;

    @GetMapping("versionFromP2")
    public Version getVersionFromProvider2() {
        return versionService.version();
    }

    @GetMapping("getNumber")
    public int getNumber() {
        return versionService.sometimeException();
    }
}
