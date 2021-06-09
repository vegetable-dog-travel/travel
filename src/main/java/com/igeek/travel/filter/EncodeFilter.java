package com.igeek.travel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//编码集过滤器
@WebFilter(filterName = "f1" , urlPatterns = "/*" ,
    initParams = @WebInitParam(name="encode",value = "utf-8"))
public class EncodeFilter implements Filter {

    private String encode;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encode);
        resp.setContentType("text/html;charset="+encode);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

}
