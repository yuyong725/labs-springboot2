package cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.mapper;

import cn.javadog.labs.springboot2.datasource.dynamic.shardingjdbc.one.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 21:31
 */
@Repository
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);

}
