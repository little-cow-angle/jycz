package gene.recombine.stuhubsys.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j整合Swagger3 Api接口文档配置类
 * @author Hva
 */
@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        // 标题
                        .title("基因重组-学生综合服务管理系统API文档")
                        // 描述Api接口文档的基本信息

                        .description("学生综合服务管理系统API文档")
                        // 版本
                        .version("v1.0.0")
                );
    }
}
 