package com.example.jdk8.minio.es.dao;


import com.example.jdk8.minio.es.entity.FileTable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:46
 */

@Repository
public interface FileTableDao extends PagingAndSortingRepository<FileTable,Long> {
}
