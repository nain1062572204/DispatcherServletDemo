package com.wang.entity;

import java.io.Serializable;

/**
 * @author Rose
 * @create 2019/1/26
 * @since 1.0.0
 */
public class StuClass implements Serializable{

    private static final long serialVersionUID = -8976666097146365353L;
    private Integer stuClassId;
    private String stuClassName;
    private Dept dept =new Dept();

    public StuClass() {
    }

    public StuClass(Integer stuClassId, String stuClassName, Dept dept) {
        this.stuClassId = stuClassId;
        this.stuClassName = stuClassName;
        this.dept = dept;
    }

    public Integer getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(Integer stuClassId) {
        this.stuClassId = stuClassId;
    }

    public String getStuClassName() {
        return stuClassName;
    }

    public void setStuClassName(String stuClassName) {
        this.stuClassName = stuClassName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "stuClassId=" + stuClassId +
                ", stuClassName='" + stuClassName + '\'' +
                '}';
    }
}