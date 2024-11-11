package com.example.jdk8.sharding.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jdk8.sharding.entity.Course;
import com.example.jdk8.sharding.mapper.CourseMapper;
import com.example.jdk8.sharding.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * @description 业务实现层
 * @version 1.0
 * @author zhaojh
 * @date 2024/11/4 下午6:20
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
