package com.example.demo1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo1"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot 项目集成 Swagger 实例文档",
                "霸道总裁他的眼里，三分薄凉，三分讥笑，还有四分漫不经心。",
                "API V1.0",
                "Terms Of ServiceUrl",
                new Contact("一名路人洒泪而过", "https://baidu.com", "496468592@qq.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
