package br.com.cadocruz.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("CadoCruz echo API")
				.description(
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
						+ "Cras ac eros risus. In hac habitasse platea dictumst. Vivamus "
						+ "tempor dolor nisi, non tempus elit ultricies sit amet. Morbi laoreet "
						+ "tempus nunc, id efficitur velit malesuada quis. Cras sed ex quam. "
						+ "Vestibulum a est vel velit sagittis fringilla. Aenean semper nec "
						+ "nisi et euismod. Proin consequat euismod felis a lacinia. Vivamus "
						+ "lectus neque, imperdiet id ex et, laoreet posuere lacus. Phasellus "
						+ "a odio orci. Sed varius, erat nec posuere fermentum, ipsum sapien "
						+ "pellentesque augue, et dictum metus risus at ipsum. Aliquam erat "
						+ "volutpat. Sed turpis lorem, commodo vitae nunc at, gravida facilisis "
						+ "nisi. Sed mauris leo, auctor eget porttitor auctor, tincidunt eget leo. "
						+ "Donec sed ultrices tellus. Praesent suscipit facilisis venenatis.")
				.termsOfServiceUrl("http://cadocruz.com.br")
				.contact("cadocruz")
				.license("The MIT License (MIT)")
				.licenseUrl("https://github.com/cadocruz/cadocruz-swagger-demo/blob/master/LICENSE")
				.build();
	}

	// Here is an example where we select any api that matches one of these
	// paths
	private Predicate<String> paths() {
		return or(
				regex("/api.*"), 
				regex("/test.*")
			);
	}
}
