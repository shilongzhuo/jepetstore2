package org.csu.mypetstore.controller;


import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.BlogService;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    CartService cartService;
    @Autowired
    BlogService blogService;

    //查看订单列表
    @GetMapping("/viewOrderList")
    public String viewOrderList(Model model){
        if(model.getAttribute("username")!=null){
            List<Order> orderList = orderService.getOrdersByUsername((String)model.getAttribute("username"));
            model.addAttribute("orderList",orderList);
            return "order/ListOrders";
        }else{

            //后期可能会改
            return "account/login";
        }
    }

//    //查看订单
//    @GetMapping("/viewOrder/{orderId}")
//    public String viewOrder(@PathVariable("orderId") int orderId, Model model){
//        Order order = orderService.getOrder(orderId);
//        model.addAttribute("order",order);
//        return "order/ViewOrder";
//    }
    //查看订单
    @GetMapping("/viewOrder")
    public String viewOrder(int orderId, Model model){
        Order order = orderService.getOrder(orderId);
        model.addAttribute("order",order);
        return "order/ViewOrder";
    }

    //判断购物车中的商品是否能够购买，跳转到订单页面
    @GetMapping("/creatOrder")
    public String creatOrder(Model model){

        if(model.getAttribute("username")==null){
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        }else{
            Cart cart = cartService.getCartByUsername((String)model.getAttribute("username"));
            boolean confirm = true;
            String message = "";
            List<CartItem> cartItemList = cart.getCartItemList();
            for(int i=0;i<cartItemList.size();i++){
                if(cartItemList.get(i).getItem().getProductId()==null){
                    //当有商品已经不再出售
                    confirm = false;
                    message += (cartItemList.get(i).getItem().getItemId() + "已经停止出售\n");
                }else if(!cartItemList.get(i).isInStock()){
                    //当有商品库存数目不够时返回错误信息
                    confirm = false;
                    message += (cartItemList.get(i).getItem().getItemId() + "的库存为" + cartItemList.get(i).getItem().getQuantity() + "\n");
                }
            }
            if(!confirm) {
                message += "请检查购物车中商品的数量";
                model.addAttribute("message_cart", message);
                return "cart/Cart";
            } else{
                return "order/NewOrders";
            }
        }
    }

    //创建订单
    @GetMapping("/newOrder")
    public String newOrder(Order order,Model model){
        if(model.getAttribute("username")==null){
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        }else{
            List<LineItem> lineItemList = new ArrayList<LineItem>();
            Cart cart = cartService.getCartByUsername((String)model.getAttribute("username"));
            boolean confirm = true;
            String message = "";
            List<CartItem> cartItemList = cart.getCartItemList();
            for(int i=0;i<cartItemList.size();i++){
                if(cartItemList.get(i).getItem().getProductId()==null){
                    //当有商品已经不再出售
                    confirm = false;
                    message += (cartItemList.get(i).getItem().getItemId() + "已经停止出售\n");
                }else if(!cartItemList.get(i).isInStock()){
                    //当有商品库存数目不够时返回错误信息
                    confirm = false;
                    message += (cartItemList.get(i).getItem().getItemId() + "的库存为" + cartItemList.get(i).getItem().getQuantity() + "\n");
                }
                LineItem lineItem = new LineItem();
                lineItem.setQuantity(cartItemList.get(i).getQuantity());
                lineItem.setItem(cartItemList.get(i).getItem());
                lineItem.setItemId(cartItemList.get(i).getItem().getItemId());
                lineItem.setUnitPrice(cartItemList.get(i).getItem().getUnitcost());
                lineItem.setTotal(cartItemList.get(i).getTotal());
                lineItemList.add(lineItem);
            }
            order.setLineItems(lineItemList);
            order.setOrderDate(new Date());

            if(!confirm) {
                message += "请检查购物车中商品的数量";
                model.addAttribute("message_cart", message);
                return "cart/Cart";
            } else{
                return "order/ConfirmOrder";
            }
        }
    }

    //订单最终确认
    @GetMapping("confirmOrder")
    public String ConfirmOrder(Model model){
        if(model.getAttribute("order")!=null&&model.getAttribute("username")!=null){
            orderService.insertOrder((Order) model.getAttribute("order"));
            cartService.delCartByUsername((String)model.getAttribute("username"));

            //添加日志
            Blog blog = new Blog();
            blog.setUsername((String)model.getAttribute("username"));
            blog.setOrderDate(((Order) model.getAttribute("order")).getOrderDate());
            blog.setDescription("creat order : "+((Order) model.getAttribute("order")).getOrderId());

            return "order/ConfirmOrder";
        }else{
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        }
    }


}
