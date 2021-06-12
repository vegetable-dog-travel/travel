package com.igeek.travel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "f2" , urlPatterns = "/orders/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user==null){ //未登录
            request.setAttribute("msg","该资源必须登录后访问");
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,resp);
            return;
        }
        //过滤链
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
