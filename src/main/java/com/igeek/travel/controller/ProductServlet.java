package com.igeek.travel.controller;

import com.igeek.travel.entity.Product;
import com.igeek.travel.service.CategoryService;
import com.igeek.travel.service.ProductService;
import com.igeek.travel.vo.PageVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/7 9:26
 */
@WebServlet(name="ProductServlet",urlPatterns = "/product")
public class ProductServlet extends BasicServlet{

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    //展示首页
    public void index(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //热门数据
        List<Product> hotProducts = productService.findHotProducts();

        //最新数据
        List<Product> newProducts = productService.findNewProducts();

        //跳转至页面中
        request.setAttribute("hotProducts",hotProducts);
        request.setAttribute("newProducts",newProducts);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    //通过商品类别和商品名称的分页查询列表
    public void findProducts(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String cid = request.getParameter("cid");
        String name = request.getParameter("pname");
        String page = request.getParameter("pageNow");

        //通过cid查询cname，并且放至请求域，供导航条使用
        if(cid!=null && !cid.equals("")){
            String cname = categoryService.findCname(cid);
            if(cname!=null){
                request.setAttribute("cname",cname);
            }
        }

        //搜索时的商品名称
        String pname = "";
        if(name==null){
            pname = "";
        }else{
            pname = name;
        }

        //分页的当前页码
        int pageNow = 1;
        if(page==null){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(page);
        }

        //查询商品列表
        PageVO<Product> vo = productService.findProducts(cid, pname, pageNow);
        request.setAttribute("vo",vo);


        //将浏览足迹信息，放至请求属性中
        Cookie[] cookies = request.getCookies();
        List<Product> historyList = new ArrayList<>();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie!=null && cookie.getName().equals("pids")){
                    String pids = cookie.getValue();
                    String[] split = pids.split("-"); //split [15,33,10,1]
                    for (int i = 0; i < split.length; i++) {
                        String pid = split[i];
                        historyList.add(productService.findProductByPid(pid));  //list 15  33  10  1
                    }
                }
            }
        }
        request.setAttribute("historyList",historyList);

        //请求转发
        request.getRequestDispatcher("product_list.jsp").forward(request,response);
    }


    //通过商品编号pid查询商品信息
    public void findProductByPid(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String pid = request.getParameter("pid");
        Product product = productService.findProductByPid(pid);
        request.setAttribute("product",product);

        //获取商品类别的名称
        String cname = request.getParameter("cname");
        if(cname!=null && !cname.equals("")){
            request.setAttribute("cname",cname);
        }

        //获取相关商品分页搜索的信息
        String cid = request.getParameter("cid");
        String pname = request.getParameter("pname");
        String pageNow = request.getParameter("pageNow");
        request.setAttribute("cid",cid);
        request.setAttribute("pname",pname);
        request.setAttribute("pageNow",pageNow);

        //默认第一次访问商品明细，产生Cookie足迹
        String value = pid;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie!=null && cookie.getName().equals("pids")){  //10-1-15
                    List<String> list = Arrays.asList(cookie.getValue().split("-"));  //{10,1,15}
                    //有序（输入顺序和输出顺序一致，分头分尾）
                    LinkedList<String> pidList = new LinkedList(list);
                    if(pidList.contains(pid)){  //1  --> {10,1,15}
                        pidList.remove(pid);    //{10,15}
                    }
                    pidList.addFirst(pid); //{1,10,15}

                    //集合  ->  pids存储进Cookie中
                    value = "";
                    for (String s : pidList) {
                        value+=s+"-";   //1-10-15-
                    }
                }
            }
        }

        //创建Cookie  1-10-15
        Cookie cookie = new Cookie("pids",value.substring(0,value.length()-1));
        //设置有效期
        cookie.setMaxAge(7*24*60*60);
        //将Cookie添加至响应中
        response.addCookie(cookie);

        request.getRequestDispatcher("product_info.jsp").forward(request,response);
    }
}
