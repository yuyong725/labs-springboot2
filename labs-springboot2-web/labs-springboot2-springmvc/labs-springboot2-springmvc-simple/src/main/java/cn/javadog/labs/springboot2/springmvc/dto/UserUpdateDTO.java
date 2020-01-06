package cn.javadog.labs.springboot2.springmvc.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-05 22:43
 * 更新用户DTO
 */
@Data
@Accessors(chain = true)
public class UserUpdateDTO {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
