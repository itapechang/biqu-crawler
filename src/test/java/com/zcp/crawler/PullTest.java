package com.zcp.crawler;

import com.zcp.crawler.schedule.CommonPuller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @create 2019/12/17
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PullTest {



    @Autowired
    @Qualifier("biQuPuller")
    private CommonPuller biQuPuller;


    @Test
    public void testBiQu(){
        biQuPuller.pullNews();
    }
}