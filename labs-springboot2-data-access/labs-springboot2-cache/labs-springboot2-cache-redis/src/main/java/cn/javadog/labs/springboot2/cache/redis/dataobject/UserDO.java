package cn.javadog.labs.springboot2.cache.redis.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-08 21:24
 * 用户 dataobject
 * 必须实现 Serializable 接口
 */
@Data
@Accessors(chain = true)
public class UserDO implements Serializable {

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

    /**
     * 是否删除
     */
    private Integer deleted;

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }

}
