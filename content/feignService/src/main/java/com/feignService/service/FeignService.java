package com.feignService.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by peter on 2018/3/14.
 */
@FeignClient(value = "service-provider1",fallback = FeignServiceHystric.class)
public interface FeignService {

    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public String showInfo();
}
