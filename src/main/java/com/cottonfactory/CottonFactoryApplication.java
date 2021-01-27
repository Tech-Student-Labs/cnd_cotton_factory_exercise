package com.cottonfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class CottonFactoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CottonFactoryApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.cottonfactory")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Cotton Factory API Docs")
                .description("Cotton Factory developer API documentation")
                .license("GPLv3")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html").version("1.0").build();
    }
}
