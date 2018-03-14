package com.ribbonService.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by peter on 2018/3/14.
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "infoError") //注解声明当出现错误是调用哪个方法
    public String info(){
        return "******该业务由ribbon处理*******<br/>"+restTemplate.getForObject("http://service-provider1/info",String.class);
    }

    /*自定义方法，当故障时调用此方法*/
    public String infoError(){
        return "<h3>sorry，出现故障，请刷新重试！</h3>";
    }
}
