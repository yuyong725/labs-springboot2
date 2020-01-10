package cn.javadog.labs.springboot2.datasource.dynamic.baomidou.one.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 15:02
 * 订单 DO
 */
@Data
@Accessors(chain = true)
public class OrderDO {

    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    @Override
    public String toString() {
        return "OrderDO{" + "id=" + id + ", userId=" + userId + '}';
    }

}
