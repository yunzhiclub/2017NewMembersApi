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
@ApiModel("学生实体")
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
    private boolean isDoubleDegree = false;

    @ApiModelProperty("是否班干部")
    private boolean isClassCadre = false;

    @ApiModelProperty("是否社团干部")
    private boolean isCommunityCadre = false;

    public Student() {
    }

    public Student(String name, String phone, String email, String sex, String grade, String major, boolean isDoubleDegree, boolean isClassCadre, boolean isCommunityCadre) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.grade = grade;
        this.major = major;
        this.isDoubleDegree = isDoubleDegree;
        this.isClassCadre = isClassCadre;
        this.isCommunityCadre = isCommunityCadre;
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
                ", isDoubleDegree=" + isDoubleDegree +
                ", isClassCadre=" + isClassCadre +
                ", isCommunityCadre=" + isCommunityCadre +
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
        return isDoubleDegree;
    }

    public void setDoubleDegree(boolean doubleDegree) {
        isDoubleDegree = doubleDegree;
    }

    public boolean isClassCadre() {
        return isClassCadre;
    }

    public void setClassCadre(boolean classCadre) {
        isClassCadre = classCadre;
    }

    public boolean isCommunityCadre() {
        return isCommunityCadre;
    }

    public void setCommunityCadre(boolean communityCadre) {
        isCommunityCadre = communityCadre;
    }
}
