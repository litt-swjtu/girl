package com.swjtu.girl.controller;

import com.swjtu.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李天峒
 * @date 2019/1/20 15:58
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        // return cupSize+age;
        //return girlProperties.getCupSize();

        return "id:" + id;
    }
}
