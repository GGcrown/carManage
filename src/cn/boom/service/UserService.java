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
 * @ClassName UserService
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:49:23 PM
 */
public interface UserService {
	
	public User findUser(String userName);

    public int addUser(User user);

    public int deleteUser(int userid);

    public User findUser(int userid);

    public int countUser();

    public int updateUser(User user);

    public List<User> findUserList(int page);
}
