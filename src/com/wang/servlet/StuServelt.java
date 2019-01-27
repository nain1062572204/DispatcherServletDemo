package com.wang.servlet;

import com.wang.entity.Student;
import com.wang.util.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Rose
 * @create 2019/1/22
 * @since 1.0.0
 */
@WebServlet(urlPatterns = "/StuServlet/*")
public class StuServelt extends DispatcherServlet{
    private Student stu=new Student();
    private static final long serialVersionUID = -1994942721907332312L;

    public String list(HttpServletRequest request, HttpServletResponse response){
        //System.out.println("执行了list方法！");
        System.out.println(stu.toString());
        System.out.println(stu.getStuClass().toString());
        System.out.println(stu.getStuClass().getDept().toString());
        return "/list.jsp";
    }
    public String add(HttpServletRequest request, HttpServletResponse response){
        //System.out.println("执行了add方法！");
        return "/add.jsp";
    }

    public Student getStu() {
        return stu;
    }
}