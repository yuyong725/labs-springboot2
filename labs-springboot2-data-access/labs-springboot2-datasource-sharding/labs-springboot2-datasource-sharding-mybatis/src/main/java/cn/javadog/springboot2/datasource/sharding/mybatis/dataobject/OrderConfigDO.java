package cn.javadog.springboot2.datasource.sharding.mybatis.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 余勇
 * @date 2020-01-10 23:39
 * 订单配置 dataobject
 */
@Data
@Accessors(chain = true)
public class OrderConfigDO {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 支付超时时间
     *
     * 单位：分钟
     */
    private Integer payTimeout;

}
