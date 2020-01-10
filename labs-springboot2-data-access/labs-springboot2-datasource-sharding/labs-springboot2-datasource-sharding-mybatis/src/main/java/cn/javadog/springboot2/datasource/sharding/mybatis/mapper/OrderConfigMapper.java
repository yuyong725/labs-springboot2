package cn.javadog.springboot2.datasource.sharding.mybatis.mapper;

import cn.javadog.springboot2.datasource.sharding.mybatis.dataobject.OrderConfigDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 23:41
 */
@Repository
public interface OrderConfigMapper {

    OrderConfigDO selectById(@Param("id") Integer id);

}
