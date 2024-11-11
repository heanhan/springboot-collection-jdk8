package com.example.jdk8.sharding.controller;


import com.example.jdk8.result.ResultBody;
import com.example.jdk8.sharding.entity.Course;
import com.example.jdk8.sharding.mapper.CourseMapper;
import com.example.jdk8.sharding.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description TODO
 * @version 1.0
 * @author zhaojh
 * @date 2024/11/5 上午9:40
 */
@Slf4j
@RequestMapping("/insert")
@RestController
public class InsertDataController {

    @Resource
    private CourseService courseService;

    @GetMapping(value = "/insertDataCourse")
    public ResultBody insertDataCourse(){
        try {
            for (int i = 1; i < 21; i++) {
                Course c = new Course();
                c.setCid(Long.valueOf(i+""));
                c.setCname("java");
                c.setUserId(1001L+Long.valueOf(i+""));
                c.setCstatus("1");
                courseService.save(c);
            }
        }catch (Exception e){
            log.error("异常信息：{}",e.getMessage());
        }
        return ResultBody.success();
    }
}
