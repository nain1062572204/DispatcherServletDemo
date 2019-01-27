package com.wang.entity;

import java.io.Serializable;

/**
 * @author Rose
 * @create 2019/1/26
 * @since 1.0.0
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -8551660658633523362L;
    private Integer stuId;
    private String stuName;
    private StuClass stuClass=new StuClass();//必须实例化，否则反射的时候报空指针异常

    public Student() {
    }

    public Student(Integer stuId, String stuName, StuClass stuClass) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuClass = stuClass;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}