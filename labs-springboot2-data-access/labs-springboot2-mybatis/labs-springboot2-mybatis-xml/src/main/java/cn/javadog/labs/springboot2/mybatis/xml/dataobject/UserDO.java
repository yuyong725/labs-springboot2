package cn.javadog.labs.springboot2.mybatis.xml.dataobject;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-08 11:44
 * 用户 DO
 */
@Data
@Accessors(chain = true)
public class UserDO {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

}
