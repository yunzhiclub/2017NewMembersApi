package com.mengyunzhi.controller;

import com.mengyunzhi.repository.Student;
import com.mengyunzhi.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panjie on 17/5/15.
 */
@RestController
@Api(tags = "学生", value = "Student")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "保存学生信息", nickname = "Student_save")
    @PostMapping("/")
    public Student save(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

}
