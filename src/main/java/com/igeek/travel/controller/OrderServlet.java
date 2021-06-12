package com.igeek.travel.controller;

import com.igeek.common.utils.CommonUtils;
import com.igeek.travel.entity.*;
import com.igeek.travel.service.OrderService;
import com.igeek.travel.vo.PageVO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/9 11:06
 */
@WebServlet(name = "OrderServlet" , urlPatterns = "/orders")
public class OrderServlet extends BasicServlet {

    private OrderService orderService = new OrderService();

    //提交订单
    public void submitOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //大前提  已登录
        HttpSession session = request.getSession();
        //获取会话中的登陆者信息
        User user = (User) session.getAttribute("user");
        //获取会话中购物车信息
        Cart cart = (Cart) session.getAttribute("cart");

        //创建订单对象
        Orders orders = new Orders();

        //设置订单编号
        orders.setOid(CommonUtils.getUUID().replaceAll("-",""));
        //设置下单时间
        orders.setOrdertime(new Date());
        //设置下单状态  0未支付
        orders.setState(0);
        //设置该订单的下单者信息
        orders.setUser(user);
        //设置订单总金额
        orders.setTotal(cart.getTotal());

        //获取购物车中的明细项
        Map<String, CartItem> cartMap = cart.getMap();
        Set<Map.Entry<String, CartItem>> entries = cartMap.entrySet();
        //将购物车明细entry.getValue()   -->   订单明细
        for (Map.Entry<String, CartItem> entry : entries) {
            //创建订单明细对象
            OrderItem orderItem = new OrderItem();
            //设置订单明细的编号  insert语句
            //设置购买商品
            orderItem.setProduct(entry.getValue().getProduct());
            //设置购买数量
            orderItem.setCount(entry.getValue().getBuyNum());
            //设置小计
            orderItem.setSubtotal(entry.getValue().getSubTotal());
            //设置所属订单
            orderItem.setOrders(orders);

            //将当前订单明细添加至订单中
            orders.getList().add(orderItem);
        }

        //提交订单
        boolean flag = orderService.submitOrders(orders);
        if(flag){
            //会话域中存储orders订单信息
            session.setAttribute("orders",orders);
            //响应重定向至order_info.jsp
            response.sendRedirect("order_info.jsp");
        }else{
            request.setAttribute("msg","订单提交失败");
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }


    }

    //确认订单（支付）
    public void confirmOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获得请求参数
        Map<String, String[]> map = request.getParameterMap();

        //获取会话中的Orders信息
        HttpSession session = request.getSession();
        Orders orders = (Orders) session.getAttribute("orders");

        try {
            //更新订单Orders中的收货人信息
            BeanUtils.populate(orders,map);
            boolean flag = orderService.updateUserOrders(orders);

            //跳转
            if(flag){
                //更新成功
                String type = request.getParameter("pd_FrpId");
                if("alipay".equals(type)){
                    //支付宝支付 ，调用支付接口
                    response.sendRedirect("alipay.trade.page.pay.jsp");
                }
            }else{
                //更新失败
                request.setAttribute("msg","更新收货人信息失败");
                request.getRequestDispatcher("order_info.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    //查看我的订单
    public void viewMyOrders(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取会话中登陆者的信息
        User user = (User)session.getAttribute("user");

        //获取请求参数中的当前页码
        String page = request.getParameter("pageNow");

        //查询当前登录者的订单
        PageVO<Orders> vo = orderService.viewOrders(user.getUid(), page);

        //通过订单编号，获取订单明细及其商品信息
        List<Orders> ordersList = vo.getList();
        for (Orders orders : ordersList) {
            //获取订单编号
            String oid = orders.getOid();
            //通过订单编号查询，返回订单明细及其商品信息
            List<Map<String, Object>> mapList = orderService.findItemsAndProduct(oid);
            for (Map<String, Object> map : mapList) {  //Map中的entry  key-->表中的字段名  value-->表中字段对应的值
                //封装Product商品对象
                Product product =  new Product();
                //封装OrderItem订单明细对象
                OrderItem orderItem = new OrderItem();
                try {
                    //直接装配上属性值
                    BeanUtils.populate(product,map);
                    BeanUtils.populate(orderItem,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                //将Product商品信息，设置进OrderItem订单明细信息中
                orderItem.setProduct(product);
                //将orders订单信息，设置进OrderItem订单明细信息中
                orderItem.setOrders(orders);

                //将OrderItem订单明细信息，设置进orders订单中
                orders.getList().add(orderItem);
            }
        }

        request.setAttribute("vo",vo);  //仅仅只有订单表数据，而并没有订单明细（也没有商品数据）
        request.getRequestDispatcher("order_list.jsp").forward(request,response);
    }
}
