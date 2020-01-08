package cn.javadog.labs.springboot2.mybatis.tk.mapper;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.javadog.labs.springboot2.mybatis.tk.dataobject.UserDO;
import cn.javadog.labs.springboot2.mybatis.tk.util.IMapper;
import tk.mybatis.mapper.entity.Example;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 余勇
 * @date 2020-01-08 13:33
 */
@Repository
public interface UserMapper extends IMapper<UserDO> {

    default UserDO selectByUsername(@Param("username") String username) {
        Example example = new Example(UserDO.class);
        // 创建 Criteria 对象，设置 username 查询条件
        example.createCriteria().andEqualTo("username", username);
        // 执行查询
        return selectOneByExample(example);
    }

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

    default List<UserDO> selectListByCreateTime(@Param("createTime") Date createTime) {
        Example example = new Example(UserDO.class);
        // 创建 Criteria 对象，设置 create_time 查询条件
        example.createCriteria().andGreaterThan("createTime", createTime);
        return selectByExample(example);
    }

}
