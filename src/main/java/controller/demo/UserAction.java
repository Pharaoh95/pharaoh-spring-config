package controller.demo;

import dao.demo.UserDao;
import entity.common.BaseResult;
import entity.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/pharaoh")
    @ResponseBody
    public BaseResult showMe() {
        BaseResult brs = new BaseResult();
        User me = new User("123123", "Pharaoh");
        brs.setData(me);
        return brs;
    }

    @RequestMapping("/all")
    @ResponseBody
    public BaseResult getAll() {
        BaseResult brs = new BaseResult();
        brs.setData(userDao.findAllUsers());
        return brs;
    }
}
