package ae.etisalat.ems;

import org.springframework.context.annotation.*;


import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-04-27T11:06:38.690030200+05:30[Asia/Calcutta]")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("Employee Management Demo")
	            .description("Employee CRUD")
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .termsOfServiceUrl("")
	            .version("1.0.0")
	            .contact(new Contact("","", ""))
	            .build();
	    }
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("ae.etisalat.ems.controller"))	
	      .build()
	      .apiInfo(apiInfo());
	      
	}
	
	
}
