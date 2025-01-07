package com.example.jdk8.jpa.controller;


import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.vo.PersonPageVo;
import com.example.jdk8.jpa.service.PersonService;
import com.example.jdk8.result.ResultBody;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:15
 */

@RequestMapping("/person")
@RestController
public class PersonController {

    @Resource
    private PersonService personServiceImpl;

    @PostMapping(value = "/findAllPersonByPage")
    public ResultBody<Page<Person>> findAllPersonByPage(@RequestBody PersonPageVo personPageVo){
        Page<Person> reuslt = personServiceImpl.findAllPersonByPage(personPageVo);
        return ResultBody.success(reuslt);
    }



}
