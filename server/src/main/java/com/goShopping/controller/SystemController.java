package com.goShopping.controller;

import com.goShopping.result.Result;
import com.goShopping.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    SystemService systemService;
    @GetMapping("/recommend/{pageNum}")
    public Result recommend(@PathVariable int pageNum){
        return systemService.recommend(pageNum);
    }
    @GetMapping("/book/detail/{id}")
    public Result bookDetail(@PathVariable int id){
         return systemService.getBookDetail(id);
    }
    @GetMapping("/category/{id}")
    public Result getCategoryAll(@PathVariable int id){
       return systemService.getCategories(id);
    }
}
