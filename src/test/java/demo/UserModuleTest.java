package demo;

import dao.demo.UserDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//两个加载spring上下文所需的注解
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserModuleTest {

    private final Logger LOGGER = LogManager.getLogger(UserModuleTest.class);
    @Autowired
    private BeanFactory factory;

    @Test
    public void testUserDao() {
        UserDao userDao = factory.getBean(UserDao.class);
        LOGGER.info(userDao.findUserById("123123"));
    }
}
