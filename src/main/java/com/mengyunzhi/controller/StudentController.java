package com.mengyunzhi.controller;

import com.mengyunzhi.repository.Student;
import com.mengyunzhi.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panjie on 17/5/15.
 */
@RestController
@Api(tags = "Student 学生", value = "学生")
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "save 保存学生信息", nickname = "Student_save")
    @PostMapping("/")
    public Student save(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @ApiOperation(value = "getByNumber 通过学号获取实体信息", nickname = "Student_getByNumber")
    @GetMapping("/getByNumber/{number}")
    public Student getByNumber(@ApiParam("学号") @PathVariable String number) {
        Student student = studentService.getByNumber(number);
        return student;
    }

}
