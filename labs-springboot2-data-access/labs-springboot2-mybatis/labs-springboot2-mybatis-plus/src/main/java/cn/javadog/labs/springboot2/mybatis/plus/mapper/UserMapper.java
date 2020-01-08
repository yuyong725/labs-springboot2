package cn.javadog.labs.springboot2.mybatis.plus.mapper;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import cn.javadog.labs.springboot2.mybatis.plus.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author 余勇
 * @date 2020-01-08 12:44
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    default UserDO selectByUsername(String username) {
        return selectOne(new QueryWrapper<UserDO>().eq("username", username));
    }

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

    default List<UserDO> selectByIdsWithWrapper(Collection<Integer> ids) {
        return selectList(new QueryWrapper<UserDO>().in("id", ids));
    }

    default IPage<UserDO> selectPageByCreateTime(IPage<UserDO> page, Date createTime) {
        return selectPage(page,
                new QueryWrapper<UserDO>().gt("create_time", createTime)
//                new QueryWrapper<UserDO>().like("username", "46683d9d")
        );
    }

}
