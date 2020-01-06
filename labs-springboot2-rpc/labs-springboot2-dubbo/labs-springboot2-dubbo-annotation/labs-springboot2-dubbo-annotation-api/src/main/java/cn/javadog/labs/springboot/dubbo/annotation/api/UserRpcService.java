package cn.javadog.labs.springboot.dubbo.annotation.api;


import cn.javadog.labs.springboot.dubbo.annotation.dto.UserDTO;

/**
 * @author 余勇
 * @date 2020-01-06 22:11
 * 用户服务 RPC Service 接口
 */
public interface UserRpcService {

    /**
     * 根据指定用户编号，获得用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    UserDTO get(Integer id);

}
