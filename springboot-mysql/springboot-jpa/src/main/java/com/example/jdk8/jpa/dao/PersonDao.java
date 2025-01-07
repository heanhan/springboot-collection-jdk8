package com.example.jdk8.jpa.dao;


import com.example.jdk8.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:14
 */

@Repository
public interface PersonDao extends JpaRepository<Person,Long>, JpaSpecificationExecutor<Person> {
}
