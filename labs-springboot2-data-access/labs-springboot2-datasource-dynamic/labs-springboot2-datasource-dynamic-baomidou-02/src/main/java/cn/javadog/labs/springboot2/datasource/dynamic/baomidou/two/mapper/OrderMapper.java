package cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.mapper;

import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.constant.DBConstants;
import cn.javadog.labs.springboot2.datasource.dynamic.baomidou.two.dataobject.OrderDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * @author 余勇
 * @date 2020-01-10 17:57
 */
@Repository
public interface OrderMapper {

    @DS(DBConstants.DATASOURCE_SLAVE)
    OrderDO selectById(@Param("id") Integer id);

    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(OrderDO entity);

    OrderDO selectByUserId(@Param("userId") Integer userId);
}
