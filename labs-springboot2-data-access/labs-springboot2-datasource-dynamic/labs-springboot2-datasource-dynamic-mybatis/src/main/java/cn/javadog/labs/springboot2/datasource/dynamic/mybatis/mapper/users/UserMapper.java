package cn.javadog.labs.springboot2.datasource.dynamic.mybatis.mapper.users;

import cn.javadog.labs.springboot2.datasource.dynamic.mybatis.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-10 19:33
 */
@Repository
public interface UserMapper {

    UserDO selectById(@Param("id") Integer id);

}
