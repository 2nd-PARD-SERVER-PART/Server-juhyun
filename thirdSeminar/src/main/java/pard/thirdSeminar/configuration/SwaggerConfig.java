package pard.thirdSeminar.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //@Autowired같은거는 스프링이 bean을 가져다 사용하지만, configure할때는 우리가 bean 가져다 사용함
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("swagger 첫 사용")
                .description("hi")
                .version("1.0.0");
    }

//    private Info apiInfo{
//        return new Info()
//                .title("Swagger 첫 사용")
//                .description("하이")
//                .version("1.0.0");
//    }
}
