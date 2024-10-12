package com.example.jdk8.mdc.task;

import lombok.NonNull;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.util.ObjectUtils;
import java.util.Map;


/**
 * @author zhaojh
 * @description: 任务
 * @date 2024-10-12
 */

public class MDCTaskDecorator implements TaskDecorator {
    @Override
    public @NonNull Runnable decorate(@NonNull Runnable runnable) {
        // 此时获取的是父线程的上下文数据
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                if (!ObjectUtils.isEmpty(contextMap)) {
                    MDC.setContextMap(contextMap);
                }
                runnable.run();
            } finally {
                // 清除子线程的，避免内存溢出，就和ThreadLocal.remove()一个原因
                MDC.clear();
            }
        };
    }
}
