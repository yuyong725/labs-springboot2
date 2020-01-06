package cn.javadog.labs.springboot.dubbo.xml.api;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import cn.javadog.labs.springboot.dubbo.xml.dto.UserAddDTO;
import cn.javadog.labs.springboot.dubbo.xml.dto.UserDTO;

/**
 * @author 余勇
 * @date 2020-01-06 19:54
 * 用户服务 RPC Service 接口
 */
public interface UserRpcService {

    String ERROR_NAME = "handsome";

    /**
     * 根据指定用户编号，获得用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    UserDTO get(@NotNull(message = "用户编号不能为空") Integer id) throws ConstraintViolationException;

    /**
     * 添加新用户，返回新添加的用户编号
     *
     * @param addDTO 添加的用户信息
     * @return 用户编号
     */
    Integer add(UserAddDTO addDTO) throws ConstraintViolationException;

}
