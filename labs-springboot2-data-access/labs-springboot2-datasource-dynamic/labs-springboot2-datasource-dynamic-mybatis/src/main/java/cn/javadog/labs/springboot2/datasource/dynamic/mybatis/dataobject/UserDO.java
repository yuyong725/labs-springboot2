package cn.javadog.labs.springboot2.datasource.dynamic.mybatis.dataobject;

import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 19:33
 * 用户 dataobject
 */
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

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

}
