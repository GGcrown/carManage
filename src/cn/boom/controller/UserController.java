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

import java.util.List;

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
        //验证用户数据
        if (checkUserData(user)) {
            int reuslt=userService.addUser(user);
        }


        return 0;
    }

    @RequestMapping("/deleteUserByIdAjax")
    @ResponseBody
    public int deleteUserAjax(int userid) {
        //验证id
        if(checkUserId(userid)){
            int result=userService.deleteUser(userid);
        }
        return 0;
    }


    @RequestMapping("/updateUserAjax")
    @ResponseBody
    public int updateUserAjax(@RequestBody User user) {
        //验证用户数据
        if (checkUserData(user)) {
            int result=userService.updateUser(user);
        }
        return 0;
    }

    @RequestMapping("/findUserListAjax")
    public List<User> findUserListAjax(int page){
        List<User> users= userService.findUserList(page);
        return users;
    }

    @RequestMapping("/findUserByIdAjax")
    @ResponseBody
    public User findUserByIdAjax(int userid) {
        //验证id
        if(checkUserId(userid)){
            User user=userService.findUser(userid);
        }
        return null;
    }

    @RequestMapping("/countUserAjax")
    @ResponseBody
    public UserVo countUserAjax() {
        int count=userService.countUser();
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
        return !"".equals(user.getUserid()) && !"".equals(user.getUsername()) && !"".equals(user.getPassword())
                && !"".equals(user.getUsertype());
    }

    /**
     * 验证用户id有效性
     *
     * @param userId
     * @return True:数据有效    False:数据无效
     */
    public boolean checkUserId(int userId) {
        return userId >= 1;
    }

}
