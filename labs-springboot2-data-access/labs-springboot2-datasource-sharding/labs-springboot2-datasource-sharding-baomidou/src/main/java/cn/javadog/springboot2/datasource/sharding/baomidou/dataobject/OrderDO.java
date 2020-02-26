package cn.javadog.springboot2.datasource.sharding.baomidou.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 余勇
 * @date 2020-01-11 00:04
 * 订单 dataobject
 */
@Data
@Accessors(chain = true)
@TableName(value = "dynamic_datasource_orders")
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
