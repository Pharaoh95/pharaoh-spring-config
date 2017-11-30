package controller.demo;

import dao.demo.UserDao;
import entity.common.BaseResult;
import entity.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAction {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public BaseResult getOne(@PathVariable String id) {
        BaseResult brs = new BaseResult();
        User me = new User(id, "Pharaoh");
        brs.setData(me);
//        userDao.addUser(id, "Pharaoh");
        return brs;
    }
}
