package gene.recombine.stuhubsys.common.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 创建 CorsFilter Bean，解决跨域问题
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterBean() {
        // 创建 CorsConfiguration 对象
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // 设置访问源地址
        config.addAllowedHeader("*"); // 设置访问源请求头
        config.addAllowedMethod("*"); // 设置访问源请求方法
        // 创建 UrlBasedCorsConfigurationSource 对象
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 对接口配置跨域设置
        // 创建并返回 FilterRegistrationBean 对象
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(99999); // 设置过滤器顺序
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 直接实现 HandlerInterceptor 接口
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String requestURI = request.getRequestURI();
                if ("/favicon.ico".equals(requestURI)) {
                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    return false;
                }
                return true;
            }
            // 其他方法可以默认实现（不需要时留空即可）
            // 注意：接口方法必须全部实现，即使是空实现
        });
    }
}