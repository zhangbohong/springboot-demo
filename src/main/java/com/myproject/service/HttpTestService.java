package com.myproject.service;

import com.myproject.http.Forest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class HttpTestService {

    @Resource
    Forest forest;

    public Map getLocation(String longitude, String latitude) {
        Map location = forest.getLocation(longitude, latitude);
        return location;
    }
}
