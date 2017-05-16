package com.mengyunzhi.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by panjie on 17/5/15.
 */
@Entity
@ApiModel("Student 学生实体")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("是否又学位")
    private boolean doubleDegree = false;

    @ApiModelProperty("是否班干部")
    private boolean classCadre = false;

    @ApiModelProperty("是否社团干部")
    private boolean communityCadre = false;

    public Student() {
    }

    public Student(String name, String phone, String email, String sex, String grade, String major, boolean doubleDegree, boolean classCadre, boolean communityCadre) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.grade = grade;
        this.major = major;
        this.doubleDegree = doubleDegree;
        this.classCadre = classCadre;
        this.communityCadre = communityCadre;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", doubleDegree=" + doubleDegree +
                ", classCadre=" + classCadre +
                ", communityCadre=" + communityCadre +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isDoubleDegree() {
        return doubleDegree;
    }

    public void setDoubleDegree(boolean doubleDegree) {
        this.doubleDegree = doubleDegree;
    }

    public boolean isClassCadre() {
        return classCadre;
    }

    public void setClassCadre(boolean classCadre) {
        this.classCadre = classCadre;
    }

    public boolean isCommunityCadre() {
        return communityCadre;
    }

    public void setCommunityCadre(boolean communityCadre) {
        this.communityCadre = communityCadre;
    }
}
