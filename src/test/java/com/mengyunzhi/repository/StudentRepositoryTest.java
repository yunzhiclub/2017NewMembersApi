package com.mengyunzhi.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by panjie on 17/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    private Student student;

    @Test
    public void getNewStudent() {
        student = new Student();
        studentRepository.save(student);
        return;
    }

    public Student getStudent() {
        if (null == student) {
            this.getNewStudent();
        }
        return student;
    }
}