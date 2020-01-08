package cn.javadog.labs.springboot2.mybatis.tk.dataobject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-08 13:38
 * 用户 DO
 */
@Data
@Accessors(chain = true)
@Table(name = "mybatis_tk_users")
public class UserDO {

    /**
     * 用户编号
     * @Id 表示该字段为主键 ID
     * @GeneratedValue strategy 设置使用数据库主键自增策略；generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
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
