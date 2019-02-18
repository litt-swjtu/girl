package com.swjtu.girl.service;

import com.swjtu.girl.dao.Girl;
import org.assertj.core.api.IntArrayAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 李天峒
 * @date 2019/2/12 18:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(5);
        Assert.assertEquals(new Integer(13),girl.getAge());
    }
}