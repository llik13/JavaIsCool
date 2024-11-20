package com.bigfood.review;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.servers.Server;



import java.util.List;


@Configuration
public class OpenAPIConfig {
    @Value("${server.port}")
    int port;
    @Bean
    public OpenAPI productServiceAPI(ServletContext servletContext) {
        var server = new Server().url("http://localhost:" + port);
        return new OpenAPI()
                .servers(List.of(server))
               .info(new Info().title("Review Service API")
               .description("This is the REST API for Review Service")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0")));
   }
}
