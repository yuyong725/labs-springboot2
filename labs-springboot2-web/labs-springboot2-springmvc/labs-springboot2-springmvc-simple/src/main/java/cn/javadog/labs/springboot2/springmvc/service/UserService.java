package cn.javadog.labs.springboot2.springmvc.service;

import cn.javadog.labs.springboot2.springmvc.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author 余勇
 * @date 2020-01-05 22:46
 * 用户服务
 */
@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }

}
