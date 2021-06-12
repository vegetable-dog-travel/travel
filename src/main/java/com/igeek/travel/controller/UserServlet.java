package com.igeek.travel.controller;

import com.igeek.common.utils.CommonUtils;
import com.igeek.common.utils.MD5Utils;
import com.igeek.common.utils.MailUtils;
import com.igeek.shop.entity.User;
import com.igeek.shop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/5 14:24
 */
@WebServlet(name="UserServlet" , urlPatterns = "/user")
public class UserServlet extends BasicServlet {

    private UserService userService = new UserService();

    //注册
    public void register(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException, ServletException, IOException, MessagingException {
        //获得JSP页面中的form表单中请求参数
        Map<String, String[]> map = request.getParameterMap();

        //封装
        User user = new User();

        //自定义一个转换器   String -->  Date
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class clazz, Object o) {
                if(o instanceof String){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date date = sdf.parse(o.toString());
                        return date;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }, Date.class);

        //工具类  BeanUtils
        /**
         * BeanUtils.populate(Object,Map)  将Map集合中的键值对的值，填充至Object对象中
         * 第一个参数Object obj：目标填充对象
         * 第二个参数Map map：封装了请求参数数据的集合
         */
        BeanUtils.populate(user,map);
        //加密后的密码
        String password = MD5Utils.md5(map.get("password")[0]);
        user.setPassword(password);

        //user对象设置uid
        String uid = CommonUtils.getUUID().replaceAll("-","");
        user.setUid(uid);

        //user对象设置code激活码
        String code = CommonUtils.getUUID().replaceAll("-","");
        user.setCode(code);

        //System.out.println("user = "+user);

        //实现注册功能
        boolean flag = userService.register(user);
        if(flag){
            //注册成功

            //通过邮箱，给注册者发送一份邮件，邮件中包含激活码
            String emailMsg = "<a href='http://192.168.22.11:8899/user?method=active&code="+code+"'>请点击此码"+code+"激活账户</a>";
            MailUtils.sendMail(user.getEmail(),"激活账户",emailMsg);

            request.getRequestDispatcher("registSuccess.jsp").forward(request,response);
        }else{
            //注册失败
            request.getRequestDispatcher("registFail.jsp").forward(request,response);
        }
    }

    //激活
    public void active(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //获取激活码
        String code = request.getParameter("code");
        boolean flag = userService.active(code);
        if(flag){
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }

    //校验昵称是否存在
    public void validate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //获取姓名
        String username = request.getParameter("username");
        //校验
        boolean flag = userService.validate(username);

        //响应数据  json格式 {"flag":flag}
        String str = "{\"flag\":"+flag+"}";

        //json数据，响应至客户端
        PrintWriter out = response.getWriter();
        out.write(str);
        out.flush();
        out.close();
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name = request.getParameter("name");
        String pwd = MD5Utils.md5(request.getParameter("pwd"));

        User user = userService.login(name, pwd);
        if(user!=null){
            int state = user.getState();
            switch (state){
                case 0:
                    //未激活
                    request.setAttribute("msg","当前账户未激活，请尽快前往邮箱激活账户");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    break;
                case 1:
                    //已激活
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                    break;
            }
        }else{
            request.setAttribute("msg","当前账户和密码不匹配");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    //登出
    public void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("home.jsp");
    }
}
