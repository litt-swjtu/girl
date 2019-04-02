package com.swjtu.girl.controller;

import com.swjtu.girl.dao.Result;
import com.swjtu.girl.service.GirlService;
import com.swjtu.girl.repository.GirlRepository;
import com.swjtu.girl.dao.Girl;
import com.swjtu.girl.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 李天峒
 * @date 2019/1/20 18:37
 */
@CrossOrigin
@RestController
@Slf4j
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 返回女生信息列表
     *
     * @return List<girl>
     **/
    @GetMapping("/list")
    public List<Girl> girlList() {
        log.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加女生信息
     *
     * @param girl
     * @return girl
     */
    @PostMapping("/add")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找一条信息
     *
     * @param id
     * @return girl
     */
    @GetMapping("/one")
    public Girl girlFindOne(@RequestParam("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /**
     * 更新女生信息
     *
     * @param id
     * @param age
     * @param cupSize
     */
    @PutMapping("/update")
    public Girl girlUpdate(@RequestParam("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("age") String cupSize
    ) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return (girlRepository.save(girl));
    }

    /**
     * 删除女生信息
     *
     * @param id
     */
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄来查找女生信息
     *
     * @param age
     * @return list<girl>
     */
    @GetMapping("/age")
    public List<Girl> girlFindByAge(@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/addtwo")
    public void addTwo() {
        girlService.addTwo();
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}