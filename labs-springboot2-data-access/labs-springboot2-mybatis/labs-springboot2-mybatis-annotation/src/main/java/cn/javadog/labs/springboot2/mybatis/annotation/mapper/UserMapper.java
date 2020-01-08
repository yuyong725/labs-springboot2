package cn.javadog.labs.springboot2.mybatis.annotation.mapper;

import java.util.Collection;
import java.util.List;

import cn.javadog.labs.springboot2.mybatis.annotation.dataobject.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-08 12:13
 * mapper
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO mybatis_annotation_users(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(UserDO user);

    @Update(value = {
            "<script>",
            "UPDATE mybatis_annotation_users",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "</script>"
    })
    int updateById(UserDO user);

    @Insert("DELETE FROM mybatis_annotation_users WHERE id = #{id}")
    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    @Select("SELECT username, password, create_time FROM mybatis_annotation_users WHERE id = #{id}")
    UserDO selectById(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM mybatis_annotation_users WHERE username = #{username}")
    UserDO selectByUsername(@Param("username") String username);

    @Select(value = {
            "<script>",
            "SELECT username, password, create_time FROM mybatis_annotation_users",
            "WHERE id IN",
            "<foreach item='id' collection='ids' separator=',' open='(' close=')' index=''>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

}
