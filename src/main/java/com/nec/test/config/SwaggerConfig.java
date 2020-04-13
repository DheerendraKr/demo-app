package com.nec.test.config;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kunwar.dheerendra
 * @version 1.0
 * @since 1.0
 * Enabling swaager documentation for the application.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/** Applicaiton title constant. */
	private static final String TITLE = "Sample application.";
	
	/** Application description. */
	private static final String DESCRIPTION = "Sample web application.";
	
  /**
   * Swagger documentation related configurations. *
   *
   * @return Docket Object of Docket class.
   */
  @Bean
  public Docket swaggerSpringMvcPlugin() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(productInfo())
        .select()
        .paths(paths())
        .build();
  }

  /**
   * Return path that will not be shown in the ui.
   *
   * @return Predicate<String> returns path.
   */
  private Predicate<String> paths() {
    return Predicates.not(PathSelectors.regex("/error.*"));
  }

  private ApiInfo productInfo() {

    Contact contact = new Contact("NEC Technologies", "", "");
    return new ApiInfoBuilder()
        .title(TITLE)
        .description(DESCRIPTION)
        .contact(contact)
        .build();
  }

  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
