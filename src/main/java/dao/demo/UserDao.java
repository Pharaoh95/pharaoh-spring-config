package dao.demo;

import entity.demo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDao {
    @Resource(name = "mysqlJdbcTemplate")
    private JdbcTemplate template;

    public List<User> findAllUsers() {
        List<User> users = template.query("SELECT * FROM t_user",
                new BeanPropertyRowMapper<>(User.class));
        return users;
    }

}
