/**
 * @Title UserController.java
 * @Package cn.boom.controller
 * @Description TODO
 * @author crown
 * @date Oct 23, 2017 1:48:43 PM
 */
package cn.boom.controller;

import cn.boom.pojo.User;
import cn.boom.service.UserService;
import cn.boom.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author crown
 * @ClassName UserController
 * @Description TODO
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

    @RequestMapping("/addUserAjax")
    @ResponseBody
    public int addUserAjax(@RequestBody User user) {
        boolean check = checkUserData(user);
        if (check) {
//            userService.addUser(user);
        }
        return 0;
    }

    @RequestMapping("/deleteUserByIdAjax")
    @ResponseBody
    public int deleteUserAjax(int userid) {
        return 0;
    }


    @RequestMapping("/updateUserAjax")
    @ResponseBody
    public int updateUserAjax(@RequestBody User user) {
        boolean check = checkUserData(user);
        if (check) {
            //TODO
        }
        return 0;
    }

    @RequestMapping("findUserByIdAjax")
    @ResponseBody
    public User findUserByIdAjax(int userid) {
        return null;
    }

    @RequestMapping("/countUserAjax")
    @ResponseBody
    public UserVo countUserAjax() {
        return null;
    }


    /**
     * 验证用户数据有效性
     *
     * @param user
     * @return True:数据有效    False:数据无效
     */
    public boolean checkUserData(User user) {
        //判断是否为空
        if (user == null || user.getUserid() == null || user.getUsername() == null || user.getPassword() == null
                || user.getUsertype() == null) {
            return false;
        }
        //判断是否为空字符串
        if ("".equals(user.getUserid()) || "".equals(user.getUsername()) || "".equals(user.getPassword())
                || "".equals(user.getUsertype())) {
            return false;
        }
        return true;
    }

    /**
     * 验证用户数据有效性
     *
     * @param userId
     * @return True:数据有效    False:数据无效
     */
    public boolean checkUserId(int userId) {
        if (userId < 1) {
            return false;
        }
        if (true) {

        }
        return true;
    }

}
