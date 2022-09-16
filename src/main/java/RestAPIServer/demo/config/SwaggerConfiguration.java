package RestAPIServer.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* https://springdoc.org/#properties */
/**
 * @author 최별규
 * @date 2022.09.16
 * @version 1.1 API 명세를 위한 스웨커 셋팅
 * => 스웨거 메인
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        Info info = new Info().title("Demo API").version(appVersion)
                .description("테스트를 위한 API 명세 입니다.")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("choi").url("urlurl").email("me@email"))
                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
