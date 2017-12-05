package dao.demo;

import entity.demo.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public User findUserById(String id) {
        User user = template.query("SELECT * FROM t_user WHERE id = ?",
                new UserResultSetExtractor(), id);
        return user;
    }

    @Transactional
    public boolean addUser(String id, String name) {
        boolean rs = false;
        template.update("INSERT INTO t_user(id, NAME)VALUES(?, ?)", id, name);
//        int i = 1 / 0; // Transactional test
        return rs;
    }


    /**
     * 映射处理实现
     */
    private class UserResultSetExtractor implements ResultSetExtractor<User> {

        @Override
        public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            User user = null;
            // 唉，还是做了硬编码
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                user = new User(id, name);
            }
            return user;
        }
    }
}
