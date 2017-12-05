package controller.demo.admin;

import dao.demo.UserDao;
import entity.common.BaseResult;
import entity.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUsersAction {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findUsers(String page, String rows) {
        return userDao.findAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public BaseResult findUserById(@PathVariable String id) {
        BaseResult rs = new BaseResult();
        User user = userDao.findUserById(id);
        rs.setData(user);
        if (user == null) {
            rs.setInfo("未查询到相关用户信息！");
        }
        return rs;
    }
}
