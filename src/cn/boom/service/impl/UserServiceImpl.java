/**
 * @Title UserServiceImpl.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:49:39 PM
 */
package cn.boom.service.impl;

import cn.boom.dao.UserMapper;
import cn.boom.pojo.User;
import cn.boom.pojo.UserExample;
import cn.boom.pojo.UserExample.Criteria;
import cn.boom.service.UserService;
import cn.boom.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crown
 * @ClassName UserServiceImpl
 * @Description TODO
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:49:39 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @return
     * @Description 通过用户名查找用户
     */
    @Override
    public User findUser(String userName) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
        return users.size() == 0 ? null : users.get(0);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return -1此用户名已存在 0添加失败 1添加成功
     */
    @Override
    public int addUser(User user) {
        User find = userMapper.selectByUsername(user.getUsername());
        if (find != null) {
            return -1;
        }
        //todo
        return userMapper.insertSelective(user);
    }

    /**
     * 删除用户
     *
     * @param userid
     * @return
     */
    @Override
    public int deleteUser(int userid) {
        User user = new User();
        List list = new ArrayList();
        user.setUserid(userid);
        user.setUsertype(3);//设置 3为已经删除用户
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 查找用户通过id
     *
     * @param userid
     * @return
     */
    @Override
    public User findUser(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    /**
     * 计算页数
     *
     * @return
     */
    @Override
    public int countUser() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsertypeNotEqualTo(3);
        int countUser = userMapper.countByExample(userExample);
        int page = countUser % Page.USER_PAGE == 0 ? countUser / Page.USER_PAGE : countUser / Page.USER_PAGE + 1;
        return page;
    }

    /**
     * 更新页数
     *
     * @param user
     * @return
     */

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> findUserList(int page) {
        return userMapper.selectByPage(page * Page.USER_PAGE);
    }

}
