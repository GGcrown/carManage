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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author crown
 * @ClassName UserController
 * @Description 用户控制层
 * @email 1084961504@qq.com
 * @date Oct 23, 2017 1:48:43 PM
 */
@RequestMapping("/user")
@Controller
public class UserController {

    // 用户控制层
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param session 会话
     * @param user    用户
     * @return
     */
    @RequestMapping("/userlogin")
    public String userlogin(HttpSession session, User user) {
        boolean flag = this.checkUser(user);
        if (flag) {
            User findUser = userService.findUser(user.getUsername());
            if (user.getPassword().equals(findUser.getPassword())) {
                session.setAttribute("currentUser", findUser);
                return "redirect:/jsp/index.jsp";
            }
        }
        return "login";
    }

    /**
     * 添加用户ajax
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUserAjax")
    @ResponseBody
    public int addUserAjax(@RequestBody User user) {
        //验证用户数据
        System.out.println(user);
        if (checkUserData(user)) {
            int result = userService.addUser(user);
            return result;
        }
        return 0;
    }

    /**
     * 通过id删除用户ajax
     *
     * @param userid 用户id
     * @return
     */
    @RequestMapping("/deleteUserByIdAjax")
    @ResponseBody
    public int deleteUserAjax(int userid) {
        //验证id
        if (checkUserId(userid)) {
            return userService.deleteUser(userid);
        }
        return 0;
    }

    /**
     * 通过用户id更新用户
     *
     * @param user 用户
     * @return
     */
    @RequestMapping("/updateUserAjax")
    @ResponseBody
    public int updateUserAjax(@RequestBody User user) {
        //验证用户数据
        if (checkUserId(user.getUserid())) {
            return userService.updateUser(user);
        }
        return 0;
    }

    /**
     * 分页查询用户列表ajax
     *
     * @param page 页数
     * @return
     */
    @RequestMapping("/findUserListAjax")
    @ResponseBody
    public UserVo findUserListAjax(int page) {
        List<User> users = userService.findUserList(page);
        UserVo userVo = new UserVo();
        userVo.setUsers(users);
        return userVo;
    }

    /**
     * 通过用户id查询用户ajax
     *
     * @param userid 用户id
     * @return
     */
    @RequestMapping("/findUserByIdAjax")
    @ResponseBody
    public UserVo findUserByIdAjax(int userid) {
        //验证id
        if (checkUserId(userid)) {
            User user = userService.findUser(userid);
            UserVo userVo = new UserVo();
            userVo.setUser(user);
            return userVo;
        }
        return null;
    }

    /**
     * 通过用户页数
     *
     * @return
     */
    @RequestMapping("/countUserAjax")
    @ResponseBody
    public UserVo countUserAjax() {
        int count = userService.countUser();
        UserVo userVo = new UserVo();
        userVo.setPageSum(count);
        return userVo;

    }

    /**
     * 用户注销
     *
     * @param session 会话
     * @return
     */
    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session) {
        session.removeAttribute("currentUser");
        return "login";
    }


    /**
     * 验证用户数据有效性
     *
     * @param user  用户
     * @return True:数据有效    False:数据无效
     */
    private boolean checkUserData(User user) {
        //判断是否为空
        if (user == null || user.getUsername() == null || user.getPassword() == null
                || user.getUsertype() == null) {
            return false;
        }
        //判断是否为空字符串
        return !"".equals(user.getUsername()) && !"".equals(user.getPassword()) && !"".equals(user.getUsertype());
    }

    /**
     * 验证用户id有效性
     *
     * @param userId   用户id
     * @return True:数据有效    False:数据无效
     */
    private boolean checkUserId(int userId) {
        return userId >= 1;
    }

    /**
     * 验证用户有效性
     *
     * @param user 用户
     * @return True:数据有效    False:数据无效
     */
    private boolean checkUser(User user) {
        boolean flag = false;
        if (null != user) {
            String username = user.getUsername();
            String password = user.getPassword();
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                flag = true;
            }
        }
        return flag;
    }


}
