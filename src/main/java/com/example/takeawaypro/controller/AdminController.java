package com.example.takeawaypro.controller;

import com.example.takeawaypro.bean.Order;
import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.service.AdminService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/getorders")
    public Result<LinkedList<Order>> getorders(){
        return Result.success(adminService.getorders());
    }
    @RequestMapping("/go")
    public Result<LinkedList<Order>> go(@RequestParam String user_id){
        System.out.println("要查询的用户名为:"+user_id);
        return Result.success(adminService.go(user_id));
    }
    @RequestMapping("/del_order")
    public Result del_order(@RequestParam String order_id){
        int n = adminService.del_order(Integer.parseInt(order_id));
        if(n>0) return Result.success();
        else return Result.error("订单删除错误");
    }

    @RequestMapping("/addfood")
    public Result addfood(@RequestParam String cookingpin_name,@RequestParam String cookingxi_name,
    @RequestParam String picture,@RequestParam String price,@RequestParam String introduce){
        System.out.println("添加菜品信息为："+cookingpin_name+" "+cookingxi_name+" "+picture+" "+price+" "+introduce);
        int n=adminService.addfood(0,cookingpin_name,Float.parseFloat(price),picture,introduce,cookingxi_name);
        if(n>0) return Result.success();
        else return Result.error("菜品添加错误");
    }

    @RequestMapping("/del_foodpin")
    public Result del_foodpin(@RequestParam String cookingpin_id, HttpServletResponse response){
        System.out.println("要铲除的菜品为:"+cookingpin_id);
        try {
            int n = adminService.del_foodpin(Integer.parseInt(cookingpin_id));
            System.out.println("删除受影响的行数:" + n);
            return Result.success();
        } catch (Exception e) {
            response.setStatus(900);
            return Result.error("还有订单");
        }
    }


}
