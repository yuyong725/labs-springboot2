package cn.javadog.springboot2.datasource.sharding.baomidou.mapper;

import cn.javadog.springboot2.datasource.sharding.baomidou.dataobject.OrderDO;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author 余勇
 * @date 2020-01-11 00:05
 */
@Repository
public interface OrderMapper extends BaseMapper<OrderDO> {

}
