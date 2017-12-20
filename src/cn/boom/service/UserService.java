/**
 * @Title UserService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:49:23 PM
 */
package cn.boom.service;

import cn.boom.pojo.User;

import java.util.List;

/**
 * @author crown
 * @ClassName UserService
 * @Description 用户服务层
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:49:23 PM
 */
public interface UserService {
    /**
     * 通过用户名查找用户
     *
     * @param userName 用户名
     * @return
     */
    User findUser(String userName);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return
     */
    int addUser(User user);

    /**
     * 通过用户id删除用户
     *
     * @param userid 用户id
     * @return
     */
    int deleteUser(int userid);

    /**
     * 通过用户id茶盏用户
     *
     * @param userid 用户id
     * @return
     */
    User findUser(int userid);

    /**
     * 计数用户
     *
     * @return
     */
    int countUser();

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查找
     *
     * @param page 页数
     * @return
     */
    List<User> findUserList(int page);
}
