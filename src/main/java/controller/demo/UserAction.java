package controller.demo;

import entity.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
    @RequestMapping("/pharaoh")
    @ResponseBody
    public User demo(){
        User user = new User("123123","Pharaoh");
        return  user;
    }
}
