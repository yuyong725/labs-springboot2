package cn.javadog.labs.springboot.dubbo.annotation.service;

import cn.javadog.labs.springboot.dubbo.annotation.api.UserRpcService;
import cn.javadog.labs.springboot.dubbo.annotation.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "${dubbo.provider.UserRpcService.version}")
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO().setId(id)
                .setName("没有昵称：" + id)
                // 1 - 男；2 - 女
                .setGender(id % 2 + 1);
    }

}
