package demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ConcurrentTest implements Runnable {

    private CountDownLatch cdl = new CountDownLatch(10);
    private final Logger LOGGER = LogManager.getLogger(ConcurrentTest.class);
    @Autowired
    private BeanFactory factory;

    @Test
    public void testCountDownLatch() throws InterruptedException {
        // test git link
        for (int i = 0; i < 10; i++) {
            new Thread(this).start();
        }

    }

    @Override
    public void run() {
        try {
            LOGGER.info("thread-id:" + Thread.currentThread().getId());
            cdl.countDown();
            cdl.await();
            LOGGER.info("concurrent code:" + Thread.currentThread().getId());
            // concurrent code area later

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
