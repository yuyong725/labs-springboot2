package cn.javadog.labs.springboot2.springmvc.core.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 余勇
 * @date 2020-01-06 12:30
 * 注解形式的 Servlet
 */
@WebServlet(urlPatterns = "/test/02")
public class TestServlet02 extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("[doGet][uri: {}]", req.getRequestURI());
    }

}
