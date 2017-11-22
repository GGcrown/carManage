/**  
 * @Title UserController.java
 * @Package cn.boom.controller
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:48:43 PM
 */
package cn.boom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.boom.service.UserService;

/**
 * @ClassName UserController
 * @Description TODO
 * @author crown
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:48:43 PM
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * 用户登陆
	 */
	@RequestMapping("/userlogin")
	public String userlogin() {
		userService.findUser("pkq");
		return "NewFile";
	}

	/*
	 * 保险列表
	 */
	public String findinsuranceList(int page) {
		return null;
	}
}
