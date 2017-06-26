package com.leo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wangliying on 2017/6/1.
 * Description:
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.leo.controller"})
public class SwaggerApiConfig {
    @Bean
    public Docket customApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("leo", "github", "leo.wang");
        return new ApiInfoBuilder()
                .title("Spring Boot Api")
                .description("document for api")
                .contact(contact)
                .build();


    }
}
