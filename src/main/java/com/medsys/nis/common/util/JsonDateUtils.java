package com.medsys.nis.common.util; /**
 * Created by Super on 2020/8/21.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/21 17:12
 */
public class JsonDateUtils {
    public static String getJson(Object object){
    return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }
    public static String getJson(Object object,String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        //1.如何让他不返回时间戳！所有我们要关闭他的时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //2.时间格式化问题！自定日期格式对象；
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //3.让mapper 指定时间日期格式为simpleDateFormat;
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
    return null;
    }

}
