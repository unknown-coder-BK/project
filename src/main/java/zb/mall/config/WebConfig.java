package zb.mall.config;

import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zb.mall.interceptor.MallLoginValidateInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MallLoginValidateInterceptor())
                .excludePathPatterns("/common/captcha")
                .excludePathPatterns("/register")
                .excludePathPatterns("/js/**");
    }

}
