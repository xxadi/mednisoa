//package com.medsys.emr.common.config;
//
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSerializationContext;
//import com.google.gson.JsonSerializer;
//import org.springframework.stereotype.Component;
//import springfox.documentation.spring.web.json.Json;
//
//import java.lang.reflect.Type;
//
///**
// * @ClassName SpringfoxJsonToGsonSerializer
// * @Author zhuzhh
// * @Date 2020/7/27
// */
//public class SpringfoxJsonToGsonSerializer implements JsonSerializer<Json> {
//
//    @Override
//    public JsonElement serialize(Json json, Type type, JsonSerializationContext jsonSerializationContext) {
//        final JsonParser parser = new JsonParser();
//        return parser.parse(json.value());
//    }
//}
