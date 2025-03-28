package data.conversion.UnitConverter.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customInfo(){
        return new OpenAPI().info(new Info()
                .title("Unit Conversion App")
                .description("This application converts measurements from one format to other"));
    }
}
