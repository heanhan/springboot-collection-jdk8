package com.example.jdk8.jpa.service;


import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.dto.PersonDto;
import com.example.jdk8.jpa.model.vo.PersonConditionVo;
import com.example.jdk8.jpa.model.vo.PersonPageVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:13
 */
public interface PersonService {

    /**
     * @description: 动态条件分页查询用户信息
     * @date: 2025/1/13
 * @param: personPageVo
     **/
    Page<Person> findAllPersonByPage(PersonPageVo personPageVo);

    /**
     * @description: 动态条件查询用户信息 列表
     * @date: 2025/1/13
     * @param: vo
     **/
    List<PersonDto> findAllPersonByCondition(PersonConditionVo vo);
}
