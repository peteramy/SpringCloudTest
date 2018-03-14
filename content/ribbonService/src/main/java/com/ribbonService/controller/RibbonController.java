package com.ribbonService.controller;

import com.ribbonService.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peter on 2018/3/14.
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;
    @RequestMapping("/hi")
    public String hi(){
        return ribbonService.info();
    }


}
