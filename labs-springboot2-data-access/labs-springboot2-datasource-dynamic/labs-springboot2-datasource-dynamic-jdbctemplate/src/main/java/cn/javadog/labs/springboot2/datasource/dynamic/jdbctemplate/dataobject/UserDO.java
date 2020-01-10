package cn.javadog.labs.springboot2.datasource.dynamic.jdbctemplate.dataobject;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 20:54
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

}
