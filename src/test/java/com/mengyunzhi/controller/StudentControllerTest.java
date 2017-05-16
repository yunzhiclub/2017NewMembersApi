package com.mengyunzhi.controller;

import com.mengyunzhi.repository.Student;
import com.mengyunzhi.repository.StudentRepository;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.assertj.core.api.*;

import static org.hamcrest.Matchers.empty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.assertj.core.api.Assertions.*;
/**
 * Created by panjie on 17/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/asciidoc/snippets")
@Transactional
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "张三");
        jsonObject.put("sex", "男");
        jsonObject.put("email", "hello@yunzhiclub.com");
        jsonObject.put("phone", "1399999999");
        jsonObject.put("grade", "大一");
        jsonObject.put("major", "计算机科学与技术");
        jsonObject.put("doubleDegree", false);
        jsonObject.put("classCadre", true);
        jsonObject.put("communityCadre", true);

        this.mockMvc.perform(post("/Student/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("Student_save", preprocessResponse(prettyPrint())));
    }

    @Test
    public void getByNumber() throws Exception {
        // 数据不存在时返回值为空
        String content = this.mockMvc.perform(get("/Student/getByNumber/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(content).isEmpty();

        // 数据存在时返回实体。并且实体的学号符合期望
        Student student = new Student();
        student.setNumber("123");
        studentRepository.save(student);

        this.mockMvc.perform(get("/Student/getByNumber/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number", is("123")))
        .andDo(document("Student_getByNumber", preprocessResponse(prettyPrint())));
    }

}