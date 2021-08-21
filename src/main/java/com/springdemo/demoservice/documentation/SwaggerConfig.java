package com.springdemo.demoservice.documentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket apiConfig(){
    List<ResponseMessage> responseMessageList = new ArrayList<>();
    responseMessageList.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Result")).build());
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .paths(PathSelectors.ant("/api/**"))
        .build()
        //.globalResponseMessage(RequestMethod.GET, responseMessageList)
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "REST API for testing",
        "Description of testing APIs.",
        "1.0",
        "",
        new Contact("Valtech Mobility", "", ""),
        "", "", Collections.emptyList());
  }
}
