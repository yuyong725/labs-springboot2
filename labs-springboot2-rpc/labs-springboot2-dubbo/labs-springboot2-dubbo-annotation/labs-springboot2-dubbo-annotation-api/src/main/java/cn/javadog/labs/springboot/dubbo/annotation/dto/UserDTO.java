package cn.javadog.labs.springboot.dubbo.annotation.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-06 22:11
 * 用户信息 DTO
 */
@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

}
