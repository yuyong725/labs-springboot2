package cn.javadog.labs.springboot2.springmvc.core.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 余勇
 * @date 2020-01-06 12:30
 * 注解形式的过滤器
 */
@WebFilter("/test/*")
public class TestFilter02 implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("[doFilter]");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
