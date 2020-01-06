package cn.javadog.labs.springboot2.springmvc.core.web;

import cn.javadog.labs.springboot2.springmvc.core.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 余勇
 * @date 2020-01-05 23:54
 * 统一全局返回
 *
 * 只拦截我们的 Controller 所在包，避免其它类似 swagger 提供的 API 被切面拦截
 */
@ControllerAdvice(basePackages = "cn.javadog.labs.springboot2.springmvc.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 返回 true 。表示拦截 Controller 所有 API 接口的返回结果
        return true;
    }

    /**
     * 当返回的结果不是 CommonResult 类型时，则包装成 CommonResult 类型
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (body instanceof CommonResult) {
            return body;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(body);
    }

}
