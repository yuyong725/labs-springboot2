package cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 20:17
 * 用户 DO
 */
@Accessors(chain = true)
@Entity
@Table(name = "dynamic_datasource_users")
public class UserDO {

    /**
     * 用户编号
     * strategy 设置使用数据库主键自增策略；
     * generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    /**
     * 账号
     */
    private String username;

    @Override
    public String toString() {
        return "UserDO{" + "id=" + id + ", username='" + username + '\'' + '}';
    }

}
