package com.example.jdk8.jpa.dao;


import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.dto.PersonDto;
import com.example.jdk8.jpa.model.vo.PersonConditionVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:14
 */

@Repository
public interface PersonDao extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {


    @Query(value = " select p from Person p " +
            " where p.isDeleted = 0 " +
            " and if()")
    List<PersonDto> findAllPersonByCondition(@Param("vo") PersonConditionVo vo);
}
