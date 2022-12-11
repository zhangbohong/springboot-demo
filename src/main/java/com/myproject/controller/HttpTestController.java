package com.myproject.controller;

import com.myproject.service.HttpTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/amap")
public class HttpTestController {

    @Autowired
    @Qualifier(value = "httpTestService")
    private HttpTestService httpTestService;

    @RequestMapping(value = "/location/get/{longitude}/{latitude}", method = RequestMethod.GET)
    public Map testLocation(@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude){
        return httpTestService.getLocation(longitude,latitude);
    }
}
