package com.test.inv.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
@ComponentScan({"com.test.inv"})
@EnableSwagger2

@EntityScan("com.test.inv.http.entity")
@EnableJpaRepositories("com.test.inv.http.dao")

@EnableDiscoveryClient
public class HttpApplication {

	@Value("${env.server}")
	public String env = "";	

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(HttpApplication.class, args);
	}

	@Bean
	public Docket createQueryRestApi() {
		ApiInfo apiInfo 
		= new ApiInfoBuilder()
		.title("["+env+"]swagger wallet RESTful APIs")
		.description("swagger wallet RESTful APIs ....... ")
		.termsOfServiceUrl("http://www.test.com/")
		.version("1.0")
		.build();

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.groupName("Query API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.test.inv.http.ctl"))
				.paths(PathSelectors.any())
				.build();
	}

}
