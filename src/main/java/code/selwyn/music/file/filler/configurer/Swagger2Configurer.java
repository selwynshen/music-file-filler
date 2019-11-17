/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Selwyn
 * @version $Id: Swagger2Configurer.java, v 0.1 3/4/2019 9:47 AM Selwyn Exp $
 */
@Configuration
@EnableSwagger2
public class Swagger2Configurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("code.selwyn.music.file.filler.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
