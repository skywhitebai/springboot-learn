package com.sky.girl.test;

import com.sky.girl.domain.Girl;
import com.sky.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService   girlService;

    @Test
    public void findOneTest(){
        Girl girl=girlService.finOne(1);
        Assert.assertEquals(new Integer(1),girl.getId());
    }
}
