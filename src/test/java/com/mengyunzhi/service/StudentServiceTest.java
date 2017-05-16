package com.mengyunzhi.service;

import com.mengyunzhi.repository.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by panjie on 17/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setName("hello");

        student = studentService.save(student);

        assertThat(student).isNotNull();
        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("hello");
    }

}