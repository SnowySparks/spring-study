package study.filter_interface.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.filter_interface.intercepter.OpenApiInterceptor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

//    private final OpenApiInterceptor openApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(openApiInterceptor)
//                .addPathPatterns("/**") // 모든 주소를 맵핑한다.
//                .excludePathPatterns("/static/**"); // 그 중 일부 제외하고 싶다
    }

}
