package com.wang.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * @author Rose
 * @create 2019/1/22
 * @since 1.0.0
 */
public abstract class DispatcherServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认的跳转路径
        String path="/error.jsp";
        //获取请求路径
        String uri=request.getRequestURI();
        //获取请求方法
        String methodName=uri.substring(uri.lastIndexOf("/")+1);
        System.out.println("methodName="+methodName);
        //通过反射调用方法
        try {
            Method method=this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            path= (String) method.invoke(this,request,response);//反射调用
            System.out.println(path);
        } catch (Exception e) {

        }
        //跳转
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}