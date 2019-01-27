package com.wang.entity;

import java.io.Serializable;

/**
 * @author Rose
 * @create 2019/1/26
 * @since 1.0.0
 */
public class Dept implements Serializable{

    private static final long serialVersionUID = -912306548467624772L;
    private String deptName;
    private Integer deptId;

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Dept() {

    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}