package com.mengyunzhi.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
/**
 * Created by panjie on 17/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/asciidoc/snippets")
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "张三");
        jsonObject.put("sex", "男");
        jsonObject.put("phone", "1399999999");
        jsonObject.put("grade", "大一");
        jsonObject.put("major", "计算机科学与技术");
        jsonObject.put("isDoubleDegree", false);
        jsonObject.put("isClassCadre", true);
        jsonObject.put("isCommunityCadre", true);

        this.mockMvc.perform(post("/Student/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString()))
                .andDo(print())
                .andExpect(status().isOk())
        .andDo(document("Student_save", preprocessResponse(prettyPrint())));
    }

}