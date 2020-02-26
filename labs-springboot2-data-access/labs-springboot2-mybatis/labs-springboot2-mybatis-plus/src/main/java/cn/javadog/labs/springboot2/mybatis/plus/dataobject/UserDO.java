package cn.javadog.labs.springboot2.mybatis.plus.dataobject;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 余勇
 * @date 2020-01-08 12:44
 * 用户 dataobject
 */
@Data
@Accessors(chain = true)
@TableName(value = "mybatis_plus_users")
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
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

}
