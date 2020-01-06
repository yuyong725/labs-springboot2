package cn.javadog.labs.springboot.dubbo.xml.service;


import cn.javadog.labs.springboot.dubbo.xml.api.UserRpcService;
import cn.javadog.labs.springboot.dubbo.xml.core.ServiceException;
import cn.javadog.labs.springboot.dubbo.xml.core.ServiceExceptionEnum;
import cn.javadog.labs.springboot.dubbo.xml.dto.UserAddDTO;
import cn.javadog.labs.springboot.dubbo.xml.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author 余勇
 * @date 2020-01-06 20:18
 * 服务实现类
 */
@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Override
    public UserDTO get(Integer id) {
        return new UserDTO()
                .setId(id)
                .setName("没有昵称：" + id)
                // 1 - 男；2 - 女
                .setGender(id % 2 + 1);
    }

    @Override
    public Integer add(UserAddDTO addDTO) {
        // 这里，模拟用户已经存在的情况
        if (ERROR_NAME.equals(addDTO.getName())) {
            throw new ServiceException(ServiceExceptionEnum.USER_EXISTS);
        }
        // 随便返回一个 id
        return (int) (System.currentTimeMillis() / 1000);
    }

}
