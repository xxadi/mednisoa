package com.medsys.nis.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

//@Import({ SpringfoxWebMvcConfiguration.class, SwaggerCommonConfiguration.class })
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "base", name = "swagger-open", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket api(Environment environment) {

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        //  任何
        // .paths(PathSelectors.any())
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // 调用apiInfo方法
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.medsys.nis.maintain.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("zhouw","http://baidu.com/","476877476@qq.com");
        return new ApiInfo(
                "中恒院感SwaggerAPI文档",
                "这是我的swaggerui生成的接口文档",
                "v1.0",
                "https://baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()


        );
//                .title("中恒院感SwaggerAPI文档")
//                .description("这是我的swaggerui生成的接口文档")
//                .version("1.0.0.0")
//                .build();

    }

}