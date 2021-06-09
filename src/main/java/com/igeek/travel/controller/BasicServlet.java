package com.igeek.travel.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description 通过反射技术，定义一个BasicServlet
 * @Author chenmin
 * @Date 2021/6/5 14:28
 */
@WebServlet
public class BasicServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数   method的名称
        String methodName = request.getParameter("method");

        //获取当前正在执行的Servlet的类类型
        Class<? extends BasicServlet> clazz = this.getClass();

        try {
            //获得方法对象，忽略访问权限修饰符
            Method method = clazz.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

            //执行目标方法
            method.invoke(this, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
