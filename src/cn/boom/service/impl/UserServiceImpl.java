/**  
 * @Title UserServiceImpl.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:49:39 PM
 */
package cn.boom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.boom.dao.UserMapper;
import cn.boom.pojo.User;
import cn.boom.pojo.UserExample;
import cn.boom.pojo.UserExample.Criteria;
import cn.boom.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:49:39 PM
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @Description 通过用户名查找用户
	 * @return
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

	
	
	

}
