package cn.javadog.labs.springboot2.datasource.dynamic.jpa.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 20:15
 * 订单 dataobject
 */
@Accessors(chain = true)
@Entity
@Table(name = "dynamic_datasource_orders")
public class OrderDO {

    /**
     * 订单编号
     * strategy 设置使用数据库主键自增策略；
     * generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    @Override
    public String toString() {
        return "OrderDO{" + "id=" + id + ", userId=" + userId + '}';
    }

}
