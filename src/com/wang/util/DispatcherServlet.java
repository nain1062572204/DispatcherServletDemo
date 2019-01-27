package com.wang.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;


/**
 * @author Rose
 * @create 2019/1/22
 * @since 1.0.0
 */
public abstract class DispatcherServlet extends HttpServlet{

    private static final long serialVersionUID = -8469366810145687882L;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认的跳转路径
        String path="/error.jsp";
        //处理参数
        handleParameters(request);
        //获取请求路径
        String uri=request.getRequestURI();
        //获取请求方法
        String methodName=uri.substring(uri.lastIndexOf("/")+1);
        //System.out.println("methodName="+methodName);
        //通过反射调用方法
        try {
            Method method=this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            path= (String) method.invoke(this,request,response);//反射调用
            //System.out.println(path);
        } catch (Exception e) {

        }
        //跳转
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    public void handleParameters(HttpServletRequest request){
        Enumeration enu=request.getParameterNames();
        while (enu.hasMoreElements()){
            //获取参数名
            String parameterName= (String) enu.nextElement();
            if(parameterName.contains(".")){
                //获取子类需要装配的对象名
                String entityName=parameterName.substring(0,parameterName.indexOf("."));
                //找到对象的get方法
                try {
                    Method method=this.getClass().getMethod("get"+StringUtils.getInstance().initcap(entityName));
                    //自动装配
                    BeanOperateTools bo=new BeanOperateTools(
                            method.invoke(this),parameterName
                    );
                    bo.handleString();
                    bo.setValue(request.getParameter(parameterName));
                    bo.setFieldValue();
                } catch (Exception e) {

                }

            }

        }
    }
}