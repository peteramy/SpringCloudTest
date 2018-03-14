package com.serviceProvider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peter on 2018/3/14.
 */
@RestController
public class InfoController {

    @Value("${server.port}")  //从配置文件中取port号
    private String port;
    @Value("${spring.application.name}")
    private String name;



    /*显示服务信息及端口号*/
    @RequestMapping(value="/info",method = RequestMethod.GET)
    public String info(){
        return "welcome，信息如下<br/>服务名称： "+ name +"<br/>端口号： "+port;
    }
}
