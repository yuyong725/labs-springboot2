package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.mapper;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 21:49
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

}
