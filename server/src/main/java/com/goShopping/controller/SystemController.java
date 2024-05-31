package com.goShopping.controller;

import com.goShopping.result.Result;
import com.goShopping.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    SystemService systemService;
    @GetMapping("/recommend")
    public Result recommend(){
        return systemService.recommend();
    }
}
