package cn.boom.vo;

import cn.boom.pojo.User;

import java.util.List;

public class UserVo {

    private List<User> users;
    //分页数量
    private int pageSum;
    //用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }
}
