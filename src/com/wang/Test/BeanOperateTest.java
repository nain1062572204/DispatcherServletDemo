package com.wang.Test;

import com.wang.entity.Student;
import com.wang.util.BeanOperateTools;

/**
 * @author Rose
 * @create 2019/1/27
 * @since 1.0.0
 */
public class BeanOperateTest {


    public static void main(String[] args) {
        Student student=new Student();
        String attributeName="stu.stuName";
        String attributeValue="22";
        BeanOperateTools bo=new BeanOperateTools(student,attributeName,attributeValue);
        System.out.println(student.toString());
    }
}