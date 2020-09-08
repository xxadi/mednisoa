//package com.medsys.emr.common.config;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//import org.springframework.stereotype.Component;
//import springfox.documentation.spring.web.json.Json;
//
///**
// * @ClassName CustomizedGsonHttpMessageConverter
// * @Author zhuzhh
// * @Date 2020/7/27
// */
//@Component
//public class CustomizedGsonHttpMessageConverter extends GsonHttpMessageConverter {
//    public CustomizedGsonHttpMessageConverter() {
//        super();
//        this.setGson(gson());
//    }
//
//    private Gson gson() {
//        final GsonBuilder builder = new GsonBuilder();
//        builder.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonSerializer());
//        return builder.create();
//    }
//}
