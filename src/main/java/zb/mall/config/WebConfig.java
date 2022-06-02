package zb.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 本地文件上传路径 */
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:D:\\\\upload/");
    }
}
