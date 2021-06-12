package com.igeek.travel.controller;

import com.igeek.travel.entity.Cart;
import com.igeek.travel.entity.CartItem;
import com.igeek.travel.entity.Product;
import com.igeek.travel.service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @version 1.0
 * @Description 购物车控制层
 * @Author chenmin
 * @Date 2021/6/8 11:03
 */
@WebServlet(name="CartServlet",urlPatterns = {"/cart"})
public class CartServlet extends BasicServlet {

    private ProductService productService = new ProductService();

    //加入购物车
    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获得请求参数
        //获得商品编号
        String pid = request.getParameter("pid");
        Product product = productService.findProductByPid(pid);
        //获得商品购买数量
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));
        //计算小计
        double subTotal = buyNum * product.getShop_price();


        //3.从会话中获取购物车Cart信息
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //若是第一次加入购物车
        if(cart==null){
            cart = new Cart();
        }

        //4.获取会话中购物车的明细CartItem信息
        Map<String, CartItem> map = cart.getMap();  //map  key->pid  value->CartItem

        double newSubTotal = subTotal;

        //5.判断购物车明细是否包含此次加入的商品信息
        if(map.containsKey(pid)){  //若包含则合并
            buyNum+=map.get(pid).getBuyNum();  //map.get(pid)  从会话中获取当前想要合并进来的商品信息
            newSubTotal = buyNum * map.get(pid).getProduct().getShop_price();
        }

        //6.购物车明细
        CartItem cartItem = new CartItem(product,buyNum,newSubTotal);

        //7.购物车
        map.put(pid,cartItem);
        //设置购物项
        cart.setMap(map);
        //设置总金额
        cart.setTotal(cart.getTotal()+subTotal);

        //8.会话作用域中添加cart信息
        session.setAttribute("cart",cart);
        //9.响应重定向至cart.jsp
        response.sendRedirect("cart.jsp");
    }


    //删除购物项
    public void delCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取请求参数中商品编号
        String pid = request.getParameter("pid");

        //2.从会话中获取购物车Cart的信息
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //3.获取Cart中的Map<String,CartItem>信息
        Map<String, CartItem> cartMap = cart.getMap();

        //4.重新计算购物车的总金额 = 原购物车的总金额 - 删除购物项的小计
        CartItem cartItem = cartMap.get(pid);
        cart.setTotal(cart.getTotal() - cartItem.getSubTotal());

        //5.移除当前商品的购物项
        cartMap.remove(pid);

        //6.将操作完成的Cart信息，返回至会话中
        cart.setMap(cartMap);
        session.setAttribute("cart",cart);

        //7.响应重定向至cart.jsp
        response.sendRedirect("cart.jsp");
    }


    //清空购物车
    public void clearCart(HttpServletRequest request , HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        response.sendRedirect("cart.jsp");
    }
}
