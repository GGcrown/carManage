package cn.boom.dao;

import cn.boom.pojo.User;
import cn.boom.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao接口
 */
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(int record);

    List<User> selectByPage(int page);

    User selectByUsername(String username);
}