package com.example.jdk8.jpa.service.impl;


import com.example.jdk8.jpa.dao.PersonDao;
import com.example.jdk8.jpa.entity.Person;
import com.example.jdk8.jpa.model.vo.PersonPageVo;
import com.example.jdk8.jpa.service.PersonService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
        PageRequest pageRequest =PageRequest.of(vo.getIndex()-1,vo.getSize());
        Specification<Person> spec = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //创建一个 Predicate  添加封装集合
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.hasText(vo.getStartTime())&&StringUtils.hasText(vo.getEndTime())){
                    Predicate between = cb.between(root.get("createdTime").as(String.class), vo.getStartTime() ,vo.getEndTime() );
                    predicates.add(between);
                }

                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Page<Person> all = personDao.findAll(spec, pageRequest);
        return all;
    }
}
