package cn.javadog.labs.springboot2.springmvc.controller2;

import java.util.UUID;

import cn.javadog.labs.springboot2.springmvc.core.web.GlobalResponseBodyHandler;
import cn.javadog.labs.springboot2.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余勇
 * @date 2020-01-06 13:55
 * 这个类的目的，主要是为了测试 {@link GlobalResponseBodyHandler} ，不拦截处理这个包
 */
@RestController
@RequestMapping("/test")
//@CrossOrigin(origins = "*", allowCredentials = "true") // 允许所有来源，允许发送 Cookie
public class TestController {

    /**
     * 获得指定用户编号的用户
     *
     * @return 用户
     */
    @GetMapping("/get")
//    @CrossOrigin(allowCredentials = "false") // 允许所有来源，不允许发送 Cookie
    public UserVO get() {
        return new UserVO().setId(1).setUsername(UUID.randomUUID().toString());
    }

}
