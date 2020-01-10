package cn.javadog.labs.springboot2.datasource.dynamic.mybatis.mapper.orders;

import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 19:33
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

}
