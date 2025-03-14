package com.example.jdk8.jpa.service.impl;


import com.example.jdk8.jpa.dao.PersonDao;
import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.dto.PersonDto;
import com.example.jdk8.jpa.model.vo.PersonAddVo;
import com.example.jdk8.jpa.model.vo.PersonConditionVo;
import com.example.jdk8.jpa.model.vo.PersonPageVo;
import com.example.jdk8.jpa.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/7 下午12:13
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    /**
     * 分页查询 多条件
     * @param vo 参数
     * @return
     */
    @Override
    public Page<Person> findAllPersonByPage(PersonPageVo vo) {
//        PageRequest pageRequest = PageRequest.of(vo.getIndex() - 1, vo.getSize());
        PageRequest pageRequest = PageRequest.of(vo.getIndex() - 1, vo.getSize());
        Specification<Person> spec = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //创建一个 Predicate  添加封装集合
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(vo.getStartTime()) && StringUtils.hasText(vo.getEndTime())) {
                    Predicate between = cb.between(root.get("createdTime").as(String.class), vo.getStartTime(), vo.getEndTime());
                    predicates.add(between);
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Page<Person> all = personDao.findAll(spec, pageRequest);
        return all;
    }

    /**
     * @param vo
     * @description: 动态条件查询用户信息 列表
     * @date: 2025/1/13
     * @param: vo
     */
    @Override
    public List<PersonDto> findAllPersonByCondition(PersonConditionVo vo) {
        List<PersonDto> result = personDao.findAllPersonByCondition(vo);
        return result;
    }

    /**
     * @param vo
     * @description: 新增Person
     * @date: 2025/1/15
     * @param: vo
     */
    @Override
    public Boolean addPerson(PersonAddVo vo) {
        Person person = new Person();
        BeanUtils.copyProperties(vo, person);
        person.setCreatedTime(new Date());
        //可以同项目中实际的存储的登录用户中心获取如  ThreadLocal中，此处写死数据
        person.setCreatorId(100001L);
        person.setLastModifiedTime(new Date());
        person.setLastModifierId(100001L);
        person.setIsDeleted(0);//0：有效，1：无效
        Person save = personDao.save(person);
        if (ObjectUtils.isEmpty(save)) {
            return false;
        }
        return true;
    }
}
