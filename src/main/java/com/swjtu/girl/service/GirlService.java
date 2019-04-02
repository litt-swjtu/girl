package com.swjtu.girl.service;

import com.swjtu.girl.Exception.GirlException;
import com.swjtu.girl.enums.ResultEnum;
import com.swjtu.girl.repository.GirlRepository;
import com.swjtu.girl.dao.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李天峒
 * @date 2019/1/20 23:55
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("FF");
        girlB.setAge(22);
        girlRepository.save(girlB);
    }

    /**
     * 获取年龄
     *
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception {
        Integer a = 12, b = 16;
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age <= a) {
            //你还在上小学吧 code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > a && age < b) {
            //你可能在上初中 code =101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 查询一条女生信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        Girl girl = girlRepository.findById(id).get();
        return girl;
    }
}
