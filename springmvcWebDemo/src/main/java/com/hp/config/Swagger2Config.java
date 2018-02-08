package com.hp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by hp on 2018/1/29.
 */
//@WebAppConfiguration
@EnableWebMvc
@Configuration    // 配置注解，自动在本类上下文加载一些环境变量信息
@EnableSwagger2   // 使swagger2生效
public class Swagger2Config{
	//访问路径 /swagger-ui.html
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hp.controller.sys"))//根据自己项目修改
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		//访问地址 /swagger-ui.html
		return new ApiInfoBuilder()
				.title("RESTful APIs ")
				.description("Restful API文档")
				.termsOfServiceUrl("http://localhost:8080/springmvc/swagger-ui.html") // 将“url”换成自己的ip:port
				.version("1.0")
				.build();
	}
}
