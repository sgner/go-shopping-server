package com.goShopping.controller;

import com.goShopping.result.Result;
import com.goShopping.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    EventsService eventsService;
    @GetMapping("/long-term/newArrivalsSpecial")
    public Result newArrivalsSpecial(){
        return eventsService.newArrivalSpecial();
    }
}
