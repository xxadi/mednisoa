package com.medsys.nis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.medsys.emr.common.config")
//@EnableSwagger2
@MapperScan("com.medsys.nis.maintain.mapper")
public class NisApplication {

    public static void main(String[] args) {
        SpringApplication.run(NisApplication.class, args);
        System.out.println("zh YG spring 启动成功！！！！！");
    }

}
