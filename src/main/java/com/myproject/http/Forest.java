package com.myproject.http;

import com.dtflys.forest.annotation.*;

import java.util.Map;


public interface Forest {

    /**
     * 聪明的你一定看出来了这是一个GET请求
     */
    @Get("https://ditu.amap.com/service/regeo?longitude={lng}&latitude={lat}")
    Map getLocation(@Var("lng") String longitude, @Var("lat") String latitude);
}
