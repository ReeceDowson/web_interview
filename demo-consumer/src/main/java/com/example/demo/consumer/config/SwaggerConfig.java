package com.example.demo.consumer.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private Environment env;

    /**
     * 可以定义多个组
     *
     */
    @Bean
    public Docket createDocket() {
        String paths = env.getProperty("swagger.paths");
        String[] pathArray = paths.split(",");
        Predicate[] predicates = null;
        if(pathArray.length > 0){
            predicates = new Predicate[pathArray.length];
            for(int i =0;i<pathArray.length;i++){
                String pathRegex = pathArray[i];
                predicates[i]= PathSelectors.regex(pathRegex);
            }
        }
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(ApiInfo())
            .forCodeGeneration(true)
            .directModelSubstitute(java.nio.ByteBuffer.class, String.class)
            .select()
//            .paths(PathSelectors.any())
            .paths(Predicates.or(predicates))
            .build();
        return docket;
    }


    private ApiInfo ApiInfo() {
        String appName = env.getProperty("spring.application.name");
        if(appName ==null){
            appName="Rest Api";
        }
        return new ApiInfoBuilder()
            .title(appName)
            .description(appName + " RESTful API文档")
            .version("1.0")
            .termsOfServiceUrl("com.example")
            .contact(new Contact("example", "http://www.syn-trust.net", "zhangrihui221@yeah.net"))
            .license("The Apache License, Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .build();
    }

}