package cn.javadog.labs.springboot2.mybatis.xml.mapper;

import java.util.Collection;
import java.util.List;

import cn.javadog.labs.springboot2.mybatis.xml.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-08 11:44
 * mapper
 */
@Repository
public interface UserMapper {

    int insert(UserDO user);

    int updateById(UserDO user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

}
