package com.feignService.service;

import org.springframework.stereotype.Component;

/**
 * Created by peter on 2018/3/14.
 */
@Component   //注入到ioc容器，可能需要断路的接口
public class FeignServiceHystric implements  FeignService{


    @Override
    public String showInfo() {
        return "sorry,出现故障，请刷新重试！";
    }
}
