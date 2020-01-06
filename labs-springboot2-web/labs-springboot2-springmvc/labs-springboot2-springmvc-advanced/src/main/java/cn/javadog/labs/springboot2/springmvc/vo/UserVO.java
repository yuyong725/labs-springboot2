package cn.javadog.labs.springboot2.springmvc.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-06 00:31
 *
 * 用户 VO
 */
@Data
@Accessors(chain = true)
public class UserVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

}
