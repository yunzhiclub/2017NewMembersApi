package com.mengyunzhi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by panjie on 17/5/15.
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
    Student getByNumber(String number);
}
