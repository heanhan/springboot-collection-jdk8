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


    /**
     * @description: 返回自定义的实体类的实现方式
     * @date: 2025/1/13
     * @param: vo 动态条件
     **/
    @Query(value = " select p from Person p " +
            " where p.isDeleted = 0 " +
            " and (:#{#vo.id }  is null or p.id = :#{#vo.getId()})" +
            " and (:#{#vo.getUserName()} is null or p.userName like %:#{#vo.getUserName()}%) " +
            " and (:#{#vo.startTime }  is null or p.createdTime >= :#{#vo.startTime()})" +
            " and (:#{#vo.endTime }  is null or p.createdTime <= :#{#vo.endTime()})")
    List<PersonDto> findAllPersonByCondition(@Param("vo") PersonConditionVo vo);
}
