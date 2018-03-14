package com.feignService.controller;

import com.feignService.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peter on 2018/3/14.
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/hello")
    public String hi(){
        return "******该业务由feign处理*******<br/>"+feignService.showInfo();
    }
}
