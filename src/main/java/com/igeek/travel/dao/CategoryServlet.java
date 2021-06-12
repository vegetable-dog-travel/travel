package com.igeek.travel.dao;

import com.google.gson.Gson;
import com.igeek.travel.entity.Category;
import com.igeek.travel.service.CategoryService;
import com.igeek.travel.controller.BasicServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/7 10:22
 */
@WebServlet(name="CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BasicServlet {

    private CategoryService categoryService = new CategoryService();
    
    //查询商品分类的列表
    public void findAllCategories(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategories();

        //json数据
        Gson gson = new Gson();
        String json = gson.toJson(categories);

        //将json数据响应至客户端
        response.getWriter().write(json);
    }

}
