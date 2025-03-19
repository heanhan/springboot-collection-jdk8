package com.example.jdk8.powerjob.jobs;


/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/3/19 上午10:41
 */

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

/**
 * @author zhaojh
 * @Description 简单任务执行器 重要的是继承 BasicProcessor的接口
 * @date 2025-3-18
 */
@Slf4j
@Component
public class SimpleJobServer implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext taskContext) {
        String jobParams = taskContext.getJobParams();
        log.info("参数: " + jobParams);
        log.info("定时任务执行");
        return new ProcessResult(true, "定时任务执行成功");
    }
}
