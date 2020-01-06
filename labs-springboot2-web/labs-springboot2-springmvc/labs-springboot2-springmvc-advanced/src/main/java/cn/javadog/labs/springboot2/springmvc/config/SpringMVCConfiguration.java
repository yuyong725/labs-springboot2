package cn.javadog.labs.springboot2.springmvc.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cn.javadog.labs.springboot2.springmvc.core.interceptor.FirstInterceptor;
import cn.javadog.labs.springboot2.springmvc.core.interceptor.SecondInterceptor;
import cn.javadog.labs.springboot2.springmvc.core.interceptor.ThirdInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @author 余勇
 * @date 2020-01-05 23:44
 * mvc 配置
 */
@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器一
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");
        // 拦截器二
        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/users/current_user");
        // 拦截器三
        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public ServletRegistrationBean testServlet01() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>(new HttpServlet() {

            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                logger.info("[doGet][uri: {}]", req.getRequestURI());
            }

        });
        servletRegistrationBean.setUrlMappings(Collections.singleton("/test/01"));
        return servletRegistrationBean;
    }

    /**
     * 这个添加进去的EnhancerBySpringCGLIB最终是一个代理类
     */
    @Bean
    public FilterRegistrationBean testFilter01() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>(new Filter() {

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                logger.info("[doFilter]");
                filterChain.doFilter(servletRequest, servletResponse);
            }

        });
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/test/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<?> testListener01() {
        return new ServletListenerRegistrationBean<>(new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("[contextInitialized]");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {

            }

        });
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 添加全局的 CORS 配置
//        registry.addMapping("/**") // 匹配所有 URL ，相当于全局配置
//                .allowedOrigins("*") // 允许所有请求来源
//                .allowCredentials(true) // 允许发送 Cookie
//                .allowedMethods("*") // 允许所有请求 Method
//                .allowedHeaders("*") // 允许所有请求 Header
////                .exposedHeaders("*") // 允许所有响应 Header
//                .maxAge(1800L); // 有效期 1800 秒，2 小时
//    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // 创建 UrlBasedCorsConfigurationSource 配置源，类似 CorsRegistry 注册表
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 创建 CorsConfiguration 配置，相当于 CorsRegistration 注册信息
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有请求来源
        config.setAllowedOrigins(Collections.singletonList("*"));
        // 允许发送 Cookie
        config.setAllowCredentials(true);
        // 允许所有请求 Method
        config.addAllowedMethod("*");
        // 允许所有请求 Header
        config.setAllowedHeaders(Collections.singletonList("*"));
//        config.setExposedHeaders(Collections.singletonList("*")); // 允许所有响应 Header
        // 有效期 1800 秒，2 小时
        config.setMaxAge(1800L);
        source.registerCorsConfiguration("/**", config);
        // 创建 FilterRegistrationBean 对象, 创建 CorsFilter 过滤器
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        // 设置 order 排序。这个顺序很重要哦，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 增加 XML 消息转换器
//        Jackson2ObjectMapperBuilder xmlBuilder = Jackson2ObjectMapperBuilder.xml();
//        xmlBuilder.indentOutput(true);
//        converters.add(new MappingJackson2XmlHttpMessageConverter(xmlBuilder.build()));
//    }



    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /// 希望 xml 和 json 同时生效，就在一个方法里面设置

        // 创建 FastJsonHttpMessageConverter 对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 自定义 FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 设置字符集
        fastJsonConfig.setCharset(Charset.defaultCharset());
        // 剔除循环引用
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        // 设置支持的 MediaType
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_JSON_UTF8));
        // 添加到 converters 中，注意，添加到最开头，放在 MappingJackson2XmlHttpMessageConverter 前面
        converters.add(0, fastJsonHttpMessageConverter);
    }

}
