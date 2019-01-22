package com.wang.servlet;

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
    public String list(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了list方法！");
        return "/list.jsp";
    }
    public String add(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了add方法！");
        return "/add.jsp";
    }
}