package com.mengyunzhi.service;

import com.mengyunzhi.repository.Student;
import com.mengyunzhi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by panjie on 17/5/15.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        studentRepository.save(student);
        return student;
    }
}
