package com.igeek.travel.controller;

import com.google.gson.Gson;
import com.igeek.common.utils.CommonUtils;
import com.igeek.common.utils.ExcelUtil;
import com.igeek.travel.entity.*;
import com.igeek.travel.service.AdminService;
import com.igeek.travel.vo.HomeVO;
import com.igeek.travel.vo.PageVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
@MultipartConfig
public class AdminServlet extends BasicServlet {

    private AdminService service = new AdminService();

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");

        HttpSession session = request.getSession();
        Admin admin = service.login(adminName, adminPwd);
        if(admin!=null){
           session.setAttribute("admin", admin);
           response.sendRedirect(request.getContextPath()+"/admin/home/home.jsp");
        }else{
            request.setAttribute("msg", "用户名或密码不匹配");
            request.getRequestDispatcher(request.getContextPath()+"/admin/login.jsp").forward(request, response);
        }
    }

    //登出
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
    }

    //显示首页
    public void showIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<HomeVO> list = service.showIndex();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().write(json);
    }

    //查询所有(会员查询所有、商品查询所有、订单查询所有)
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("pageNow");
        String query = request.getParameter("query");

        int pageNow = 1;
        if(page!=null){
            pageNow = Integer.parseInt(page);
        }
        if(query==null){
            query = "";
        }

        PageVO vo = service.findAll(query, pageNow);

        request.setAttribute("vo", vo);
        request.setAttribute("query", query);

        //若code是product时，跳转到商品管理界面
        request.getRequestDispatcher(request.getContextPath()+"/admin/product/product.jsp").forward(request, response);
    }

    //通过商品编号查询商品信息
    public void findOneById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        List<Map<String, Object>> mapList = service.findOneById(pid);  //key->表中的字段名  value->表中的字段值

        //处理时间
        mapList.forEach((map)->{
            Date pdate = (Date)map.get("pdate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(pdate);
            map.put("pdate",date);
        });

        //以json数据格式传递
        Gson gson = new Gson();
        String json = gson.toJson(mapList);
        response.getWriter().write(json);
    }

    //查询所有商品类别
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Category> list = service.findAllCategory();
        Gson gson = new Gson();
        String s = gson.toJson(list);
        response.getWriter().write(s);
    }

    //更新商品
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //将请求参数的值，装配进Product对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        Product product = new Product();

        //处理日期
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class aClass, Object o) {
                Date date = null;
                if(o instanceof String){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        date = sdf.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return date;
            }
        },Date.class);

        //商品类别
        String cid = request.getParameter("categoryId");
        Category category = service.findOneCategoryByCid(cid);
        product.setCategory(category);

        try {
            BeanUtils.populate(product,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //图片上传
        Part part = request.getPart("file");
        if(part!=null){
            String oldName = part.getHeader("content-disposition");

            if(oldName!=null && oldName.indexOf(".")>0){
                //上传图片，将其信息直接存储至Product对象中
                String newName = CommonUtils.getUUID()+oldName.substring(oldName.lastIndexOf("."),oldName.length()-1);
                product.setPimage("/temp/"+newName);
                part.write("E:\\93\\5.JSP+Servlet\\temp\\"+newName);
            }else{
                //未上传图片，获取原图片信息，设置进Product对象中
                List<Map<String, Object>> mapList = service.findOneById(request.getParameter("pid"));
                mapList.forEach((map)->{
                    String pimage = map.get("pimage").toString();
                    if(pimage!=null && !pimage.equals("")){
                        product.setPimage(pimage);
                    }
                });
            }
        }

        //更新商品
        boolean flag = service.update(product);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/admin?method=findAll");
        }
    }

    //商品导出
    public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //表格表头信息
        String[] title = {"商品编号","商品名称","商品描述","商品价格","商品图片","商品日期"};
        String[] prop = {"pid","pname","pdesc","shop_price","pimage","pdate"};
        //excel的名字
        String fileName = "goods.xls";
        //sheet页的名字
        String sheetName = "商品详情";
        //数据
        List<Product> goods = service.findAll("",1).getList();

        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title,prop, goods, null);

        //输出文件
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        OutputStream os = response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
    }
}
