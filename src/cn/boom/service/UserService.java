/**  
 * @Title UserService.java
 * @Package cn.boom.service
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:49:23 PM
 */
package cn.boom.service;

import cn.boom.pojo.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:49:23 PM
 */
public interface UserService {
	
	public User findUser(String userName);

}
