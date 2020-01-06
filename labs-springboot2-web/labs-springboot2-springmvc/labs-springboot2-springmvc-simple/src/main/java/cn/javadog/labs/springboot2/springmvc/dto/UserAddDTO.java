package cn.javadog.labs.springboot2.springmvc.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-05 22:41
 * 用户添加 DTO
 */
@Data
@Accessors(chain = true)
public class UserAddDTO {

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
