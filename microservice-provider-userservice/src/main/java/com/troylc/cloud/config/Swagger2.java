package com.troylc.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2016/12/1.
 */

@Configuration
@EnableSwagger2
public class Swagger2 {


    /**
     * 访问地址 http://ip:prot/swagger-ui.html
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())       //创建API基本信息
                .groupName("controller API")     //指定分组，对应(/v2/api-docs?group=)
                .pathMapping("")  //base地址，最终会拼接Controller中的地址
                .select()    //控制要暴露的接口
                .apis(RequestHandlerSelectors.basePackage("com.troylc.cloud.controller"))  //通过指定扫描包暴露接口
                .paths(PathSelectors.any())       //设置过滤规则暴露接口
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建用户RESTful APIs")
                .description("更多相关文章，请关注：http://www.troylc.cc/")
                .termsOfServiceUrl("http://www.troylc.cc")
                .contact("troylc")
                .version("1.0")
                .build();
    }
}
