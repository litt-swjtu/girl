package com.swjtu.girl.repository;

import com.swjtu.girl.dao.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/1/20 18:37
 */
@Component
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄来查询
     */
    List<Girl> findByAge(Integer age);
}
