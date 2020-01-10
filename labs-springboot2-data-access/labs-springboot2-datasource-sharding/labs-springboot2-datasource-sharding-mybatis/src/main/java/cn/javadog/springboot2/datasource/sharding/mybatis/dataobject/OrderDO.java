package cn.javadog.springboot2.datasource.sharding.mybatis.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 23:40
 * 订单 DO
 */
@Data
@Accessors(chain = true)
public class OrderDO {

    /**
     * 订单编号
     */
    private Long id;

    /**
     * 用户编号
     */
    private Integer userId;

}
