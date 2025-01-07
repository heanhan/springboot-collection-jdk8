package com.example.jdk8.jpa.service;


import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.vo.PersonPageVo;
import org.springframework.data.domain.Page;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:13
 */
public interface PersonService {

    /**
     * 分页查询 多条件
     * @param personPageVo
     * @return
     */
    Page<Person> findAllPersonByPage(PersonPageVo personPageVo);
}
